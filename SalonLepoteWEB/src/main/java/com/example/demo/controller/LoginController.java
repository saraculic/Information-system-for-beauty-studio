package com.example.demo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.Authentication;

import com.example.demo.repository.AdministratorRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.SalonKorisnikRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.UslugaRepository;
import com.example.demo.repository.ZaposlenRepository;

import model.Administrator;
import model.Korisnik;
import model.SalonKorisnik;
import model.Uloga;
import model.Usluga;
import model.Zaposlen;

@Controller
@ControllerAdvice
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	UlogaRepository ur;

	@Autowired
	UslugaRepository uslr;

	@Autowired
	SalonKorisnikRepository sr;
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	AdministratorRepository ar;
	
	@Autowired
	ZaposlenRepository zr;

	@RequestMapping(value = "/uloge", method = RequestMethod.GET)
	public String getUloge(Model model) {
		List<Uloga> uloge = ur.findAll();
		model.addAttribute("uloge", uloge);
		return "registracija";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String deniedPage() {
		return "access_denied";

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(String ime, String prezime, String username, String password, HttpServletRequest request) {

		SalonKorisnik sk = new SalonKorisnik();
		sk.setIme(ime);
		sk.setPrezime(prezime);
		sk.setUsername(username);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		sk.setPassword(passwordEncoder.encode(password));
		
		Integer idUloga = Integer.parseInt(request.getParameter("idUloga"));
		Uloga uloga = ur.findById(idUloga).get();
		if(uloga.getIdUloga() == 3) {
			Korisnik k = new Korisnik();
			k.setIme(ime);
			k.setPrezime(prezime);
			k.setUsername(username);
			k.setPassword(passwordEncoder.encode(password));
			kr.save(k);
		} else if(uloga.getIdUloga() == 2) {
			Zaposlen z = new Zaposlen();
			z.setIme(ime);
			z.setPrezime(prezime);
			z.setUsername(username);
			z.setPassword(passwordEncoder.encode(password));
			zr.save(z);
			
		} else if(uloga.getIdUloga() == 1) {
			Administrator a = new Administrator();
			a.setIme(ime);
			a.setPrezime(prezime);
			a.setUsername(username);
			a.setPassword(passwordEncoder.encode(password));
			ar.save(a);
		}
		
		sk.dodajUlogu(uloga);
		for (Uloga r : sk.getUlogas()) {
			r.addKorisnik(sk);
		}

		sr.save(sk);
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/auth/loginPage";
	}


	@ResponseBody
	@RequestMapping(value = "/pocetna", method = RequestMethod.GET)
	public void pocetna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.err.println("--------------------------------------------------------------------------------");
		Principal principal = request.getUserPrincipal();
		String username = principal.getName();
		SalonKorisnik sk = sr.findByUsername(username);
		request.getSession().setAttribute("logovanKorisnik", sk);
		request.getRequestDispatcher("/pocetna.jsp").forward(request, response);
		;
	}

	@RequestMapping(value = "/getSveUsluge", method = RequestMethod.GET)
	public String getSve(HttpServletRequest request) {
		List<Usluga> usluge = uslr.findAll();
		request.getSession().setAttribute("usluge", usluge);
		return "sveUsluge";
	}
}
