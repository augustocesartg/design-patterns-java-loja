package br.com.augustogiacomini.loja;

import br.com.augustogiacomini.loja.pedido.GeraPedido;
import br.com.augustogiacomini.loja.pedido.GeraPedidoHandler;
import br.com.augustogiacomini.loja.pedido.acao.EnviarEmailPedido;
import br.com.augustogiacomini.loja.pedido.acao.LogPedido;
import br.com.augustogiacomini.loja.pedido.acao.SalvarPedido;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Command Hnadler, Observer
 */
public class TestePedidos {

    public static void main(String[] args) {
        String cliente = "Augusto Giacomini";
        BigDecimal valorOrcamento = new BigDecimal("300");
        int quantidadeItens = Integer.parseInt("2");

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(
                Arrays.asList(new EnviarEmailPedido(), new SalvarPedido(), new LogPedido())
        );

        geraPedidoHandler.executa(gerador);
    }
}
