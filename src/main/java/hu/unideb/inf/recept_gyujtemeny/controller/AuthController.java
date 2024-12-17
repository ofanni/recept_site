package hu.unideb.inf.recept_gyujtemeny.controller;

import hu.unideb.inf.recept_gyujtemeny.service.AuthService;
import hu.unideb.inf.recept_gyujtemeny.service.dto.BejelentkezesDto;
import hu.unideb.inf.recept_gyujtemeny.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody RegisztracioDto dto){
        authService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto){
        return authService.bejelentkezes(dto);
    }

    @GetMapping("/vt")
    public String vt(){
        return Thread.currentThread().toString();
    }
}