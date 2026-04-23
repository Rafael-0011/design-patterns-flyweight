public class MainFlyweight {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║      PADRÃO FLYWEIGHT - SISTEMA DE FLORESTA        ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        // Criando a floresta
        Forest floresta = new Forest();

        System.out.println(">>> FASE 1: Plantando Árvores na Floresta");
        System.out.println("Observe como o padrão Flyweight reutiliza os tipos de árvores!\n");

        // Plantando árvores do mesmo tipo (compartilham o Flyweight)
        System.out.println("--- Plantando Carvalhos ---");
        floresta.plantarArvore("Carvalho", "Marrom", "Rugosa", "Sussuros suaves", 10, 20);
        floresta.plantarArvore("Carvalho", "Marrom", "Rugosa", "Sussuros suaves", 30, 40);
        floresta.plantarArvore("Carvalho", "Marrom", "Rugosa", "Sussuros suaves", 50, 60);

        Thread.sleep(1500);

        // Plantando árvores de outro tipo (novo Flyweight)
        System.out.println("--- Plantando Pinheiros ---");
        floresta.plantarArvore("Pinheiro", "Verde Escuro", "Lisa", "Assobios altos", 15, 25);
        floresta.plantarArvore("Pinheiro", "Verde Escuro", "Lisa", "Assobios altos", 35, 45);

        Thread.sleep(1500);

        // Plantando mais carvalhos (reutilizam o Flyweight já existente)
        System.out.println("--- Plantando mais Carvalhos ---");
        floresta.plantarArvore("Carvalho", "Marrom", "Rugosa", "Sussuros suaves", 70, 80);
        floresta.plantarArvore("Carvalho", "Marrom", "Rugosa", "Sussuros suaves", 90, 100);

        Thread.sleep(1500);

        // Plantando árvore de tipo diferente
        System.out.println("--- Plantando Bétulas ---");
        floresta.plantarArvore("Bétula", "Branco", "Suave", "Murmúrios suaves", 55, 65);
        floresta.plantarArvore("Bétula", "Branco", "Suave", "Murmúrios suaves", 75, 85);

        Thread.sleep(1500);

        // Mostrando cache de Flyweights
        TreeTypeFactory.exibirTreeTypesEmCache();

        Thread.sleep(2000);

        // Exibindo estatísticas
        floresta.exibirStatisticas();

        Thread.sleep(2000);

        // Desenhando floresta
        floresta.desenharFlorestA();

        Thread.sleep(2000);

        // Fazendo árvores crescerem
        floresta.crescerTodas();

        Thread.sleep(2000);

        // Ouvindo sons da floresta
        floresta.fazerSonsFlorestA();

        Thread.sleep(2000);

        // Removendo algumas árvores (simulando morte)
        System.out.println("\n💀 Removendo algumas árvores:");
        System.out.println("─".repeat(50));
        floresta.removerArvore(1);
        floresta.removerArvore(4);
        floresta.removerArvore(6);
        System.out.println("─".repeat(50));

        Thread.sleep(2000);

        // Mostrando estatísticas atualizadas
        floresta.exibirStatisticas();

        Thread.sleep(2000);

        // Exibindo detalhes completos
        floresta.exibirDetalhes();

        Thread.sleep(2000);

        // Explicação do padrão
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║           EXPLICAÇÃO DO PADRÃO FLYWEIGHT           ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        System.out.println("📌 O QUE É FLYWEIGHT?");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("O padrão Flyweight é um padrão estrutural que permite");
        System.out.println("compartilhar dados comuns entre múltiplos objetos para");
        System.out.println("economizar memória.\n");

        System.out.println("🎯 CONCEITO CENTRAL:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("Dividir dados em duas categorias:\n");

        System.out.println("  1️⃣ DADOS INTRÍNSECOS (compartilhados):");
        System.out.println("     • Tipo de árvore (Carvalho, Pinheiro, Bétula)");
        System.out.println("     • Cor, textura, som");
        System.out.println("     • Comportamentos imutáveis");
        System.out.println("     ➜ Podem ser compartilhados entre múltiplas instâncias\n");

        System.out.println("  2️⃣ DADOS EXTRÍNSECOS (únicos por instância):");
        System.out.println("     • Posição X, Y");
        System.out.println("     • ID da árvore");
        System.out.println("     • Estado (viva/morta)");
        System.out.println("     ➜ Armazenados separadamente em cada objeto\n");

        System.out.println("💡 COMO FUNCIONA NO EXEMPLO:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("✓ TreeType = Flyweight (dados intrínsecos)");
        System.out.println("✓ Tree = Objeto concreto (dados extrínsecos)");
        System.out.println("✓ TreeTypeFactory = Factory para gerenciar Flyweights");
        System.out.println("✓ Forest = Coleção de árvores\n");

        System.out.println("📊 BENEFÍCIOS DEMONSTRADOS:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("✓ Economiza memória ao compartilhar dados");
        System.out.println("✓ Múltiplos objetos reutilizam o mesmo Flyweight");
        System.out.println("✓ Reduz consumo de RAM significativamente");
        System.out.println("✓ Melhora performance com muitos objetos similares");
        System.out.println("✓ Factory gerencia cache automaticamente\n");

        System.out.println("⚠️ TRADE-OFFS:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("✗ Complexidade aumenta (separação de dados)");
        System.out.println("✗ Necessário de uma Factory");
        System.out.println("✗ Dados intrínsecos devem ser imutáveis\n");

        System.out.println("🔍 COMPARAÇÃO DE USO DE MEMÓRIA:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("SEM Flyweight (7 árvores):");
        System.out.println("  → 7 TreeTypes diferentes em memória");
        System.out.println("  → Dados duplicados (nome, cor, textura, som)\n");

        System.out.println("COM Flyweight (7 árvores, 3 tipos):");
        System.out.println("  → Apenas 3 TreeTypes em memória");
        System.out.println("  → Compartilhamento de dados");
        System.out.println("  → 7 Tree objects com apenas (x, y, id)\n");

        System.out.println("🏆 CASOS DE USO REAIS:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("✓ Editor de texto (caracteres compartilham fontes)");
        System.out.println("✓ Jogos (partículas, sprites, texturas)");
        System.out.println("✓ Navegadores web (strings, eventos, estilos)");
        System.out.println("✓ Banco de dados (caching de registros)");
        System.out.println("✓ Sistemas de cache distribuído\n");

        System.out.println("🎮 EXEMPLO PRÁTICO DESTE PROJETO:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("Plantamos " + floresta.getTotalArvores() + " árvores no total.");
        System.out.println("Usamos apenas " + TreeTypeFactory.getTotalTreeTypesEmCache() +
                           " tipos diferentes (Flyweights).");
        System.out.println("Economia: Evitamos duplicar propriedades " +
                           TreeTypeFactory.getTotalTreeTypesEmCache() + " vezes!\n");

        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║              FIM DA DEMONSTRAÇÃO                   ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");
    }
}

