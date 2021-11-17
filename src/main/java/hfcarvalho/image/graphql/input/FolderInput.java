package hfcarvalho.image.graphql.input;

import lombok.Data;

@Data
public class FolderInput {

    private Long id;
    private String name;
    private String type;
    private String description;
    private String path;

}
