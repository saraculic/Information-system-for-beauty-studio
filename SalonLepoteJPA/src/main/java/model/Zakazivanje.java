package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zakazivanje database table.
 * 
 */
@Entity
@NamedQuery(name="Zakazivanje.findAll", query="SELECT z FROM Zakazivanje z")
public class Zakazivanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZakazivanje;

//	@Temporal(TemporalType.TIMESTAMP)
	@Temporal(TemporalType.DATE)
	private Date datum;

	private String vreme;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Usluga
	@ManyToOne
	@JoinColumn(name="idUsluga")
	private Usluga usluga;

	//bi-directional many-to-one association to Zaposlen
	@ManyToOne
	@JoinColumn(name="idZaposlen")
	private Zaposlen zaposlen;

	public Zakazivanje() {
	}

	public int getIdZakazivanje() {
		return this.idZakazivanje;
	}

	public void setIdZakazivanje(int idZakazivanje) {
		this.idZakazivanje = idZakazivanje;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Usluga getUsluga() {
		return this.usluga;
	}

	public void setUsluga(Usluga usluga) {
		this.usluga = usluga;
	}

	public Zaposlen getZaposlen() {
		return this.zaposlen;
	}

	public void setZaposlen(Zaposlen zaposlen) {
		this.zaposlen = zaposlen;
	}

}