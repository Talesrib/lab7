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
}
