package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Zaposlen;

public interface ZaposlenRepository extends JpaRepository<Zaposlen, Integer>{

	public Zaposlen findByImeAndPrezime(String ime, String prezime);

	public List<Zaposlen> findAllByOrderByPlata();


	
}
