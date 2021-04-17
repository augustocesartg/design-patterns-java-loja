package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.desconto.CalculadoraDesconto;
import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDescontos {

    public static void main(String[] args) {
        Orcamento descontoPorQuantidadeItens = new Orcamento(new BigDecimal("200"), 6);
        Orcamento descontoPorValor = new Orcamento(new BigDecimal("1000"), 1);
        Orcamento descontoExtraEmAnalise = new Orcamento(new BigDecimal("1000"), 1);
        Orcamento descontoExtraAprovado = new Orcamento(new BigDecimal("1000"), 1);

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
