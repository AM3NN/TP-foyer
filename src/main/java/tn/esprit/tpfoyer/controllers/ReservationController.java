package tn.esprit.tpfoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.services.IReservationServices;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final IReservationServices reservationService;

    // Manually define the constructor for dependency injection
    @Autowired
    public ReservationController(IReservationServices reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservation();
    }

    @GetMapping("/getById/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable("id") Long idReservation, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/byAnneeAndUniversite")
    public ResponseEntity<List<Reservation>> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date anneeUniversite,
            @RequestParam String nomUniversite
    ) {
        // Extract the year from the Date object
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(anneeUniversite);
        int year = calendar.get(Calendar.YEAR);

        // Call the service method with the extracted year
        List<Reservation> reservations = reservationService.getReservationParAnneeUniversitaireEtNomUniversite(year, nomUniversite);

        if (reservations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }
}
