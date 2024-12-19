package hu.unideb.inf.recept_gyujtemeny.service.impl;

import hu.unideb.inf.recept_gyujtemeny.data.entity.FelhasznaloEntity;
import hu.unideb.inf.recept_gyujtemeny.data.entity.JogosultsagEntity;
import hu.unideb.inf.recept_gyujtemeny.data.repository.FelhasznaloRepository;
import hu.unideb.inf.recept_gyujtemeny.data.repository.JogosultsagRepository;
import hu.unideb.inf.recept_gyujtemeny.service.AuthService;
import hu.unideb.inf.recept_gyujtemeny.service.JwtService;
import hu.unideb.inf.recept_gyujtemeny.service.dto.BejelentkezesDto;
import hu.unideb.inf.recept_gyujtemeny.service.dto.RegisztracioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FelhasznaloRepository felhasznaloRepository;
    @Autowired
    JogosultsagRepository jogRepo;
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtService jwtService;

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity entity = modelMapper.map(dto, FelhasznaloEntity.class);
        entity.setJelszo(passwordEncoder.encode(entity.getJelszo()));

        JogosultsagEntity jog;
        if ("admin".equals(dto.getFelhNev())) {
            // Admin jogosultság kezelése
            jog = jogRepo.findByNev("ROLE_ADMIN");
            if (jog == null) {
                jog = new JogosultsagEntity();
                jog.setNev("ROLE_ADMIN");
                jog = jogRepo.save(jog);
            }
        } else {
            // Alapértelmezett felhasználó jogosultság
            jog = jogRepo.findByNev("ROLE_FELHASZNALO");
            if (jog == null) {
                jog = new JogosultsagEntity();
                jog.setNev("ROLE_FELHASZNALO");
                jog = jogRepo.save(jog);
            }
        }
        entity.setJogosultsagok(List.of(jog));
        felhasznaloRepository.save(entity);
    }

    @Override
    public String bejelentkezes(BejelentkezesDto dto) {
        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getFelhNev(),
                        dto.getJelszo()
                )
        );

        var user = felhasznaloRepository.findByFelhNev(dto.getFelhNev());
        // Admin jogosultság ellenőrzése
        if (user.getJogosultsagok().stream().anyMatch(jog -> "ADMIN".equals(jog.getNev()))) {
            System.out.println("Admin felhasználó jelentkezett be!");
            // További admin-specifikus műveletek itt
        }
        return jwtService.generateToken(user);


    }
}
