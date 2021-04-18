package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.http.JavaHttpClient;
import br.com.augustogiacomini.loja.orcamento.Orcamento;
import br.com.augustogiacomini.loja.orcamento.OrcamentoItem;
import br.com.augustogiacomini.loja.orcamento.RegistoOrcamento;

import java.math.BigDecimal;

/**
 * Adapter
 */
public class TesteRegistroOrcamento {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        OrcamentoItem item = new OrcamentoItem(BigDecimal.TEN);
        orcamento.adicionarItem(item);

        orcamento.aprovar();
        orcamento.finalizar();

        RegistoOrcamento registro = new RegistoOrcamento(new JavaHttpClient());
        registro.registrar(orcamento);
    }
}
