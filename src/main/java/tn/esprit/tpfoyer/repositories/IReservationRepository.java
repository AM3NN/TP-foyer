package tn.esprit.tpfoyer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByAnneeUniversitaireAndNomUniversite(int anneeUniversitaire, String nomUniversite);
}
