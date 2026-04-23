public class Tree {
    private int x;
    private int y;
    private int id;
    private TreeType type;
    private boolean viva;

    public Tree(int x, int y, int id, TreeType type) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
        this.viva = true;
    }

    public void desenhar() {
        System.out.print("[ID: " + id + "] ");
        type.desenhar(x, y);
    }

    public void crescer() {
        if (viva) {
            System.out.println("Árvore " + id + " (" + type.getNome() + ") crescendo em (" + x + ", " + y + ")");
        }
    }

    public void apodrecer() {
        this.viva = false;
        System.out.println("Árvore " + id + " (" + type.getNome() + ") apodreceu!");
    }

    public void fazerSom() {
        if (viva) {
            System.out.print("Árvore " + id + " - ");
            type.fazerSom();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public TreeType getType() {
        return type;
    }

    public boolean isViva() {
        return viva;
    }
}

