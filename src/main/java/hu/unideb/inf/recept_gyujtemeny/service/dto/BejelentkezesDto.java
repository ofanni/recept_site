package hu.unideb.inf.recept_gyujtemeny.service.dto;

import java.util.Objects;


public class BejelentkezesDto {
    private String felhNev;
    private String jelszo;

    public BejelentkezesDto() {
    }

    public BejelentkezesDto(String felhNev, String jelszo) {
        this.felhNev = felhNev;
        this.jelszo = jelszo;
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
        BejelentkezesDto that = (BejelentkezesDto) o;
        return Objects.equals(felhNev, that.felhNev) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(felhNev, jelszo);
    }
}
