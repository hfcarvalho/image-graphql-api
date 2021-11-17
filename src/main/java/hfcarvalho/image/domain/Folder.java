package hfcarvalho.image.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
public class Folder {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFolder;
    private String name;
    private String type;
    private String description;
    private String path;
    private LocalDate dataCriacao;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idImage", nullable = true)
    private List<Image> images;

}
