package util;

public class GerarRelatorio {
    public static void gerarRelatorio(Relatorio r) {
        System.out.println("**** *** ****");  
        System.out.println("RELATORIO");  
        System.out.println(String.format("- Numero total de pedidos: %d", r.totalPedidos()));
        System.out.println(String.format("- Numero total de vendas: %d", r.totalVendas()));
        System.out.println(String.format("- Numero de pedidos rejeitados (por falta de estoque): %d", r.totalPedidosRejeitados()));
        System.out.println("**** *** ****");  
    };
}
