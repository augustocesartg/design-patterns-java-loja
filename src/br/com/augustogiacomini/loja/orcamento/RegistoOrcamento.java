package br.com.augustogiacomini.loja.orcamento;

import br.com.augustogiacomini.loja.DomainException;
import br.com.augustogiacomini.loja.http.HttpAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilizado Padrão Adapter - para que a classe tenha apenas a dependência da abstração do http
 */
public class RegistoOrcamento {

    private HttpAdapter http;

    public RegistoOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {

        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orçamento não finalizado!");
        }

        String url = "http://api.loja/orcamento";

        Map<String, Object> dados = new HashMap<>();
        dados.put("valor", orcamento.getValor());
        dados.put("quantidadeItens", orcamento.getQtItens());

        http.post(url, dados);
    }

}
