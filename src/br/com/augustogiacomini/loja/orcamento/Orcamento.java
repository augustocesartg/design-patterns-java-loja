package br.com.augustogiacomini.loja.orcamento;

import br.com.augustogiacomini.loja.orcamento.situacao.EmAnalise;
import br.com.augustogiacomini.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

/**
 * Utilizado Padrão State - para para evitar vários if's no cálculo do desconto extra.
 */
public class Orcamento {

    private BigDecimal valor;

    private int qtItens;

    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, int qtItens) {
        this.valor = valor;
        this.qtItens = qtItens;
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQtItens() {
        return qtItens;
    }

    public SituacaoOrcamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }
}
