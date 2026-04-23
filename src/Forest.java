import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> arvores = new ArrayList<>();
    private int contador = 0;

    public void plantarArvore(String tipoNome, String cor, String textura, String som, int x, int y) {
        TreeType treeType = TreeTypeFactory.getTreeType(tipoNome, cor, textura, som);
        Tree tree = new Tree(x, y, contador++, treeType);
        arvores.add(tree);
        System.out.println("🌱 Árvore #" + (contador - 1) + " plantada em (" + x + ", " + y + ")\n");
    }

    public void desenharFlorestA() {
        System.out.println("\n🎨 Desenhando Floresta:");
        System.out.println("═".repeat(50));
        for (Tree arvore : arvores) {
            if (arvore.isViva()) {
                arvore.desenhar();
            }
        }
        System.out.println("═".repeat(50));
    }

    public void crescerTodas() {
        System.out.println("\n🌱 Fazendo todas as árvores crescerem:");
        System.out.println("─".repeat(50));
        for (Tree arvore : arvores) {
            arvore.crescer();
        }
        System.out.println("─".repeat(50));
    }

    public void fazerSonsFlorestA() {
        System.out.println("\n🔊 Sons da Floresta:");
        System.out.println("─".repeat(50));
        for (Tree arvore : arvores) {
            arvore.fazerSom();
        }
        System.out.println("─".repeat(50));
    }

    public void removerArvore(int id) {
        for (Tree arvore : arvores) {
            if (arvore.getId() == id) {
                arvore.apodrecer();
                return;
            }
        }
        System.out.println("Árvore com ID " + id + " não encontrada!");
    }

    public int getTotalArvores() {
        return arvores.size();
    }

    public int getTotalArvoresas() {
        int total = 0;
        for (Tree arvore : arvores) {
            if (arvore.isViva()) {
                total++;
            }
        }
        return total;
    }

    public void exibirStatisticas() {
        System.out.println("\n📊 ESTATÍSTICAS DA FLORESTA:");
        System.out.println("═".repeat(50));
        System.out.println("Total de árvores plantadas: " + getTotalArvores());
        System.out.println("Árvores vivas: " + getTotalArvoresas());
        System.out.println("Árvores mortas: " + (getTotalArvores() - getTotalArvoresas()));
        System.out.println("Tipos de árvores únicos (Flyweights): " + TreeTypeFactory.getTotalTreeTypesEmCache());
        System.out.println("═".repeat(50));
    }

    public void exibirDetalhes() {
        System.out.println("\n📋 DETALHES DAS ÁRVORES NA FLORESTA:");
        System.out.println("═".repeat(50));
        for (Tree arvore : arvores) {
            System.out.println("Árvore #" + arvore.getId() +
                    " | Tipo: " + arvore.getType().getNome() +
                    " | Posição: (" + arvore.getX() + ", " + arvore.getY() + ")" +
                    " | Status: " + (arvore.isViva() ? "VIVA" : "MORTA"));
        }
        System.out.println("═".repeat(50));
    }
}

