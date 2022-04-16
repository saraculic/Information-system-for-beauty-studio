package com.example.demo.security;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.UlogaRepository;

import model.Uloga;

public class UlogaConverter implements Converter<String, Uloga> {

	UlogaRepository ur;

	public UlogaConverter(UlogaRepository ur) {
		this.ur = ur;
	}

	@Override
	public Uloga convert(String source) {
		int id = -1;
		try {
			id = Integer.parseInt(source);
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
					TypeDescriptor.valueOf(Uloga.class), id, null);
		}
		Uloga uloga = ur.getById(id);
		return uloga;
	}

}
