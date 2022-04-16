package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usluga;
import model.Zakazivanje;
import model.Zaposlen;

public interface ZakazivanjeRepository extends JpaRepository<Zakazivanje, Integer>{

	List<Zakazivanje> findByUsluga(Usluga u);

	List<Zakazivanje> findByZaposlen(Zaposlen z);

}
