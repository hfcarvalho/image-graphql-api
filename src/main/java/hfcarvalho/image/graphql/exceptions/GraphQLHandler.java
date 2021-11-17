package hfcarvalho.image.graphql.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.validation.ValidationError;

@Component
public class GraphQLHandler implements GraphQLErrorHandler {
    
	@Autowired
    private Environment env;

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getErros).collect(Collectors.toList());
    }

    private GraphQLError getErros(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof DomainException) {
                Throwable ex = exceptionError.getException();
                String msg = ex.getMessage();
                return new SimpleGraphQLError(msg);
            }

            String[] profiles = env.getActiveProfiles();
            boolean dev = ArrayUtils.contains(profiles,"dev");
            if(! dev ) {
                return new SimpleGraphQLError("Error occurred at transaction processing.");
            }

        } else if (error instanceof ValidationError) {
            String msg = error.getMessage();
            return new SimpleGraphQLError(msg);
        }
        return error;
    }
}
