package biblioteca.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.domain.Autor;
import biblioteca.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
	List<Livro> findDistinctByTituloContainingAndAutorIn(
			String titulo,
			List<Autor> autor
	);
}
