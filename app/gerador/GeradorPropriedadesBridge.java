package app.gerador;

import java.util.Map;

public class GeradorPropriedadesBridge extends GeradorArquivoBridge {
    @Override
    protected String gerarConteudo(Map<String, Object> props) {
        StringBuilder propFileBuilder = new StringBuilder();
        
        for (String prop : props.keySet()) {
            propFileBuilder.append(prop + "=" + props.get(prop) + "\n");
        }
        return propFileBuilder.toString();
    }
}