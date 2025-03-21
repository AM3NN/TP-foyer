package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.repositories.IReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationServices {

    private final IReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(int anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findByAnneeUniversitaireAndNomUniversite(anneeUniversitaire, nomUniversite);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // Assuming you have some logic here to add a reservation
        Reservation reservation = new Reservation();
        // Set the fields based on the logic
        return reservationRepository.save(reservation);
    }
}
