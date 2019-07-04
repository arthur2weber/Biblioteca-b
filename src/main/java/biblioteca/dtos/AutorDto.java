package biblioteca.dtos;

import java.io.Serializable;

import biblioteca.domain.Autor;
import biblioteca.domain.enums.Sexo;


public class AutorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id,idade;
	private String nome;
	private Sexo sexo;
	
	
	public AutorDto(Autor c) {
		id = c.getId();
		nome = c.getNome();
		idade = c.getIdade();
		sexo = c.getSexo();
	}
	
	public AutorDto() {
		
	}
	
	public AutorDto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorDto other = (AutorDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
