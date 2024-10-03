import java.util.concurrent.ConcurrentHashMap;

public class Trabalhador {
  private ConcurrentHashMap<String, Integer> produtos;

  public Trabalhador(ConcurrentHashMap<String, Integer> p) {
    this.produtos = p;
  }

  public void processarPedido(Pedido pedido) throws Exception {
    
    for(int i = 0; i < pedido.produtos.size(); i++) {
      String produto = pedido.produtos.get(i);
      Integer quantity = pedido.quantity.get(i);

      if (this.produtos.contains(produto) && this.produtos.get(produto) >= quantity) {
        
      } else {
        System.out.println(produto+ " "+ quantity);
        throw new Exception("Pedido rejeitado!");
      }
    }

    for(int i = 0; i < pedido.produtos.size(); i++) {
      String produto = pedido.produtos.get(i);
      Integer quantity = pedido.quantity.get(i);

      this.produtos.put(produto, produtos.get(produto) - quantity);
    }
    System.out.println(String.format("Pedido de id %d processado", pedido.id));
  }
}
