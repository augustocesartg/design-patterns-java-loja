package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.orcamento.Orcamento;
import br.com.augustogiacomini.loja.orcamento.OrcamentoItem;
import br.com.augustogiacomini.loja.orcamento.OrcamentoProxy;

import java.math.BigDecimal;

/**
 * Composite, Proxy (cache)
 */
public class TesteAdicionarOrcamentoReprovadoNovo {

    public static void main(String[] args) {
        Orcamento orcamentoAntigo = new Orcamento();
        orcamentoAntigo.adicionarItem(new OrcamentoItem(new BigDecimal("200")));
        orcamentoAntigo.reprovar();

        Orcamento orcamentoNovo = new Orcamento();
        orcamentoNovo.adicionarItem(new OrcamentoItem(new BigDecimal("500")));
        orcamentoNovo.adicionarItem(orcamentoAntigo);

        OrcamentoProxy proxy = new OrcamentoProxy(orcamentoNovo);

        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());
    }
}
