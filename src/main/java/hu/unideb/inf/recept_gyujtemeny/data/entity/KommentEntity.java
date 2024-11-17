package hu.unideb.inf.recept_gyujtemeny.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "komment")
public class KommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "tartalom")
    private String tartalom;
    @Column(name = "letr_datum")
    private Date letrDatum;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private FelhasznaloEntity felhasznalo;
    @ManyToOne
    @JoinColumn(name = "recept_id", referencedColumnName = "id")
    private ReceptEntity receptek;

    public KommentEntity() {

    }

    public KommentEntity(long id, String tartalom, Date letrDatum) {
        this.id = id;
        this.tartalom = tartalom;
        this.letrDatum = letrDatum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public Date getLetrDatum() {
        return letrDatum;
    }

    public void setLetrDatum(Date letrDatum) {
        this.letrDatum = letrDatum;
    }

    public ReceptEntity getReceptek() {
        return receptek;
    }

    public void setReceptek(ReceptEntity receptek) {
        this.receptek = receptek;
    }

    public FelhasznaloEntity getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(FelhasznaloEntity felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KommentEntity that = (KommentEntity) o;
        return id == that.id && Objects.equals(tartalom, that.tartalom) && Objects.equals(letrDatum, that.letrDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tartalom, letrDatum);
    }
}
