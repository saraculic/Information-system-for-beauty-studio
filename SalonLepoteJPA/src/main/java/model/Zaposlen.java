package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zaposlen database table.
 * 
 */
@Entity
@NamedQuery(name="Zaposlen.findAll", query="SELECT z FROM Zaposlen z")
public class Zaposlen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZaposlen;

	private String ime;

	private String password;

	private int plata;

	private String prezime;

	private String tel;

	private String username;

	//bi-directional many-to-one association to Slobodantermin
	@OneToMany(mappedBy="zaposlen")
	private List<Slobodantermin> slobodantermins;

	//bi-directional many-to-one association to Zakazivanje
	@OneToMany(mappedBy="zaposlen")
	private List<Zakazivanje> zakazivanjes;

	//bi-directional many-to-one association to Administrator
	@ManyToOne
	@JoinColumn(name="idAdministrator")
	private Administrator administrator;

	public Zaposlen() {
	}

	public int getIdZaposlen() {
		return this.idZaposlen;
	}

	public void setIdZaposlen(int idZaposlen) {
		this.idZaposlen = idZaposlen;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPlata() {
		return this.plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Slobodantermin> getSlobodantermins() {
		return this.slobodantermins;
	}

	public void setSlobodantermins(List<Slobodantermin> slobodantermins) {
		this.slobodantermins = slobodantermins;
	}

	public Slobodantermin addSlobodantermin(Slobodantermin slobodantermin) {
		getSlobodantermins().add(slobodantermin);
		slobodantermin.setZaposlen(this);

		return slobodantermin;
	}

	public Slobodantermin removeSlobodantermin(Slobodantermin slobodantermin) {
		getSlobodantermins().remove(slobodantermin);
		slobodantermin.setZaposlen(null);

		return slobodantermin;
	}

	public List<Zakazivanje> getZakazivanjes() {
		return this.zakazivanjes;
	}

	public void setZakazivanjes(List<Zakazivanje> zakazivanjes) {
		this.zakazivanjes = zakazivanjes;
	}

	public Zakazivanje addZakazivanje(Zakazivanje zakazivanje) {
		getZakazivanjes().add(zakazivanje);
		zakazivanje.setZaposlen(this);

		return zakazivanje;
	}

	public Zakazivanje removeZakazivanje(Zakazivanje zakazivanje) {
		getZakazivanjes().remove(zakazivanje);
		zakazivanje.setZaposlen(null);

		return zakazivanje;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

}