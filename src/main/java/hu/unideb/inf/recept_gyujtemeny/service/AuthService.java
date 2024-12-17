package hu.unideb.inf.recept_gyujtemeny.service;

import hu.unideb.inf.recept_gyujtemeny.service.dto.BejelentkezesDto;
import hu.unideb.inf.recept_gyujtemeny.service.dto.RegisztracioDto;
public interface AuthService {
    void regisztracio(RegisztracioDto dto);
    String bejelentkezes(BejelentkezesDto dto);
}