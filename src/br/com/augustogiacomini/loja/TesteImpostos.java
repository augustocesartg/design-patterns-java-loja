package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.imposto.CalculadoraImposto;
import br.com.augustogiacomini.loja.imposto.ISS;
import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteImpostos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraImposto calculadoraImposto = new CalculadoraImposto();

        System.out.println(calculadoraImposto.calcular(orcamento, new ISS()));
    }
}
