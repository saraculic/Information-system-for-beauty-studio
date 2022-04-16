package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usluga database table.
 * 
 */
@Entity
@NamedQuery(name="Usluga.findAll", query="SELECT u FROM Usluga u")
public class Usluga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsluga;

	private int cena;

	private String naziv;

	@Lob
	private byte[] slika;

	//bi-directional many-to-one association to Slika
	@OneToMany(mappedBy="usluga")
	private List<Slika> slikas;

	//bi-directional many-to-one association to Slobodantermin
	@OneToMany(mappedBy="usluga")
	private List<Slobodantermin> slobodantermins;

	//bi-directional many-to-one association to Administrator
	@ManyToOne
	@JoinColumn(name="idAdministrator")
	private Administrator administrator;

	//bi-directional many-to-one association to Zakazivanje
	@OneToMany(mappedBy="usluga")
	private List<Zakazivanje> zakazivanjes;

	public Usluga() {
	}

	public int getIdUsluga() {
		return this.idUsluga;
	}

	public void setIdUsluga(int idUsluga) {
		this.idUsluga = idUsluga;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public List<Slika> getSlikas() {
		return this.slikas;
	}

	public void setSlikas(List<Slika> slikas) {
		this.slikas = slikas;
	}

	public Slika addSlika(Slika slika) {
		getSlikas().add(slika);
		slika.setUsluga(this);

		return slika;
	}

	public Slika removeSlika(Slika slika) {
		getSlikas().remove(slika);
		slika.setUsluga(null);

		return slika;
	}

	public List<Slobodantermin> getSlobodantermins() {
		return this.slobodantermins;
	}

	public void setSlobodantermins(List<Slobodantermin> slobodantermins) {
		this.slobodantermins = slobodantermins;
	}

	public Slobodantermin addSlobodantermin(Slobodantermin slobodantermin) {
		getSlobodantermins().add(slobodantermin);
		slobodantermin.setUsluga(this);

		return slobodantermin;
	}

	public Slobodantermin removeSlobodantermin(Slobodantermin slobodantermin) {
		getSlobodantermins().remove(slobodantermin);
		slobodantermin.setUsluga(null);

		return slobodantermin;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<Zakazivanje> getZakazivanjes() {
		return this.zakazivanjes;
	}

	public void setZakazivanjes(List<Zakazivanje> zakazivanjes) {
		this.zakazivanjes = zakazivanjes;
	}

	public Zakazivanje addZakazivanje(Zakazivanje zakazivanje) {
		getZakazivanjes().add(zakazivanje);
		zakazivanje.setUsluga(this);

		return zakazivanje;
	}

	public Zakazivanje removeZakazivanje(Zakazivanje zakazivanje) {
		getZakazivanjes().remove(zakazivanje);
		zakazivanje.setUsluga(null);

		return zakazivanje;
	}

}