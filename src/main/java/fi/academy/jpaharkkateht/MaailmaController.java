package fi.academy.jpaharkkateht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MaailmaController {
    @Autowired CountryRepository countryRepository;


    @GetMapping("/api/maat")
    public Iterable<Country> restMetodiGetMaat() {
        return countryRepository.findAll();
    }

    @GetMapping("api/maahaku")
    public Optional<Country> restMetodiFind(@RequestParam(name="name", required = false) String hakusana) {
        return countryRepository.findById(hakusana);
    }

    @GetMapping("api/maahakuasukasluvulla")
    public List<Country> restMetodiFindByPopulation(@RequestParam(name="population", required = false) Integer hakusana) {
        List<Country> lista = new ArrayList<>();
        for (Country country: countryRepository.findAll()) {
            if (country.getPopulation()>=hakusana) {
                lista.add(country);
            }
        } return lista;
    }

    @PutMapping("api/muokkaamaata")
    public void restMetodiPut(@RequestBody Country country) {
        countryRepository.save(country);
    }

    @PostMapping("api/lisaamaa")
    public void restMetodiPost(@RequestBody Country country) {
        countryRepository.save(country);
    }

    @DeleteMapping("api/poistamaa")
    public void restMetodiDelete(@RequestParam(name="code", required = false) String hakusana) {
        countryRepository.deleteById(hakusana);
    }

    @GetMapping("/api/maakoodilla{code}")
    public Iterable<Country> restMetodiGetKaupunkiKoodilla(@RequestParam(name="code", required = false) String hakusana) {
        return countryRepository.haeMaaKoodilla(hakusana);
    }

    @GetMapping("/api/maanimella{name}")
    public Iterable<Country> restMetodiGetKaupunkiNimella(@RequestParam(name="name", required = false) String hakusana) {
        return countryRepository.haeMaaNimella(hakusana);
    }

    @GetMapping("/api/maatjapaakaupungit")
    public Iterable<Country> restMetodiGetMaatJaPaakaupungit() {
        return countryRepository.tulostaMaatJaPaaKaupungit();
    }


}

