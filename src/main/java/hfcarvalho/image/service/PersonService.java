package hfcarvalho.image.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hfcarvalho.image.domain.Person;

@Service
public class PersonService {
	
    @Autowired
    private PersonRepository personRepository;

    public Person findById(final Long id) {
        return personRepository.findById(id).orElse(null);
    }

    //@Cacheable("persons")
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    
    public List<Person> findAll(Pageable pageable) {
    	return personRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Person save(final Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Boolean deleteById(final Long id) {
        if(personRepository.findById(id).isPresent()) {
        	personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
