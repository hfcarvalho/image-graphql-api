package hfcarvalho.image.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hfcarvalho.image.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
