package fi.academy.jpaharkkateht;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends CrudRepository<Country, String> {
    @Query ("SELECT c FROM Country c WHERE c.code = :koodi")
    Iterable<Country> haeMaaKoodilla(@Param("koodi") String koodi);

    @Query ("SELECT c FROM Country c WHERE c.name = :nimi")
    Iterable<Country> haeMaaNimella(@Param("nimi") String nimi);

    @Query ("SELECT c.name, c.city.name FROM Country c")
    Iterable<Country> tulostaMaatJaPaaKaupungit();
}
