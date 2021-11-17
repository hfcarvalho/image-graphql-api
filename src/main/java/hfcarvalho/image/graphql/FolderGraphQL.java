package hfcarvalho.image.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import hfcarvalho.image.domain.Folder;
import hfcarvalho.image.graphql.input.FolderInput;
import hfcarvalho.image.service.FolderService;

@Component
public class FolderGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private FolderService folderService;

    public Folder folder(final Long id) {
        return folderService.findById(id);
    }

    public List<Folder> folders() {
        return folderService.findAll();
    }

    public Folder saveFolder(final FolderInput input) {
        ModelMapper m = new ModelMapper();
        Folder folder = m.map(input, Folder.class);

        return folderService.save(folder);
    }

    public Boolean deleteFolder(final Long id) {
        return folderService.deleteById(id);
    }
}
