package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the uloga database table.
 * 
 */
@Entity
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUloga;

	private String naziv;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="salon_korisnik_uloga", joinColumns = @JoinColumn(name = "idUloga",referencedColumnName = "idUloga"),inverseJoinColumns = @JoinColumn(name = "id"))
	private List<SalonKorisnik> korisniks =new ArrayList<SalonKorisnik>();

	public Uloga() {
	}

	public int getIdUloga() {
		return this.idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public List<SalonKorisnik> getKorisniks() {
		return korisniks;
	}

	public void setKorisniks(List<SalonKorisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public void addKorisnik(SalonKorisnik k) {
		this.korisniks.add(k);
	}

}