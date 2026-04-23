import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String nome, String cor, String textura, String som) {
        String chave = nome + "_" + cor + "_" + textura;

        TreeType treeType = treeTypes.get(chave);

        if (treeType == null) {
            System.out.println("✓ Criando novo TreeType (Flyweight): " + nome);
            treeType = new TreeType(nome, cor, textura, som);
            treeTypes.put(chave, treeType);
        } else {
            System.out.println("✓ Reutilizando TreeType (Flyweight): " + nome);
        }

        return treeType;
    }

    public static int getTotalTreeTypesEmCache() {
        return treeTypes.size();
    }

    public static void exibirTreeTypesEmCache() {
        System.out.println("\n📦 TreeTypes em Cache (Flyweights):");
        System.out.println("Total: " + treeTypes.size());
        int contador = 1;
        for (Map.Entry<String, TreeType> entry : treeTypes.entrySet()) {
            System.out.println("  " + contador + ". " + entry.getValue());
            contador++;
        }
    }

    public static void limparCache() {
        treeTypes.clear();
        System.out.println("Cache de TreeTypes limpo!");
    }
}

