package fi.academy.jpaharkkateht;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Iterable<City> findByName(String name);
    Iterable<City> findByPopulationGreaterThanEqual(Long population);
}
