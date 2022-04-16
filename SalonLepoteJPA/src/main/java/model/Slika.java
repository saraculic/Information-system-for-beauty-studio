package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the slika database table.
 * 
 */
@Entity
@NamedQuery(name="Slika.findAll", query="SELECT s FROM Slika s")
public class Slika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlika;

	private int idAdministrator;

	private String url;

	//bi-directional many-to-one association to Usluga
	@ManyToOne
	@JoinColumn(name="idUsluga")
	private Usluga usluga;

	public Slika() {
	}

	public int getIdSlika() {
		return this.idSlika;
	}

	public void setIdSlika(int idSlika) {
		this.idSlika = idSlika;
	}

	public int getIdAdministrator() {
		return this.idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	} 
	
	public Usluga getUsluga() {
		return this.usluga;
	}

	public void setUsluga(Usluga usluga) {
		this.usluga = usluga;
	}

}