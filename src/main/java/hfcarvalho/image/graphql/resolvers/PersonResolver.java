package hfcarvalho.image.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import hfcarvalho.image.domain.Person;

@Component
public class PersonResolver implements GraphQLResolver<Person> {
}
