package hu.unideb.inf.recept_gyujtemeny.data.entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "receptek")
public class ReceptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cim")
    private String cim;
    @Column(name = "adag")
    private Integer adag;
    @Column(name = "hozzavalok")
    private String hozzavalok;
    @Column(name = "leiras")
    private String leiras;
    @Column(name = "feltoltes_datum")
    private Date feltoltesDatum;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private FelhasznaloEntity felhasznalo;

    public ReceptEntity() {

    }

    public ReceptEntity(long id, String cim, Integer adag, String hozzavalok, String leiras, Date feltoltesDatum,FelhasznaloEntity felhasznalo) {
        this.id = id;
        this.cim = cim;
        this.adag = adag;
        this.hozzavalok = hozzavalok;
        this.leiras = leiras;
        this.feltoltesDatum = feltoltesDatum;
        this.felhasznalo = felhasznalo;  // Directly set the user (FelhasznaloEntity)

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public Integer getAdag() {
        return adag;
    }

    public void setAdag(Integer adag) {
        this.adag = adag;
    }

    public String getHozzavalok() {
        return hozzavalok;
    }

    public void setHozzavalok(String hozzavalok) {
        this.hozzavalok = hozzavalok;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Date getFeltoltesDatum() {
        return feltoltesDatum;
    }

    public void setFeltoltesDatum(Date feltoltesDatum) {
        this.feltoltesDatum = feltoltesDatum;
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
        ReceptEntity that = (ReceptEntity) o;
        return id == that.id && Objects.equals(cim, that.cim) && Objects.equals(adag, that.adag) && Objects.equals(hozzavalok, that.hozzavalok) && Objects.equals(leiras, that.leiras) && Objects.equals(feltoltesDatum, that.feltoltesDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cim, adag, hozzavalok, leiras, feltoltesDatum);
    }
}
