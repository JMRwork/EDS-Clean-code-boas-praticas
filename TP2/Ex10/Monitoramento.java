package Ex10;

public class Monitoramento {
	private int contadorAcessos = 0;

    public int obterAcessos() {
        return contadorAcessos; 
    }
    
    public void novoAcesso() {
    	contadorAcessos++;
    }
}
