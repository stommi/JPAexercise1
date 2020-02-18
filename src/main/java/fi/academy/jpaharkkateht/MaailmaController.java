package fi.academy.jpaharkkateht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
