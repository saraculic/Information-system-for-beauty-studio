package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.SalonKorisnik;

public interface SalonKorisnikRepository extends JpaRepository<SalonKorisnik, Integer>{
	
	SalonKorisnik findByUsername(String username);
}
