package com.booking.BookingTravels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.BookingTravels.entity.Utilisateur;
import com.booking.BookingTravels.repository.custom.UtilisateurRepositoryCustom;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>, UtilisateurRepositoryCustom {

}
