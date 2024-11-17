package hu.unideb.inf.recept_gyujtemeny.controller;

import hu.unideb.inf.recept_gyujtemeny.service.ReceptManagementService;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReceptController {

    @Autowired
    ReceptManagementService service;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


    @PostMapping("/saverecept")
    public ReceptDto save(@RequestBody ReceptDto recept) {
        return service.save(recept);
    }

    @PutMapping("/updaterecept")
    public ReceptDto update(@RequestBody ReceptDto recept) {
        if (recept.getId() > 0L) {
            return service.save(recept);
        }
        return null;
    }

    @DeleteMapping("/recept")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }

    @GetMapping("/recept")
    public List<ReceptDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/recept/{cim}")
    public List<ReceptDto> findAllByCim(@PathVariable String cim) {
        return service.findByCim(cim);
    }
    @GetMapping("/filterrecept")
    public List<ReceptDto> filterRecept(
            @RequestParam(required = false) String cim,
            @RequestParam(required = false) Integer adag,
            @RequestParam(required = false) String hozzavalok,
            @RequestParam(required = false) String leiras,
            @RequestParam(required = false) Date feltoltesDatum) {

        return service.filterRecept(cim, adag, hozzavalok, leiras, feltoltesDatum);
    }
}