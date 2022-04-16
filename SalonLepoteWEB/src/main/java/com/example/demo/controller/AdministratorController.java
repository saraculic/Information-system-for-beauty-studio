package com.example.demo.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.AdministratorRepository;
import com.example.demo.repository.SalonKorisnikRepository;
import com.example.demo.repository.SlikaRepository;
import com.example.demo.repository.SlobodanTerminRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.UslugaRepository;
import com.example.demo.repository.ZakazivanjeRepository;
import com.example.demo.repository.ZaposlenRepository;

import model.Administrator;
import model.SalonKorisnik;
import model.Slika;
import model.Slobodantermin;
import model.Uloga;
import model.Usluga;
import model.Zakazivanje;
import model.Zaposlen;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@ControllerAdvice
@RequestMapping("/administrator")
public class AdministratorController {

	@Autowired
	ZaposlenRepository zr;
	
	@Autowired
	AdministratorRepository ar;
	
	@Autowired
	UslugaRepository ur;
	
	@Autowired
	UslugaRepository uslr;
	
	@Autowired
	ZakazivanjeRepository zakr;
	
	@Autowired
	SlobodanTerminRepository str;
	
	@Autowired
	SalonKorisnikRepository skr;
	
	@Autowired
	UlogaRepository ulogar;
	
	@Autowired
	SlikaRepository slikar;


	//Svi zaposleni radnici
	@RequestMapping(value = "/sviZaposleni", method = RequestMethod.GET)
	public String getSviZaposleni(HttpServletRequest request) {
		List<Zaposlen> zaposleni = zr.findAll();
		request.getSession().setAttribute("zaposleni", zaposleni);
		return "sviZaposleni";
	}
	
	//Dodavanje novog zaposlenog
	@RequestMapping(value = "/saveZaposlen", method = RequestMethod.POST)
	public String saveZaposlen(String ime, String prezime, String tel, Integer plata, Integer idZaposlen, HttpServletRequest request) {
		SalonKorisnik sk = (SalonKorisnik) request.getSession().getAttribute("logovanKorisnik");
		String adminIme = sk.getIme();
		String adminPrz = sk.getPrezime();
		Administrator a = ar.findByImeAndPrezime(adminIme, adminPrz);
		
		Zaposlen z = new Zaposlen();
		z.setIme(ime);
		z.setPrezime(prezime);
		z.setTel(tel);
		z.setPlata(plata);
		z.setAdministrator(a);
		z.setUsername(ime);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		z.setPassword(passwordEncoder.encode(ime));
		zr.save(z);
		
		//DODAVANJE U SALON_KORISNIK_ULOGA da bi se znalo da je on zaposlen
		SalonKorisnik k = new SalonKorisnik();
		k.setIme(z.getIme());
		k.setPrezime(z.getPrezime());
		k.setUsername(z.getUsername());
		k.setPassword(z.getPassword());
		
		Uloga u = ulogar.getById(2);
		k.dodajUlogu(u);
		for (Uloga r : k.getUlogas()) {
			r.addKorisnik(k);
		}
		skr.save(k);

		request.setAttribute("zaposlen", z);
		request.setAttribute("poruka", "Uspesno ste dodali novog zaposlenog");
		return "unosZaposlenog";
	}
	
	//Brisanje zaposlenog
	@RequestMapping(value = "/brisanjeZaposlenog", method = RequestMethod.POST)
	public String brisanjeZaposlenog(HttpServletRequest request) {
		Zaposlen z = (Zaposlen) request.getSession().getAttribute("zaposlenZaBrisanje");
		
		List<Zakazivanje> zakazivanja = zakr.findByZaposlen(z);
		for (Zakazivanje i : zakazivanja) {
			zakr.delete(i);
		}
		
		List<Slobodantermin> termini = str.findByZaposlen(z);
		for (Slobodantermin s : termini) {
			str.delete(s);
		}
		
		zr.delete(z);
		request.setAttribute("izbrisan", "Uspesno izbrisan zaposleni radnik.");
		return "brisanjeZaposlenog";
	}
	
	//Nalazi zaposlenog na osnovu imena i prezimena
	@RequestMapping(value = "/nadjiZaposlenog", method = RequestMethod.POST)
	public String nadjiZaposlenog(String ime, String prezime, HttpServletRequest request) {
		Zaposlen z = zr.findByImeAndPrezime(ime, prezime);
		request.getSession().setAttribute("zaposlen", z);
		return "azuriranjeZaposlenog";
	}
	
	@RequestMapping(value = "/nadjiZaposlenogZaBrisanje", method = RequestMethod.POST)
	public String nadjiZaposlenogZaBrisanje(String ime, String prezime, HttpServletRequest request) {
		Zaposlen z = zr.findByImeAndPrezime(ime, prezime);
		request.getSession().setAttribute("zaposlenZaBrisanje", z);
		return "brisanjeZaposlenog";
	}
	
	@RequestMapping(value = "/promeniPlatu", method = RequestMethod.POST)
	public String promeniPlatu(HttpServletRequest request) {
		request.setAttribute("novaPlata", "novaPlata");
		return "azuriranjeZaposlenog";
	}
	
	@RequestMapping(value = "/postaviNovuPlatu", method = RequestMethod.POST)
	public String postaviNovuPlatu(Integer plata, HttpServletRequest request) {		
		Zaposlen z = (Zaposlen) request.getSession().getAttribute("zaposlen");
		z.setPlata(plata);
		zr.save(z);
		request.setAttribute("poruka", "Uspesno ste postavili novu platu");
		return "azuriranjeZaposlenog";
	}
	
	@RequestMapping(value = "/dodajTermin", method = RequestMethod.POST)
	public String dodajTermin(Date datum, String vreme, Integer idUsluga, Integer idZaposlen, HttpServletRequest request) {
		
		Usluga u = ur.findById(idUsluga).get();
		Zaposlen z = zr.findById(idZaposlen).get();
		
		Slobodantermin termin = new Slobodantermin();
		termin.setDatum(datum);
		termin.setVreme(vreme);
		termin.setUsluga(u);
		termin.setZaposlen(z);
		str.save(termin);
		request.getSession().setAttribute("porukaUspesnosti", "Uspesno ste dodali novi termin");
		return "dodavanjeTermina";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/getUslugeIZaposleni", method = RequestMethod.GET)
	public String getUslugeIZaposleni(HttpServletRequest request) {
		List<Zaposlen> zaposleni = zr.findAll();
		request.getSession().setAttribute("zaposleni", zaposleni);
		List<Usluga> usluge = uslr.findAll();
		request.getSession().setAttribute("usluge", usluge);
		return "dodavanjeTermina";
	}
	
	@RequestMapping(value = "/dodajSliku", method = RequestMethod.POST)
	public String dodajSliku(String url, HttpServletRequest request) {
		Integer idUsluga = Integer.parseInt(request.getParameter("idUsluga"));
		Usluga u = ur.findById(idUsluga).get();
		
		SalonKorisnik sk = (SalonKorisnik) request.getSession().getAttribute("logovanKorisnik");
		String adminIme = sk.getIme();
		String adminPrz = sk.getPrezime();
		Administrator a = ar.findByImeAndPrezime(adminIme, adminPrz);
		Integer idA = a.getIdAdministrator();
		
		Slika s = new Slika();
		s.setIdAdministrator(idA);
		s.setUsluga(u);
		s.setUrl(url);
		slikar.save(s);
		
		request.setAttribute("poruka", "Uspesno dodata slika");
		return "dodavanjeSlika";
	}
	
	@RequestMapping(value = "/getUsluge", method = RequestMethod.GET)
	public String getUsluge(HttpServletRequest request) {
		List<Usluga> usluge = uslr.findAll();
		request.getSession().setAttribute("usluge", usluge);
		return "dodavanjeSlika";
	}
	
	@RequestMapping(value="/getSviZaposleniReport", method=RequestMethod.GET)
	public void generisiIzvestaj(HttpServletResponse response) throws Exception{
		
		List<Zaposlen> zaposleni = zr.findAll();
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(zaposleni);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasprerreports/SviZaposleni.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datum", new Date());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();

		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=SviZaposleni.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out);
	}
		
}
