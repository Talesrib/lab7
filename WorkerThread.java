import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerThread extends Thread {
    BlockingQueue<Pedido> queue;
    Trabalhador trabalhador;
    WorkerThread(BlockingQueue<Pedido> q, ConcurrentHashMap<String, Integer> p) {
        this.queue = q;
        this.trabalhador = new Trabalhador(p);
    }
    
    public void run() {
        try {
        while (true) {
            Pedido x = queue.take();
            if (x == null) {
                break;
            }
            try {
                trabalhador.processarPedido(x);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        } catch (InterruptedException e) {
        }
    }
}