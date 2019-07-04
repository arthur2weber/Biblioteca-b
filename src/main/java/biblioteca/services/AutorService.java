package biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.domain.Autor;
import biblioteca.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository rep;
	
	//BUSCAR POR ID
	public Autor find (Integer id) {
		Optional<Autor> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//FAZ INSERÇÃO
	public Autor insert (Autor obj) {
		obj.setId(null);
		return rep.save(obj);
	}
	
	//ATUALIZAR
	public Autor update (Autor obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Autor> findAll(){
		return rep.findAll();
	}

}
