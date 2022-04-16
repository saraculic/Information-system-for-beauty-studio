package domain;

import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;
public class SlikaSlika {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idUsluga;

	private int cena;

	private String naziv;
	
	@Lob
	private MultipartFile slika;
	
	public SlikaSlika() {}

	public int getIdUsluga() {
		return idUsluga;
	}

	public void setIdUsluga(int idUsluga) {
		this.idUsluga = idUsluga;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public MultipartFile getSlika() {
		return slika;
	}

	public void setSlika(MultipartFile slika) {
		this.slika = slika;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
