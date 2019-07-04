package biblioteca.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.domain.Autor;
import biblioteca.domain.Livro;
import biblioteca.domain.enums.Sexo;
import biblioteca.repositories.AutorRepository;
import biblioteca.repositories.LivroRepository;

@Service
public class DbService {
	
	@Autowired
	private AutorRepository autRep;
	
	@Autowired
	private LivroRepository livRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Autor aut1 = new Autor(null, "Juca", Sexo.M, 23);
		Autor aut2 = new Autor(null, "Zeca", Sexo.M, 32);
		Autor aut3 = new Autor(null, "João", Sexo.M, 34);
		Autor aut4 = new Autor(null, "Paulo", Sexo.M, 43);
		Autor aut5 = new Autor(null, "Pedro", Sexo.M, 54);
		Autor aut6 = new Autor(null, "Thiago", Sexo.M, 45);
		Autor aut7 = new Autor(null, "Judas", Sexo.M, 56);
		
		Livro l1 = new Livro(null, "Computador", 200.00);
		Livro l2 = new Livro(null, "Impressora", 180.00);
		Livro l3 = new Livro(null, "Mouse", 80.00);
		l1.getAutor().addAll(Arrays.asList(aut1));
		l2.getAutor().addAll(Arrays.asList(aut1,aut2));
		l3.getAutor().addAll(Arrays.asList(aut3));
		aut1.getLivros().addAll(Arrays.asList(l1,l2,l3));
		aut2.getLivros().addAll(Arrays.asList(l2));
		
		autRep.saveAll(Arrays.asList(aut1, aut2, aut3, aut4, aut5, aut6, aut7));
		livRep.saveAll(Arrays.asList(l1,l2,l3));
		
	}

}
