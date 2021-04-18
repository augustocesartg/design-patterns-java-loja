package br.com.augustogiacomini.loja.pedido;

import br.com.augustogiacomini.loja.orcamento.Orcamento;
import br.com.augustogiacomini.loja.orcamento.OrcamentoItem;
import br.com.augustogiacomini.loja.pedido.acao.AcaoAposGerarPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Utilizado Padrão Command Hnadler - para extrair a lógica de gerar o pedido.
 * Utilizado Padrão Observer - para desacoplar chamadas para executar ações após ser gerado pedido.
 * Utilizado Padrão Facade - Uma classe desse tipo nos fornece poucos métodos públicos (um só, no nosso caso),
 * com toda a infraestrutura necessária para realizar a tarefa.
 */
public class GeraPedidoHandler {

    private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento();
        OrcamentoItem item = new OrcamentoItem(dados.getValorOrcamento());
        orcamento.adicionarItem(item);

        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
