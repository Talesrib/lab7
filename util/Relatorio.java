package util;
import java.util.concurrent.atomic.AtomicInteger;

public class Relatorio {
    
    private AtomicInteger totalPedidos = new AtomicInteger(0);
    private AtomicInteger totalVendas = new AtomicInteger(0);
    private AtomicInteger pedidosRejeitados = new AtomicInteger(0);

    public void incrementTotalPedidos() {
        totalPedidos.incrementAndGet();
    }

    public int totalPedidos() {
        return totalPedidos.get();
    }
    
    public int totalVendas() {
        return totalVendas.get();
    }

    public void incrementTotalVendas() {
        totalVendas.incrementAndGet();
    }

    public void incrementTotalPedidosRejeitados() {
        pedidosRejeitados.incrementAndGet();
    }

    public int totalPedidosRejeitados() {
        return pedidosRejeitados.get();
    }
}