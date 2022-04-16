package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Slika;
import model.Usluga;

public interface SlikaRepository extends JpaRepository<Slika, Integer>{

	List<Slika> findByUsluga(Usluga u);

}
