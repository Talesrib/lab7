import java.util.concurrent.*;

public class Sistema {

    private static final int NUMERO_DE_WORKERS = 4;
    private static final int NUMERO_DE_THREADS_CLIENTES = 4;
    static String[] produtos = {
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
    
    private static BlockingQueue<Pedido> filaPedidos = new LinkedBlockingQueue<>(50);

    private static ConcurrentHashMap<Integer, String> resultados = new ConcurrentHashMap<>();

    class Worker extends Thread {
        BlockingQueue<Pedido> queue;
        Trabalhador trabalhador;
        Worker(BlockingQueue<Pedido> q, ConcurrentHashMap<String, Integer> p) {
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
                trabalhador.processarPedido(x);
            }
            } catch (InterruptedException e) {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ConcurrentHashMap<String, Integer> produtos = new ConcurrentHashMap<>();

        
    }

}