package fi.academy.jpaharkkateht;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String> {
}
