package hfcarvalho.image.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hfcarvalho.image.domain.Folder;

@Service
public class FolderService {

    @Autowired
    private FolderRepository repository;

    //@Cacheable(value = "folders")
    public List<Folder> findAll() {
        return repository.findAll();
    }

    //@Cacheable(value = "folders", key = "#id")
    public Folder findById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    //@CacheEvict(value = "folders", key = "#folder.id")
    public Folder save(final Folder folder) {
        return repository.save(folder);
    }

    @Transactional
    //@CacheEvict(value = "folders", key = "#id")
    public Boolean deleteById(final Long id) {
        if(repository.findById(id).isPresent()) {
        	repository.deleteById(id);
            return true;
        }
        return false;
    }
}
