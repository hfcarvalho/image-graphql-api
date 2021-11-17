package hfcarvalho.image.graphql.exceptions;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import graphql.servlet.GenericGraphQLError;

public class SimpleGraphQLError extends GenericGraphQLError {

	private static final long serialVersionUID = 1L;

	public SimpleGraphQLError(String message) {
		super(message);
	}

	@Override
	@JsonIgnore
	public List<Object> getPath() {
		return null;
	}

	@Override
	@JsonIgnore
	public Map<String, Object> getExtensions() {
		return null;
	}
}
