package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.desconto.CalculadoraDesconto;
import br.com.augustogiacomini.loja.orcamento.Orcamento;
import br.com.augustogiacomini.loja.orcamento.OrcamentoItem;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Chain of Responsability, State, Template Method
 */
public class TesteDescontos {

    public static void main(String[] args) {
        Orcamento descontoPorQuantidadeItens = new Orcamento();
        Orcamento descontoPorValor = new Orcamento();
        Orcamento descontoExtraEmAnalise = new Orcamento();
        Orcamento descontoExtraAprovado = new Orcamento();

        OrcamentoItem item1 = new OrcamentoItem(new BigDecimal("200"));
        Arrays.asList(item1, item1, item1, item1, item1, item1).forEach(item -> descontoPorQuantidadeItens.adicionarItem(item));

        OrcamentoItem item2 = new OrcamentoItem(new BigDecimal("1000"));
        descontoPorValor.adicionarItem(item2);
        descontoExtraEmAnalise.adicionarItem(item2);
        descontoExtraAprovado.adicionarItem(item2);

        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();

        System.out.println("Valor Desconto por quantidade de itens: " + calculadoraDesconto.calcular(descontoPorQuantidadeItens));
        System.out.println("Valor Desconto por valor do orçamento: " + calculadoraDesconto.calcular(descontoPorValor));

        descontoExtraEmAnalise.aplicarDescontoExtra();
        System.out.println("Valor Desconto extra, situação em análise: " + calculadoraDesconto.calcular(descontoExtraEmAnalise));

        descontoExtraAprovado.aprovar();
        descontoExtraAprovado.aplicarDescontoExtra();
        System.out.println("Valor Desconto extra, situação aprovado: " + calculadoraDesconto.calcular(descontoExtraAprovado));
    }
}
