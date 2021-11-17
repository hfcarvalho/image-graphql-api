package hfcarvalho.image.service;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import hfcarvalho.image.domain.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
	
	@Override
    //JPA Cache
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	List<Folder> findAll();


}