package Ex05;

public interface CategoriaCliente {
	boolean aplicavel(int idade, double renda, int compras, String localizacao);

	String getCategoria();
}

public class SenioridadePremium implements CategoriaCliente {

	@Override
	public boolean aplicavel(int idade, double renda, int compras, String localizacao) {
		return (idade > 60 && renda > 5000 && compras > 10);
	}

	@Override
	public String getCategoria() {
		return "Cliente Premium Sênior";
	}
}

public class SenioridadeRegular implements CategoriaCliente {

	@Override
	public boolean aplicavel(int idade, double renda, int compras, String localizacao) {
		return (idade > 60 && renda > 5000 && compras <= 10);
	}

	@Override
	public String getCategoria() {
		return "Cliente Regular Sênior";
	}
}

public class SenioridadeBaixaRenda implements CategoriaCliente {

	@Override
	public boolean aplicavel(int idade, double renda, int compras, String localizacao) {
		return (idade > 60 && renda <= 5000);
	}

	@Override
	public String getCategoria() {
		return "Cliente Sênior Baixa Renda";
	}
}

public class JovemPremium implements CategoriaCliente {

	@Override
	public boolean aplicavel(int idade, double renda, int compras, String localizacao) {
		return (idade <= 60 && renda > 7000 && compras > 20);
	}

	@Override
	public String getCategoria() {
		return "Cliente Premium Jovem";
	}
}

public class JovemRegular implements CategoriaCliente {

	@Override
	public boolean aplicavel(int idade, double renda, int compras, String localizacao) {
		return (idade <= 60 && renda > 7000 && compras <= 20);
	}

	@Override
	public String getCategoria() {
		return "Cliente Regular Jovem";
	}
}

public class JovemBaixaRenda implements CategoriaCliente {

	@Override
	public boolean aplicavel(int idade, double renda, int compras, String localizacao) {
		return (idade <= 60 && renda <= 7000);
	}

	@Override
	public String getCategoria() {
		return "Cliente Jovem Baixa Renda";
	}
}