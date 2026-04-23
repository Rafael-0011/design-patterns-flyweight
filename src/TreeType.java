public class TreeType {
    private String nome;
    private String cor;
    private String textura;
    private String som;

    public TreeType(String nome, String cor, String textura, String som) {
        this.nome = nome;
        this.cor = cor;
        this.textura = textura;
        this.som = som;
    }

    public void desenhar(int x, int y) {
        System.out.println("Desenhando " + nome + " em (" + x + ", " + y + ")");
        System.out.println("  Cor: " + cor + " | Textura: " + textura);
    }

    public void fazerSom() {
        System.out.println("Som da árvore " + nome + ": " + som);
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getTextura() {
        return textura;
    }

    public String getSom() {
        return som;
    }

    @Override
    public String toString() {
        return "TreeType{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", textura='" + textura + '\'' +
                '}';
    }
}

