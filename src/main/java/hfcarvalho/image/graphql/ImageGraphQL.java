package hfcarvalho.image.graphql;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import hfcarvalho.image.domain.Image;
import hfcarvalho.image.graphql.input.ImageInput;
import hfcarvalho.image.service.FolderService;
import hfcarvalho.image.service.ImageService;

@Component
public class ImageGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired private ImageService imageService;
    @Autowired private FolderService folderService;

    public Image image(final Long id) {
        return imageService.findById(id);
    }
    
    public List<Image> images() {
    	return imageService.findAll();
    }

    public List<Image> imagesPageable(int page, int size) {
        return imageService.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Image saveImage(final ImageInput input) {
        ModelMapper m = new ModelMapper();
        Image image = m.map(input, Image.class);

        image.setDataCriacao(LocalDate.now());

        image.setFolder(folderService.findById(input.getFolderId()));

        return imageService.save(image);
    }

    public Boolean deleteImage(Long id) {
        return imageService.deleteById(id);
    }
}
