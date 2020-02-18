package fi.academy.jpaharkkateht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}

