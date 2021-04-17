package br.com.augustogiacomini.loja.pedido.acao;

import br.com.augustogiacomini.loja.pedido.Pedido;

public class SalvarPedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Salvando pedido no banco de dados...");
    }
}
