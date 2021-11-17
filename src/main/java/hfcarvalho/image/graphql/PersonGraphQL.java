package hfcarvalho.image.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import hfcarvalho.image.domain.Person;
import hfcarvalho.image.graphql.input.PersonInput;
import hfcarvalho.image.service.PersonService;

@Component
public class PersonGraphQL implements GraphQLQueryResolver,GraphQLMutationResolver {

    @Autowired private PersonService personService;

    public Person person(final Long id) {
        return personService.findById(id);
    }

    public List<Person> persons() {
        return personService.findAll();
    }
    
    public List<Person> personsPageable(int page, int size) {
        return personService.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Person savePerson(final PersonInput input) {
        ModelMapper m = new ModelMapper();
        Person person = m.map(input, Person.class);
        return personService.save(person);
    }

    public Boolean deletePerson(final Long id) {
        return personService.deleteById(id);
    }
}
