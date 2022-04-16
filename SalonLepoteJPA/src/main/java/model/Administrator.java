package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the administrator database table.
 * 
 */
@Entity
@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrator;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	private String tel;

	private String username;

	//bi-directional many-to-one association to Usluga
	@OneToMany(mappedBy="administrator")
	private List<Usluga> uslugas;

	//bi-directional many-to-one association to Zaposlen
	@OneToMany(mappedBy="administrator")
	private List<Zaposlen> zaposlens;

	public Administrator() {
	}

	public int getIdAdministrator() {
		return this.idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Usluga> getUslugas() {
		return this.uslugas;
	}

	public void setUslugas(List<Usluga> uslugas) {
		this.uslugas = uslugas;
	}

	public Usluga addUsluga(Usluga usluga) {
		getUslugas().add(usluga);
		usluga.setAdministrator(this);

		return usluga;
	}

	public Usluga removeUsluga(Usluga usluga) {
		getUslugas().remove(usluga);
		usluga.setAdministrator(null);

		return usluga;
	}

	public List<Zaposlen> getZaposlens() {
		return this.zaposlens;
	}

	public void setZaposlens(List<Zaposlen> zaposlens) {
		this.zaposlens = zaposlens;
	}

	public Zaposlen addZaposlen(Zaposlen zaposlen) {
		getZaposlens().add(zaposlen);
		zaposlen.setAdministrator(this);

		return zaposlen;
	}

	public Zaposlen removeZaposlen(Zaposlen zaposlen) {
		getZaposlens().remove(zaposlen);
		zaposlen.setAdministrator(null);

		return zaposlen;
	}

}