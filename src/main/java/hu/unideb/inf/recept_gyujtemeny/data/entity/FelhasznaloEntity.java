package hu.unideb.inf.recept_gyujtemeny.data.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="felhazsnalo")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="telj_nev")
    private String teljNev;
    @Column(name = "felh_nev")
    private String felhNev;
    @Column(name="jelszo")
    private String jelszo;
    @Column(name = "profile_pic")
    private String profilePic;

    @OneToMany(mappedBy = "felhasznalo")
    private List<ReceptEntity> receptek;

    @OneToMany(mappedBy = "felhasznalo")
    private List<KommentEntity> komment;

    @ManyToMany
    @JoinTable(name = "felhasznalo_jogosultsagok",
            joinColumns = {@JoinColumn(name = "felhasznalo_id")},
            inverseJoinColumns = {@JoinColumn(name = "jogosultsag_id")}
    )
    private List<JogosultsagEntity> jogosultsagok;

    public FelhasznaloEntity() {

    }

    public FelhasznaloEntity(long id, String teljNev, String felhNev, String jelszo, String profilePic) {
        this.id = id;
        this.teljNev = teljNev;
        this.felhNev = felhNev;
        this.jelszo = jelszo;
        this.profilePic = profilePic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeljNev() {
        return teljNev;
    }

    public void setTeljNev(String teljNev) {
        this.teljNev = teljNev;
    }

    public String getFelhNev() {
        return felhNev;
    }

    public void setFelhNev(String felhNev) {
        this.felhNev = felhNev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<ReceptEntity> getReceptek() {
        return receptek;
    }

    public void setReceptek(List<ReceptEntity> receptek) {
        this.receptek = receptek;
    }

    public List<KommentEntity> getKomment() {
        return komment;
    }

    public void setKomment(List<KommentEntity> komment) {
        this.komment = komment;
    }

    public List<JogosultsagEntity> getJogosultsagok() {
        return jogosultsagok;
    }

    public void setJogosultsagok(List<JogosultsagEntity> jogosultsagok) {
        this.jogosultsagok = jogosultsagok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloEntity that = (FelhasznaloEntity) o;
        return id == that.id && Objects.equals(teljNev, that.teljNev) && Objects.equals(felhNev, that.felhNev) && Objects.equals(jelszo, that.jelszo) && Objects.equals(profilePic, that.profilePic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teljNev, felhNev, jelszo, profilePic);
    }
}
