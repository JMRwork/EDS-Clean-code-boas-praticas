package Ex07;

public interface Relatorio {
 void gerarCabecalho();
 void gerarCorpo();
 void gerarRodape();
}

public class RelatorioPDF implements Relatorio {
 @Override
 public void gerarCabecalho() {
     System.out.println("Gerando cabeçalho PDF...");
 }
 
 @Override
 public void gerarCorpo() {
     System.out.println("Gerando corpo PDF...");
 }
 
 @Override
 public void gerarRodape() {
     System.out.println("Gerando rodapé PDF...");
 }
}

public class RelatorioCSV implements Relatorio {
 @Override
 public void gerarCabecalho() {
     System.out.println("Gerando cabeçalho CSV...");
 }
 
 @Override
 public void gerarCorpo() {
     System.out.println("Gerando corpo CSV...");
 }
 
 @Override
 public void gerarRodape() {
     System.out.println("Gerando rodapé CSV...");
 }
}

public class RelatorioJSON implements Relatorio {
 @Override
 public void gerarCabecalho() {
     System.out.println("Gerando cabeçalho JSON...");
 }
 
 @Override
 public void gerarCorpo() {
     System.out.println("Gerando corpo JSON...");
 }
 
 @Override
 public void gerarRodape() {
     System.out.println("Gerando rodapé JSON...");
 }
}