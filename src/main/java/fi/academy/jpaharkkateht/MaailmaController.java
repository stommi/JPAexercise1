package fi.academy.jpaharkkateht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaailmaController {
    @Autowired CountryRepository countryRepository;


    @GetMapping("/api/maat")
    public Iterable<Country> restMetodiGetMaat() {
        return countryRepository.findAll();
    }


}

