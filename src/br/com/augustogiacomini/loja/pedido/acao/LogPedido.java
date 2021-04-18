package br.com.augustogiacomini.loja.pedido.acao;

import br.com.augustogiacomini.loja.pedido.Pedido;

public class LogPedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido foi gerado: " + pedido);
    }
}
