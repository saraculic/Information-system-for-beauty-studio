package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.KomentarRepository;
import com.example.demo.repository.KorisnikRepository;

import model.Komentar;
import model.Korisnik;
import model.SalonKorisnik;

@Controller
@ControllerAdvice
@RequestMapping("/musterija")
public class MusterijaController {
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	KomentarRepository komr;

	@RequestMapping(value = "/ostavljanjeKomentara")
	public String ostavljanjeKomentara(HttpServletRequest request) {
		request.getSession().setAttribute("komentar", "komentar");
		return "pocetna";
	}
	
	@RequestMapping(value = "/saveKomentar", method = RequestMethod.POST)
	public String saveKomentar(String kom, HttpServletRequest request) {
		SalonKorisnik sk = (SalonKorisnik) request.getSession().getAttribute("logovanKorisnik");
		String ime = sk.getIme();
		String prezime = sk.getPrezime();
		Korisnik korisnik = kr.findByImeAndPrezime(ime, prezime);
		
		Komentar k = new Komentar();
		k.setText(kom);
		k.setKorisnik(korisnik);
		komr.save(k);
		request.getSession().setAttribute("ostavljenKomentar", "Uspesno ste ostavili komentar. Hvala :)");
		return "pocetna";
		
	}
}
