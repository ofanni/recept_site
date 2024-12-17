package hu.unideb.inf.recept_gyujtemeny.service.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class KommentDto {

    private long id;
    private String tartalom;
    private String felh_id;
    private String recept_id;
    private LocalDateTime letr_datum;

    public KommentDto() {
    }

    public KommentDto(long id, String tartalom, String felh_id, String recept_id, LocalDateTime letr_datum) {
        this.id = id;
        this.tartalom = tartalom;
        this.felh_id = felh_id;
        this.recept_id = recept_id;
        this.letr_datum = letr_datum;
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

    public String getFelh_id() {
        return felh_id;
    }

    public void setFelh_id(String felh_id) {
        this.felh_id = felh_id;
    }

    public String getRecept_id() {
        return recept_id;
    }

    public void setRecept_id(String recept_id) {
        this.recept_id = recept_id;
    }

    public LocalDateTime getLetr_datum() {
        return letr_datum;
    }

    public void setLetr_datum(LocalDateTime letr_datum) {
        this.letr_datum = letr_datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KommentDto that = (KommentDto) o;
        return id == that.id && Objects.equals(tartalom, that.tartalom) && Objects.equals(felh_id, that.felh_id) && Objects.equals(recept_id, that.recept_id) && Objects.equals(letr_datum, that.letr_datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tartalom, felh_id, recept_id, letr_datum);
    }
}
