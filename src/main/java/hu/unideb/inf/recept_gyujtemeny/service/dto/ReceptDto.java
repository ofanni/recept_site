package hu.unideb.inf.recept_gyujtemeny.service.dto;

import java.util.Date;
import java.util.Objects;

public class ReceptDto {

    private Long id;
    private String cim;
    private Integer adag;
    private String hozzavalok;
    private String leiras;
    private Date feltoltesDatum;


    public ReceptDto() {
    }

    public ReceptDto(Long id, String cim, Integer adag, String hozzavalok, String leiras, Date feltoltesDatum) {
        this.id = id;
        this.cim = cim;
        this.adag = adag;
        this.hozzavalok = hozzavalok;
        this.leiras = leiras;
        this.feltoltesDatum = feltoltesDatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceptDto receptDto = (ReceptDto) o;
        return Objects.equals(id, receptDto.id) &&
                Objects.equals(cim, receptDto.cim) &&
                Objects.equals(adag, receptDto.adag) &&
                Objects.equals(hozzavalok, receptDto.hozzavalok) &&
                Objects.equals(leiras, receptDto.leiras) &&
                Objects.equals(feltoltesDatum, receptDto.feltoltesDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cim, adag, hozzavalok, leiras, feltoltesDatum);
    }
}
