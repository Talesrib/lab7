import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProducerThread extends Thread {
    BlockingQueue<Pedido> queue;
    Trabalhador trabalhador;
    String[] produtos = {
        "Smartphone",
        "Notebook",
        "Câmera DSLR",
        "Fone de Ouvido Bluetooth",
        "Monitor 4K",
        "Teclado Mecânico",
        "Mouse Gamer",
        "Tablet",
        "Impressora Multifuncional",
        "Smartwatch"
    };
    
    ProducerThread(BlockingQueue<Pedido> q) { // Simula um pedido de cliente
        this.queue = q;
    }
    
    public void run() {
        try {
        while (true) {
            fazerPedido(new Random().nextInt(100));
            Thread.sleep(new Random().nextInt(1000,5000));
        }
        } catch (InterruptedException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fazerPedido(int clientId) {
        Random random = new Random();
        List<String> p = new ArrayList<>();
        List<Integer> q = new ArrayList<>();
        int nProdutos = random.nextInt(10);
        for (int i = 0; i < nProdutos; i++) {
            p.add(i, produtos[i]);
            q.add(i, random.nextInt(1,10));
        }
        Pedido pedido = new Pedido(p, q);
        try {
            queue.put(pedido);
            System.out.println(String.format("Cliente %d fez um pedido: %s", clientId, pedido.toString()));
        } catch (InterruptedException e) {
        }
    }
}
