package com.booking.BookingTravels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.BookingTravels.conf.JwtTokenUtil;
import com.booking.BookingTravels.dto.UtilisateurDTO;
import com.booking.BookingTravels.entity.Utilisateur;
import com.booking.BookingTravels.exceptions.DefaultBookingException;
import com.booking.BookingTravels.exceptions.EntiyResponseData;
import com.booking.BookingTravels.exceptions.TravelsException;
import com.booking.BookingTravels.service.UtilisateurService;

@RestController
@RequestMapping("api")
public class UtilisateurController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);
	private static final String ERROR = "error";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UtilisateurService us;

	@PostMapping("/auth")
	public EntiyResponseData getUserDTOs(@RequestBody UtilisateurDTO userDTO) throws Exception {
		try {
			LOGGER.info("tentative de connextion");
			String encodedPassword = new BCryptPasswordEncoder().encode(userDTO.getPassword());
			System.out.println(encodedPassword);

			authenticate(userDTO.getMail(), encodedPassword);

			final UserDetails Users = us.getUserAuth(userDTO);
			System.out.println(Users.getUsername() + "AMA" + Users.getPassword());
			final String token = jwtTokenUtil.generateToken(Users);
			System.out.println(token);

			return new EntiyResponseData(Users);

		} catch (TravelsException e) {
			String errorMessage = "Invalid compte";
			LOGGER.error(errorMessage, e);
			throw new DefaultBookingException(new EntiyResponseData(HttpStatus.NOT_FOUND, 500));
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@PostMapping("/register")
	public EntiyResponseData registerUser(@RequestBody Utilisateur user) {
		boolean userRequest = this.us.createUser(user);
		return new EntiyResponseData(userRequest);

	}
}
