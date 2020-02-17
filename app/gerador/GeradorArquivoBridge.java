package app.gerador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import app.gerador.componente.PosProcessador;

public abstract class GeradorArquivoBridge {
    private PosProcessador processador;

    public void setProcessador(PosProcessador processador) {
        this.processador = processador;
    }

    /**
     * Dado o conteúdo das propriedades gera o arquivo
     * @param propriedades propriedades passadas
     * @return conteudo gerado em uma String
     */
    protected abstract String gerarConteudo(Map<String, Object> propriedades);

    /**
     * Gerar um arquivo de propriedades 
     * @param nome nome do arquivo
     * @param propriedades propriedades passadas
     * @throws IOException levanta I/O exception caso ocorra um erro correspondente
     */
    public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
        String conteudo = gerarConteudo(propriedades);
        byte[] bytes = conteudo.getBytes();
        bytes = (byte[]) this.processador.processar(bytes);

        FileOutputStream fileOut = new FileOutputStream(nome);
        fileOut.write(bytes);
        fileOut.close();
    }

}