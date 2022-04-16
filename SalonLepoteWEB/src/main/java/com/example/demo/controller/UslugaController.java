package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.AdministratorRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.SlikaRepository;
import com.example.demo.repository.SlobodanTerminRepository;
import com.example.demo.repository.UslugaRepository;
import com.example.demo.repository.ZakazivanjeRepository;
import com.example.demo.repository.ZaposlenRepository;
import com.example.demo.security.UslugaConverter;

import domain.SlikaSlika;
import model.Korisnik;
import model.SalonKorisnik;
import model.Slika;
import model.Slobodantermin;
import model.Usluga;
import model.Zakazivanje;
import model.Zaposlen;

@Controller
@RequestMapping("/usluge")
public class UslugaController {

	@Autowired
	UslugaRepository ur;
	
	@Autowired
	AdministratorRepository ar;
	
	@Autowired 
	ZaposlenRepository zr;
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	ZakazivanjeRepository zakr;
	
	@Autowired
	SlobodanTerminRepository str;
	
	@Autowired
	SlikaRepository sr;
	
	
	@RequestMapping(value = "/dodajUsluguDugme", method = RequestMethod.GET)
	public String dodajUsluguDugme(HttpServletRequest request, Model m) {
		m.addAttribute("slikaa", new SlikaSlika());
		request.setAttribute("dodaj", "Unesite podatke za unos nove usluge");
		return "dodajUslugu";
	}
	
	
//					 DODAVANJE NOVE USLUGE, ALI BEZ SLIKE
//	@RequestMapping(value = "/dodajUslugu", method = RequestMethod.POST)
//	public String dodajUslugu(String naziv, Integer cena, HttpServletRequest request) {
//		Usluga u = new Usluga();
//		u.setNaziv(naziv);
//		u.setCena(cena);
//		ur.save(u);
//		request.setAttribute("dodataUsluga", "Nova usluga u salonu dodata! :)");
//		return "sveUsluge";
//	}
	
	@RequestMapping(value = "/dodajUslugu", method = RequestMethod.POST)
	public String dodajUslugu(String naziv, Integer cena, SlikaSlika slikaa,  HttpServletRequest request) {
		MultipartFile file = slikaa.getSlika();
		if(file != null) {
			String fileName = file.getOriginalFilename();
			String filePath;
			try {
				filePath = System.getProperty("user.dir");
				System.out.println("Putanja je "+filePath);
				File imageFile = new File(filePath, fileName);
				
				file.transferTo(imageFile);
				Usluga u = new Usluga();
				u.setNaziv(naziv);
				u.setCena(cena);
				u.setSlika(Files.readAllBytes(imageFile.toPath()));
				ur.save(u);
				request.getSession().setAttribute("usluga", u);
				request.setAttribute("dodataUsluga", "Nova usluga u salonu dodata! :)");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return "sveUsluge";
	}
	
	@RequestMapping(value = "/getSveUsluge", method = RequestMethod.GET)
	public String getSveUsluge(HttpServletRequest request) {
		List<Usluga> sveUsluge = ur.findAll();
		request.setAttribute("sveUsluge", sveUsluge);
		request.setAttribute("novaCena", "Unesite novu cenu:");
		return "azuriranjeUsluge";
	}
	
	@RequestMapping(value = "/sveUsluge", method = RequestMethod.GET)
	public String sveUsluge(HttpServletRequest request) {
		List<Usluga> sveUsluge = ur.findAll();
		request.setAttribute("sveUsluge", sveUsluge);
		return "galerija";
	}
	
	@RequestMapping(value = "/getSveUslugeZaBrisanje", method = RequestMethod.GET)
	public String getSveUslugeZaBrisanje(HttpServletRequest request) {
		List<Usluga> sveUsluge = ur.findAll();
		request.setAttribute("sveUslugeZaBrisanje", sveUsluge);
		return "izbrisiUslugu";
	}
	
	
	@RequestMapping(value = "/azurirajCenu", method = RequestMethod.POST)
	public String azurirajUslugu(Integer idUsluga, Integer novaCena, HttpServletRequest request) {
		Usluga u = ur.findById(idUsluga).get();
		u.setCena(novaCena);
		ur.save(u);
		request.setAttribute("azuriranaCena", "Uspesno ste azurirali cenu");
		return "azuriranjeUsluge";
	}
	
	@RequestMapping(value = "/brisanjeUsluge", method = RequestMethod.POST)
	public String brisanjeUsluge(Integer idUsluga, HttpServletRequest request) {
		Usluga u = ur.findById(idUsluga).get();
		
		List<Zakazivanje> zakazivanja = zakr.findByUsluga(u);
		for (Zakazivanje i : zakazivanja) {
			zakr.delete(i);
		}
		
		List<Slika> slike = sr.findByUsluga(u);
		for (Slika s : slike) {
			sr.delete(s);
		}
		
		List<Slobodantermin> termini = str.findByUsluga(u);
		for (Slobodantermin l : termini) {
			str.delete(l);
		}
		
		ur.delete(u);
		request.setAttribute("obrisana", "Uspesno ste obrisali uslugu");
		return "sveUsluge";
	}
	
	@RequestMapping(value = "/slobodnitermini", method = RequestMethod.GET)
	public String slobodniTermini(HttpServletRequest request) {
		
		UslugaConverter uslugaCon = new UslugaConverter(ur);
		Usluga u = uslugaCon.convert(request.getParameter("idUsluga"));
		
		List<Slobodantermin> termini = str.findByUsluga(u);
		request.getSession().setAttribute("slobodnitermini", termini);
		
		List<Zaposlen> zaposleni =  zr.findAll();
		request.getSession().setAttribute("zaposleni", zaposleni);
		return "slobodnitermini";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
	}
	
	@RequestMapping(value = "/zakaziTermin", method = RequestMethod.GET)
	public String zakaziTermin(HttpServletRequest request) {
		SalonKorisnik sk = (SalonKorisnik) request.getSession().getAttribute("logovanKorisnik");
		String ime = sk.getIme();
		String prezime = sk.getPrezime();
		Korisnik korisnik = kr.findByImeAndPrezime(ime, prezime);
		
		Integer idSlobodanTermin = Integer.parseInt(request.getParameter("idSlobodanTermin"));
		Slobodantermin termin = str.findById(idSlobodanTermin).get();
		
		Zakazivanje z = new Zakazivanje();
		z.setKorisnik(korisnik);
		z.setDatum(termin.getDatum());
		z.setVreme(termin.getVreme());
		z.setUsluga(termin.getUsluga());
		z.setZaposlen(termin.getZaposlen());
		zakr.save(z);
		korisnik.addZakazivanje(z);
		
//		System.out.println("Sva zakazivanja ovog korisnika:");
//		for(Zakazivanje zak : korisnik.getZakazivanjes()) {
//			System.out.println(zak.getDatum() + " " + zak.getVreme());
//		}
		
		str.delete(termin);	//REZERVISAN TERMIN, VISE NIJE SLOBODAN, BRISEMO GA IZ TABELE
		request.setAttribute("zakazan", "ZAKAZAN TERMIN");
		return "zakazivanje";
	}
	
	
	@RequestMapping(value = "/prikaziSlike", method = RequestMethod.GET)
	public String prikaziSlike(HttpServletRequest request) {
		Integer idUsluga = Integer.parseInt(request.getParameter("idUsluga"));
		Usluga u = ur.findById(idUsluga).get();
		
		List<Slika> slike = sr.findByUsluga(u);
		request.getSession().setAttribute("slike", slike);
		request.getSession().setAttribute("izabranaUsluga", u);
		return "galerija";
	}
}
