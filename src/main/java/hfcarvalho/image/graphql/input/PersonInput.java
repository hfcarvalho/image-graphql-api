package hfcarvalho.image.graphql.input;

import java.util.Date;

import lombok.Data;

@Data
public class PersonInput {

	private Long id;
	private String name;
	private Date birthDate;
	private String email;
	
}
