package fi.academy.jpaharkkateht;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    Iterable<City> findByName(String name);
}
