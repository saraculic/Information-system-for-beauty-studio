package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the slobodantermin database table.
 * 
 */
@Entity
@NamedQuery(name="Slobodantermin.findAll", query="SELECT s FROM Slobodantermin s")
public class Slobodantermin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlobodanTermin;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String vreme;

	//bi-directional many-to-one association to Usluga
	@ManyToOne
	@JoinColumn(name="idUsluga")
	private Usluga usluga;

	//bi-directional many-to-one association to Zaposlen
	@ManyToOne
	@JoinColumn(name="idZaposlen")
	private Zaposlen zaposlen;

	public Slobodantermin() {
	}

	public int getIdSlobodanTermin() {
		return this.idSlobodanTermin;
	}

	public void setIdSlobodanTermin(int idSlobodanTermin) {
		this.idSlobodanTermin = idSlobodanTermin;
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