package tn.esprit.tpfoyer.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;









@Entity


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @OneToOne
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    @JsonIgnore
    private List<Bloc> blocs ;

    public Long getIdFoyer() {
        return idFoyer;
    }


    ///
    // Manually added getter and setter for universite
    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
    // Getter for blocs
    public List<Bloc> getBlocs() {
        return blocs;
    }

    // Setter for blocs
    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }
}