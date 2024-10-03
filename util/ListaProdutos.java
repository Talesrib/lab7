package util;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ListaProdutos {
    private static String[] produtos = {
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

    public static String[] getProdutos() {
        return produtos;
    }

    public static ConcurrentHashMap<String, Integer> generateInitialProdutos() {
        ConcurrentHashMap<String, Integer> p = new ConcurrentHashMap<>();
        for (int e = 0; e < produtos.length; e++) {
            p.put(produtos[e], new Random().nextInt(250, 500));
        }
        System.out.println(p.toString());
        return p;
    };

    public static void reaProdutos(ConcurrentHashMap<String, Integer> p) {
        int q = 0;
        for (int e = 0; e < produtos.length; e++) {
            int r = new Random().nextInt(250);
            p.put(produtos[e], p.get(produtos[e]) + r);
            q+= r;
        }
        System.out.println(String.format("Sistema abastecido com %d items", q));
    };
}
