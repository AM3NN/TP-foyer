package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;

public interface IReservationServices {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation(Reservation res);
    Reservation retrieveReservation(Long idReservation);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(int anneeUniversitaire, String nomUniversite);
    Reservation ajouterReservation(long idBloc, long cinEtudiant);
}
