import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Sistema {

    private static final int NUMERO_DE_WORKERS = 4;
    private static final int NUMERO_DE_THREADS_CLIENTES = 4;
    
    private static BlockingQueue<Pedido> filaPedidos = new LinkedBlockingQueue<>(50);

    private static ConcurrentHashMap<Integer, String> resultados = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ConcurrentHashMap<String, Integer> produtos = new ConcurrentHashMap<>();

        
    }

    
    private static void fazerPedido(int clientId) {
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
            filaPedidos.put(pedido);
            System.out.println(String.format("Cliente %d fez um pedido: %s", clientId, pedido.toString()));
        } catch (InterruptedException e) {
        }
    }
}