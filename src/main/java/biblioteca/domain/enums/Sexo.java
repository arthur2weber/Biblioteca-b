package biblioteca.domain.enums;

public enum Sexo {
	
	M(1, "Masculino"),
	F(2, "Feminino");

	private int cod;
	private String descricao;

	private Sexo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static Sexo toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Sexo x : Sexo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}