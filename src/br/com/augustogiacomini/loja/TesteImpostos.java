package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.imposto.CalculadoraImposto;
import br.com.augustogiacomini.loja.imposto.ICMS;
import br.com.augustogiacomini.loja.imposto.ISS;
import br.com.augustogiacomini.loja.orcamento.Orcamento;
import br.com.augustogiacomini.loja.orcamento.OrcamentoItem;

import java.math.BigDecimal;

/**
 * Strategy, Decorator
 */
public class TesteImpostos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        OrcamentoItem item = new OrcamentoItem(new BigDecimal("100"));
        orcamento.adicionarItem(item);

        CalculadoraImposto calculadoraImposto = new CalculadoraImposto();

        System.out.println(calculadoraImposto.calcular(orcamento, new ISS(new ICMS(null))));
    }
}
