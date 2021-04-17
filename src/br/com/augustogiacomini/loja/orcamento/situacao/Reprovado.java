package br.com.augustogiacomini.loja.orcamento.situacao;

import br.com.augustogiacomini.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
