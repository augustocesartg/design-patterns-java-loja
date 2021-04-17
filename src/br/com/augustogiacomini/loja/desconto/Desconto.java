package br.com.augustogiacomini.loja.desconto;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão Template Method - com a criação de um método concreto na classe “mãe”,
 * que chama métodos abstratos implementados nas classes “filhas”.
 * Principal vantagem - Reaproveitar trechos de códigos comuns, evitando duplicações.
 */
public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if (deveAplicar(orcamento)) {
            efetuarCalculo(orcamento);
        }

        return proximo.calcular(orcamento);
    }

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

    protected abstract boolean deveAplicar(Orcamento orcamento);
}
