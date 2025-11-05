package Exercicios.Ex11;

public class ValidarCPF {
	public boolean validar(String cpf) throws CPFInvalidoException {
        if (cpf.length() != 11) {
            throw new CPFInvalidoException("O tamanho do CPF está diferente de 11.");
        }
        return true;
    }
}
