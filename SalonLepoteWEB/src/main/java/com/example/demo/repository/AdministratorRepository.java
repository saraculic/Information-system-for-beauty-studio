package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{

	Administrator findByImeAndPrezime(String ime, String prezime);
	
}
