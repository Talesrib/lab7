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
        ConcurrentHashMap<String, Integer> produtos = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(NUMERO_DE_WORKERS + NUMERO_DE_THREADS_CLIENTES);
        for (int i = 0; i < NUMERO_DE_WORKERS; i++) {
            Runnable worker = new WorkerThread(filaPedidos, produtos);
            executor.submit(worker);
        }

        for (int i = 0; i < NUMERO_DE_THREADS_CLIENTES; i++) {
            Runnable producer = new ProducerThread(filaPedidos);
            executor.submit(producer);
        }

        executor.shutdown();
    }
}