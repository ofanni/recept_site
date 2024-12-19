package hu.unideb.inf.recept_gyujtemeny.controller;

import hu.unideb.inf.recept_gyujtemeny.service.ReceptManagementService;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReceptController {

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @Autowired
    ReceptManagementService service;

    @GetMapping("/hello")
    public String hello() {
        return "Hello from spring boot";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/saverecept")
    public ReceptDto save(@RequestBody ReceptDto recept) {
        return service.save(recept);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updaterecept")
    public ReceptDto update(@RequestBody ReceptDto recept) {
        if (recept.getId() > 0L) {
            return service.save(recept);
        }
        return null;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/drecept")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/recept")
    public List<ReceptDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/recept/{cim}")
    public List<ReceptDto> findAllByCim(@PathVariable String cim) {
        return service.findByCim(cim);
    }
    @GetMapping("/recept/{id}")
    public ResponseEntity<ReceptDto> getRecipeById(@PathVariable Long id) {
        ReceptDto recept = service.findById(id);
        if (recept != null) {
            return ResponseEntity.ok(recept);  // Ha megtaláltuk a receptet, akkor visszaadjuk
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Ha nem található, 404-es hiba
        }
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