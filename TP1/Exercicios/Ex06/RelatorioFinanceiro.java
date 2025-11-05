package Exercicios.Ex06;

import java.util.List;

public class RelatorioFinanceiro {

	private String cabecalhoRelatorio() {
		return "=== Relatório Financeiro ===";
	}
	
	private String corpoRelatorio(List clientes, List saldos) {
		String corpo = "";
		 for (int i = 0; i < clientes.size(); i++) {
	            corpo += "Cliente: " + clientes.get(i) + " - Saldo: R$ " + saldos.get(i) + "\n";
	        }
		return corpo;
	}
	
	private String rodapeRelatorio() {
		return "===========================\nFim do Relatório";
	}
	
	public void gerarRelatorio(List clientes, List saldos) {
		System.out.println(cabecalhoRelatorio());
		System.out.println(corpoRelatorio(clientes, saldos));
		System.out.println(rodapeRelatorio());
	}
}
