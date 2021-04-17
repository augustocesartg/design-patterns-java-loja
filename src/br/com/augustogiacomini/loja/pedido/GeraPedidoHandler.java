package br.com.augustogiacomini.loja.pedido;

import br.com.augustogiacomini.loja.orcamento.Orcamento;
import br.com.augustogiacomini.loja.pedido.acao.AcaoAposGerarPedido;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Utilizado Padrão Command Hnadler - para extrair a lógica de gerar o pedido.
 * Utilizado Padrão Observer - para desacoplar chamadas para executar ações após ser gerado pedido.
 */
public class GeraPedidoHandler {

    private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());

        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
