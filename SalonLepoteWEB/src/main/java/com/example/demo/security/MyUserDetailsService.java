package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SalonKorisnikRepository;

import model.SalonKorisnik;

@Service("customUserDetailsService")
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	SalonKorisnikRepository skr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SalonKorisnik user = skr.findByUsername(username);
		
		MyUserDetails userDetails = new MyUserDetails();
		userDetails.setUsername(user.getUsername());
		userDetails.setPassword(user.getPassword());
		userDetails.setUloge(user.getUlogas());
		return userDetails;
	}
	

}
