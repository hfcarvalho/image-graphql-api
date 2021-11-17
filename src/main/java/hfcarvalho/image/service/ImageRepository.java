package hfcarvalho.image.service;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hfcarvalho.image.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("select img from Image img where img.folder.id = :folderId")
    //JPA Cache
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Image> findAllByFolder(@Param("folderId") Long id);
    
    List<Image> findAllByName(@Param("name") String name);
}