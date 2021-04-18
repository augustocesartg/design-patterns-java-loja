package br.com.augustogiacomini.loja.orcamento;

import br.com.augustogiacomini.loja.orcamento.situacao.EmAnalise;
import br.com.augustogiacomini.loja.orcamento.situacao.Finalizado;
import br.com.augustogiacomini.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizado Padrão State - para para evitar vários if's no cálculo do desconto extra.
 */
public class Orcamento implements Orcavel {

    private BigDecimal valor;

    private SituacaoOrcamento situacao;

    private List<Orcavel> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.situacao = new EmAnalise();
        this.itens = new ArrayList<>();
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

    @Override
    public BigDecimal getValor() {
        // Thread sleep adicionado para testar proxy (cache)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.valor;
    }

    public int getQtItens() {
        return itens.size();
    }

    public SituacaoOrcamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }

    public void adicionarItem(Orcavel item) {
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }
}
