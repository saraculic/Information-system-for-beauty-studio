package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Slobodantermin;
import model.Usluga;
import model.Zaposlen;

public interface SlobodanTerminRepository extends JpaRepository<Slobodantermin, Integer> {

	List<Slobodantermin> findByUsluga(Usluga u);

	List<Slobodantermin> findByZaposlen(Zaposlen z);

}
