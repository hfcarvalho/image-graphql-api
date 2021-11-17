package hfcarvalho.image.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hfcarvalho.image.domain.Image;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image findById(final Long id) {
        return imageRepository.findById(id).orElse(null);
    }
    
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public List<Image> findAll(Pageable pageable) {
        return imageRepository.findAll(pageable).getContent();
    }

    @Transactional
    //Spring cache @CacheEvict(value = "images", key = "#image.id")
    public Image save(final Image image) {
        return imageRepository.save(image);
    }

    @Transactional
    //Spring cache @CacheEvict(value = "images", key = "#id")
    public boolean deleteById(final Long id) {
        if(imageRepository.findById(id).isPresent()) {
            imageRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Image> findAllByName(String name) {
        return imageRepository.findAllByName(name);
    }
}
