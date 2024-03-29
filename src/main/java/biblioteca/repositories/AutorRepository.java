package biblioteca.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.domain.Autor;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
