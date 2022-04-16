package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.ZakazivanjeRepository;
import com.example.demo.repository.ZaposlenRepository;

import model.SalonKorisnik;
import model.Zakazivanje;
import model.Zaposlen;


@Controller
@ControllerAdvice
@RequestMapping("/zaposlen")
public class ZaposlenController {
	
	@Autowired
	ZaposlenRepository zr;
	
	@Autowired
	ZakazivanjeRepository zakr;

	@RequestMapping(value = "/prikazPlate", method = RequestMethod.GET)
	public String prikazPlate(HttpServletRequest request) {
		SalonKorisnik sk = (SalonKorisnik) request.getSession().getAttribute("logovanKorisnik");
		String ime = sk.getIme();
		String prezime = sk.getPrezime();
		Zaposlen z = zr.findByImeAndPrezime(ime, prezime);
		Integer plata = z.getPlata();
		request.setAttribute("plata", plata);
		return "pocetna";
		
	}
	
	@RequestMapping(value = "/prikazZakazanihTermina", method = RequestMethod.GET)
	public String zakazaniTermini(HttpServletRequest request) {
		SalonKorisnik sk = (SalonKorisnik) request.getSession().getAttribute("logovanKorisnik");
		String ime = sk.getIme();
		String prezime = sk.getPrezime();
		Zaposlen z = zr.findByImeAndPrezime(ime, prezime);
		List<Zakazivanje> zakazaniTermini = zakr.findByZaposlen(z);
		request.getSession().setAttribute("zakazaniTermini", zakazaniTermini);
		return "pocetna";
		
	}
	
}
