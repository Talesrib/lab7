import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import util.Relatorio;

public class WorkerThread extends Thread {
    private BlockingQueue<Pedido> queue;
    private Trabalhador trabalhador;
    private Relatorio relatorio;
    
    WorkerThread(BlockingQueue<Pedido> q, ConcurrentHashMap<String, Integer> p, Relatorio r) {
        this.queue = q;
        this.trabalhador = new Trabalhador(p);
        this.relatorio = r;
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
                    relatorio.incrementTotalVendas();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    relatorio.incrementTotalPedidosRejeitados();
                }
            }
        } catch (InterruptedException e) {
        }
    }
}