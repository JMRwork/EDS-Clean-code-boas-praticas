package Ex09;

import java.util.LinkedList;
import java.util.Queue;

public class FilaMensagens {
	private Queue mensagens = new LinkedList<String>();

    public String visualizarProximaMensagem() {
        return mensagens.peek();
    }
    
    public String consumirProximaMensagem() {
    	return mensagens.poll();
    }
}
