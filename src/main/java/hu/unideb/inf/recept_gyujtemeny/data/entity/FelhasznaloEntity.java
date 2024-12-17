package hu.unideb.inf.recept_gyujtemeny.data.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="felhasznalo")
public class FelhasznaloEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="telj_nev")
    private String teljNev;
    @Column(name = "felh_nev")
    private String felhNev;
    @Column(name="jelszo")
    private String jelszo;


    @OneToMany(mappedBy = "felhasznalo")
    private List<ReceptEntity> receptek;

    @OneToMany(mappedBy = "felhasznalo")
    private List<KommentEntity> komment;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "felhasznalo_jogosultsagok",
            joinColumns = {@JoinColumn(name = "felhasznalo_id")},
            inverseJoinColumns = {@JoinColumn(name = "jogosultsag_id")}
    )
    private List<JogosultsagEntity> jogosultsagok;

    public FelhasznaloEntity() {

    }

    public FelhasznaloEntity(long id, String teljNev, String felhNev, String jelszo) {
        this.id = id;
        this.teljNev = teljNev;
        this.felhNev = felhNev;
        this.jelszo = jelszo;
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
        return id == that.id && Objects.equals(teljNev, that.teljNev) && Objects.equals(felhNev, that.felhNev) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teljNev, felhNev, jelszo);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return jogosultsagok;
    }

    @Override
    public String getPassword() {
        return jelszo;
    }

    @Override
    public String getUsername() {
        return felhNev;
    }
}
