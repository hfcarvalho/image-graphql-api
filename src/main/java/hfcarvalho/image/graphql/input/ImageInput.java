package hfcarvalho.image.graphql.input;

import lombok.Data;

@Data
public class ImageInput {

    private Long id;
    private String name;
    private String description;
    private String altDescription;
    private String path;
    private String type;
    
    private Long folderId;
    
}
