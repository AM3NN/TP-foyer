package tn.esprit.tpfoyer.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private boolean estValide;
    private String numReservation;

    @ManyToMany
    @JsonIgnore
    private Set<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "chambre_id") // This will create a foreign key column in the Reservation table
    private Chambre chambre;
    @ManyToOne
    @JoinColumn(name = "universite_id")
    private Universite universite;
    @Column(name = "nom_universite")
    private String nomUniversite;

    // Ensure getter and setter for Chambre exist
    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Chambre getChambre() {
        return this.chambre;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }
}
