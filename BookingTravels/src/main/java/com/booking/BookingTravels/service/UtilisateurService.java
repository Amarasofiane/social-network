package com.booking.BookingTravels.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.booking.BookingTravels.dto.UtilisateurDTO;
import com.booking.BookingTravels.entity.Utilisateur;
import com.booking.BookingTravels.exceptions.TravelsException;
import com.booking.BookingTravels.repository.UtilisateurRepository;
import com.booking.BookingTravels.repository.custom.impl.UtilisateurRepositoryCustomImpl;
import com.booking.BookingTravels.utils.MapperBean;

@Service
public class UtilisateurService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository userRep;

	@Autowired
	private UtilisateurRepositoryCustomImpl userRepCust;

	private MapperBean<UtilisateurDTO, Utilisateur> mapper = new MapperBean<>();

	@Autowired
	private ModelMapper modelmapper;

	public UserDetails getUserAuth(UtilisateurDTO userSer) throws TravelsException {
		try {
			Utilisateur userAuth = this.userRepCust.getUserByMail(userSer.getMail(), userSer.getPassword());
			UtilisateurDTO userGet = mapper.entityToDto(modelmapper, userAuth, UtilisateurDTO.class);
			return new org.springframework.security.core.userdetails.User(userGet.getMail(), userGet.getPassword(),
					new ArrayList<>());

		} catch (TravelsException ex) {
			throw new TravelsException(ex.getMessage(), ex);

		}

	}

	public boolean createUser(Utilisateur user) {
		boolean resp = this.userRepCust.existeUser(user);
		if (!resp) {
			this.userRep.save(user);
		}
		return !resp;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur userName = this.userRepCust.getUserByName(username);
		UtilisateurDTO userGet = mapper.entityToDto(modelmapper, userName, UtilisateurDTO.class);
		return new org.springframework.security.core.userdetails.User(userGet.getMail(), userGet.getPassword(),
				new ArrayList<>());
	}

}
