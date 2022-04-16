package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the salon_korisnik database table.
 * 
 */
@Entity
@Table(name="salon_korisnik")
@NamedQuery(name="SalonKorisnik.findAll", query="SELECT s FROM SalonKorisnik s")
public class SalonKorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ime;

	private String password;

	private String prezime;

	private String username;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="korisniks")
	private List<Uloga> ulogas =new ArrayList<Uloga>();

	public SalonKorisnik() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Uloga> getUlogas() {
		return ulogas;
	}

	public void setUlogas(List<Uloga> ulogas) {
		this.ulogas = ulogas;
	}
	
	public void setUloge(List<Uloga> uloge) {
		this.ulogas = uloge;
	}
	
	public void dodajUlogu(Uloga u) {
		this.ulogas.add(u);
	}

}