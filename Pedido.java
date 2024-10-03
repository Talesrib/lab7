import java.util.List;
import java.util.Random;

public class Pedido {
  List<String> produtos;
  List<Integer> quantity;
  Long id;

  public Pedido(List<String> produtos, List<Integer> q) {
    this.produtos = produtos;
    this.quantity = q;
    this.id = new Random().nextLong();
  }

  public String toString() {
    String result = String.format("id: %d ", id);
    for (int e = 0; e < this.produtos.size(); e++) {
      result += String.format("%s: %d ", produtos.get(e), quantity.get(e));
    }
    return result;
  }
}
