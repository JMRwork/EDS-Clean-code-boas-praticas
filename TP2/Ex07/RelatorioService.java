package Ex07;

public class RelatorioService {
	public void gerarRelatorio(String tipo) {
		Relatorio relatorio;
		switch (tipo) {
			case "PDF" -> relatorio = new RelatorioPDF();
			case "CSV" -> relatorio = new RelatorioCSV();
			case "JSON" -> relatorio = new RelatorioJSON();
			default -> {
				System.out.println("Tipo de relatório desconhecido!");
				return;
			}
		}
		relatorio.gerarCabecalho();
		relatorio.gerarCorpo();
		relatorio.gerarRodape();
	}
}
