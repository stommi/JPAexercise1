package fi.academy.jpaharkkateht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired CityRepository cityRepository;

    @GetMapping("/api/kaupungit")
    public Iterable<City> restMetodiGetKaupungit() {
        return cityRepository.findAll();
    }

}