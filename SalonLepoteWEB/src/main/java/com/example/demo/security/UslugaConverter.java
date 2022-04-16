package com.example.demo.security;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.UslugaRepository;

import model.Uloga;
import model.Usluga;

public class UslugaConverter implements Converter<String, Usluga> {

	UslugaRepository ur;

	public UslugaConverter (UslugaRepository ur) {
		this.ur = ur;
	}

	@Override
	public Usluga convert(String source) {
		int id = -1;
		try {
			id = Integer.parseInt(source);
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
					TypeDescriptor.valueOf(Uloga.class), id, null);
		}
		Usluga usluga = ur.getById(id);
		return usluga;
	}

}
