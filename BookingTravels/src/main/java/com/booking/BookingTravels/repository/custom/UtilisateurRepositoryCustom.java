package com.booking.BookingTravels.repository.custom;

import com.booking.BookingTravels.entity.Utilisateur;
import com.booking.BookingTravels.exceptions.TravelsException;

public interface UtilisateurRepositoryCustom {

	public boolean existeUser(Utilisateur userexist);

	public Utilisateur getUserByMail(String mail, String password) throws TravelsException;

	public Utilisateur getUserByName(String login_us);
}
