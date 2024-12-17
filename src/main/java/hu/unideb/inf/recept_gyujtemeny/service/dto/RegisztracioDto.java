package hu.unideb.inf.recept_gyujtemeny.service.dto;

import jakarta.persistence.Column;

import java.util.Objects;

public class RegisztracioDto {
    private String teljNev;
    private String felhNev;
    private String jelszo;

    public RegisztracioDto() {
    }

    public RegisztracioDto(long id, String teljNev, String felhNev, String jelszo, String profilePic) {
        this.teljNev = teljNev;
        this.felhNev = felhNev;
        this.jelszo = jelszo;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisztracioDto that = (RegisztracioDto) o;
        return Objects.equals(teljNev, that.teljNev) && Objects.equals(felhNev, that.felhNev) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash( teljNev, felhNev, jelszo);
    }
}
