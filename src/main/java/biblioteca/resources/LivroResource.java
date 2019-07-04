package biblioteca.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.domain.Autor;
import biblioteca.domain.Livro;
import biblioteca.dtos.AutorDto;
import biblioteca.dtos.LivroDto;
import biblioteca.resources.utils.URL;
import biblioteca.services.LivroService;


@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	// buscar por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> find(@PathVariable Integer id) {
		Livro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value = "/busca", method = RequestMethod.GET)
	public ResponseEntity<List<LivroDto>> find(
			@RequestParam(value = "titulo", defaultValue = "") String titulo,
			@RequestParam(value = "autores", defaultValue = "") String autores) {

		String tituloDecoded = URL.decodeParam(titulo);
		List<Integer> ids = URL.decodeIntList(autores);
		List<Livro> list = service.search(tituloDecoded, ids);
		List<LivroDto> listDto = new ArrayList<LivroDto>();
		for (Livro p : list) {
			listDto.add(new LivroDto(p));
		}
		return ResponseEntity.ok().body(listDto);
	}
	
	//LISTAR TODAS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LivroDto>> findAll() {
		List<Livro> lista = service.findAll();
		List<LivroDto> listDto = new ArrayList<LivroDto>();
		
		for (Livro c : lista) {
			listDto.add(new LivroDto(c));
		}
		
		return ResponseEntity.ok().body(listDto);
	}
	
}
