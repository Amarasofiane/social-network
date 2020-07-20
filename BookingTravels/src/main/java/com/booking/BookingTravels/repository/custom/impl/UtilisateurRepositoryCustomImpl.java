package com.booking.BookingTravels.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.booking.BookingTravels.entity.Utilisateur;
import com.booking.BookingTravels.exceptions.TravelsException;
import com.booking.BookingTravels.repository.custom.UtilisateurRepositoryCustom;

public class UtilisateurRepositoryCustomImpl implements UtilisateurRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean existeUser(Utilisateur userexist) {
		StringBuilder strQ = new StringBuilder("select * from utilisateur where mail_us=?");
		Query query = entityManager.createNativeQuery(strQ.toString(), Utilisateur.class);
		query.setParameter(1, userexist.getMail());
		List<Utilisateur> priceGrid = query.getResultList();
		return priceGrid.isEmpty() ? false : true;

	}

	@Override
	public Utilisateur getUserByMail(String mail, String password) throws TravelsException {
		StringBuilder strQry = new StringBuilder("select * from utilisateur where mail_us=? and password_us=?");
		Query query = entityManager.createNativeQuery(strQry.toString(), Utilisateur.class);
		query.setParameter(1, mail);
		query.setParameter(2, password);
		Utilisateur result = (Utilisateur) query.getSingleResult();
		return result;
	}

	@Override
	public Utilisateur getUserByName(String userName) {
		StringBuilder strQry = new StringBuilder("select * from utilisateur where mail_us=? ");
		Query query = entityManager.createNativeQuery(strQry.toString(), Utilisateur.class);
		query.setParameter(1, userName);
		Utilisateur result = (Utilisateur) query.getSingleResult();
		return result;
	}

}
