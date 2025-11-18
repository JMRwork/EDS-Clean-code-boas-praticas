package Ex07;

public interface RelatorioFactory {
	Relatorio criarRelatorio();
}

public class PDFRelatorioFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioPDF();
    }
}

public class CSVRelatorioFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioCSV();
    }
}

public class JSONRelatorioFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioJSON();
    }
}