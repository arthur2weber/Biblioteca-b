package biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.domain.Autor;
import biblioteca.domain.Livro;
import biblioteca.repositories.AutorRepository;
import biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository rep;

	@Autowired
	private AutorRepository AutorRepository;
	
	// busca por ID
	public Livro find(Integer id) {
		Optional<Livro> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	// busca por texto
	public List<Livro> search(String titulo, List<Integer> ids) {
		List<Autor> autores = AutorRepository.findAllById(ids);
		return rep.findDistinctByTituloContainingAndAutorIn(titulo, autores);
	}
	
	//LISTAR TODAS
	public List<Livro> findAll(){
		return rep.findAll();
	}
	
	//FAZ INSERÇÃO
	public Livro insert (Livro obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	//ATUALIZAR
	public Livro update (Livro obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
}
