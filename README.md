# 🌳 Padrão Flyweight - Sistema de Floresta

Um projeto educacional em Java que demonstra o padrão de projeto **Structural Design Pattern - Flyweight** através de um sistema prático de gerenciamento de floresta com múltiplas árvores.

## 📚 Sobre o Padrão Flyweight

O padrão Flyweight é um padrão estrutural que permite compartilhar dados comuns entre múltiplos objetos para economizar memória. A ideia central é separar os dados em duas categorias:

- **Dados Intrínsecos**: Dados imutáveis que podem ser compartilhados entre múltiplos objetos
- **Dados Extrínsecos**: Dados únicos por instância que são armazenados separadamente

### Quando Usar?
- Quando você tem muitos objetos similares consumindo muita memória
- Quando os dados imutáveis podem ser compartilhados
- Para otimizar performance em aplicações com alta demanda de memória
- Em editores de texto, jogos, navegadores web

## 🏗️ Arquitetura do Projeto

### Componentes Principais

```
┌─────────────────┐
│  MainFlyweight  │ (Aplicação Principal)
└────────┬────────┘
         │
    ┌────┴────┐
    ▼         ▼
 Forest   TreeTypeFactory (Factory Pattern)
    │         │
    │    ┌────┴──────┐
    │    ▼           ▼
    │  TreeType  Cache (HashMap)
    │ (Flyweight) ← Dados Intrínsecos Compartilhados
    │
    ▼
   Tree (Dados Extrínsecos)
   - ID
   - X, Y
   - Status
```

### Classes do Projeto

| Classe | Responsabilidade |
|--------|-----------------|
| **TreeType** | Flyweight com dados intrínsecos (nome, cor, textura, som) |
| **Tree** | Objeto concreto com dados extrínsecos (x, y, id, status) |
| **TreeTypeFactory** | Factory que gerencia cache de Flyweights |
| **Forest** | Gerenciador da coleção de árvores |
| **MainFlyweight** | Aplicação principal com demonstração |

## 💡 Como Funciona

### Sem Flyweight
```java
// Criar 7 árvores = 7 cópias de dados (nome, cor, textura, som)
Tree arvore1 = new Tree(10, 20, new TreeType("Carvalho", "Marrom", "Rugosa", "..."));
Tree arvore2 = new Tree(30, 40, new TreeType("Carvalho", "Marrom", "Rugosa", "...")); // Duplicado!
Tree arvore3 = new Tree(50, 60, new TreeType("Carvalho", "Marrom", "Rugosa", "...")); // Duplicado!
// ... dados duplicados em memória
```

**Resultado**: Alto consumo de memória com dados duplicados

### Com Flyweight
```java
// Criar 7 árvores = 3 TreeTypes compartilhados + 7 posições
TreeType carvalho = TreeTypeFactory.getTreeType("Carvalho", "Marrom", "Rugosa", "...");
Tree arvore1 = new Tree(10, 20, carvalho); // Reutiliza
Tree arvore2 = new Tree(30, 40, carvalho); // Reutiliza (não cria novo)
Tree arvore3 = new Tree(50, 60, carvalho); // Reutiliza (não cria novo)
// ... dados compartilhados
```

**Resultado**: Economia significativa de memória

## 🎯 Funcionalidades Demonstradas

### 1. Plantio de Árvores
```java
floresta.plantarArvore("Carvalho", "Marrom", "Rugosa", "Sussuros suaves", 10, 20);
```
- Factory verifica se TreeType já existe
- Se sim: reutiliza (✓ Reutilizando TreeType)
- Se não: cria novo (✓ Criando novo TreeType)

### 2. Operações em Lote
- `desenharFlorestA()` - Renderiza todas as árvores
- `crescerTodas()` - Faz todas crescerem
- `fazerSonsFlorestA()` - Emite sons da floresta

### 3. Gerenciamento de Estado
- `removerArvore(id)` - Remove árvore (marca como morta)
- `exibirStatisticas()` - Mostra dados da floresta
- `exibirDetalhes()` - Lista todas as árvores

### 4. Cache de Flyweights
```java
TreeTypeFactory.exibirTreeTypesEmCache(); // Mostra TreeTypes em cache
```

## 🚀 Como Executar

### Pré-requisitos
- JDK 8 ou superior
- Nenhuma dependência externa

### Passos

1. **Navegue até a pasta src:**
```bash
cd src
```

2. **Compile todos os arquivos:**
```bash
javac *.java
```

3. **Execute a aplicação:**
```bash
java MainFlyweight
```

## 📊 Fluxo de Execução

```
PADRÃO FLYWEIGHT - SISTEMA DE FLORESTA
    ↓
FASE 1: Plantando Árvores
    ├─ Plantando 3 Carvalhos
    │  ├─ ✓ Criando novo TreeType: Carvalho
    │  └─ ✓ Reutilizando TreeType: Carvalho (2 vezes)
    ├─ Plantando 2 Pinheiros
    │  ├─ ✓ Criando novo TreeType: Pinheiro
    │  └─ ✓ Reutilizando TreeType: Pinheiro
    ├─ Plantando 2 mais Carvalhos
    │  └─ ✓ Reutilizando TreeType: Carvalho (2 vezes)
    └─ Plantando 2 Bétulas
       ├─ ✓ Criando novo TreeType: Bétula
       └─ ✓ Reutilizando TreeType: Bétula
    ↓
📦 CACHE: 3 TreeTypes (Carvalho, Pinheiro, Bétula)
    ↓
📊 ESTATÍSTICAS: 7 árvores, 3 tipos únicos
    ↓
🎨 DESENHANDO FLORESTA
    ↓
🌱 FAZENDO CRESCER
    ↓
🔊 SONS DA FLORESTA
    ↓
💀 REMOVENDO ÁRVORES (3 árvores morrem)
    ↓
📊 ESTATÍSTICAS ATUALIZADAS
    ↓
📋 DETALHES COMPLETOS
    ↓
📌 EXPLICAÇÃO DO PADRÃO
```

## 🎓 Conceitos Explicados

### 1. Dados Intrínsecos (Compartilhados)
```
TreeType - Imutável e compartilhado
├─ nome: String (ex: "Carvalho")
├─ cor: String (ex: "Marrom")
├─ textura: String (ex: "Rugosa")
└─ som: String (ex: "Sussuros suaves")
```

### 2. Dados Extrínsecos (Únicos)
```
Tree - Único por instância
├─ x: int (posição X)
├─ y: int (posição Y)
├─ id: int (identificador)
├─ viva: boolean (estado)
└─ type: TreeType (referência ao Flyweight)
```

### 3. Factory Pattern
```
TreeTypeFactory
├─ Cache (Map<String, TreeType>)
├─ getTreeType() → verifica cache
├─ Se existe: retorna do cache
└─ Se não: cria novo e cacheia
```

## 📈 Benefícios Demonstrados

| Benefício | Descrição |
|-----------|-----------|
| **Economia de Memória** | Compartilha dados intrínsecos |
| **Performance** | Menos alocações de memória |
| **Escalabilidade** | Suporta milhões de objetos |
| **Cache Automático** | Factory gerencia reutilização |
| **Imutabilidade** | Dados compartilhados seguros |
| **Transparência** | Cliente não sabe da otimização |

## ⚠️ Trade-offs

| Desvantagem | Descrição |
|------------|-----------|
| **Complexidade** | Separação de dados aumenta complexidade |
| **Sincronização** | Dados compartilhados precisam ser thread-safe |
| **Imutabilidade** | Flyweights devem ser imutáveis |
| **Overhead Inicial** | Factory precisa gerenciar cache |

## 🔍 Comparação de Uso de Memória

### Cenário: 1.000.000 de árvores

**SEM Flyweight:**
```
1.000.000 Trees × (nome + cor + textura + som)
= ~1.000.000 × 100 bytes = ~100 MB
```

**COM Flyweight:**
```
1.000.000 Trees × (x + y + id) + 3 TreeTypes × (nome + cor + textura + som)
= 1.000.000 × 12 bytes + 3 × 100 bytes = ~12 MB + 0.3 KB
= ~99% de economia de memória!
```

## 🏆 Casos de Uso Reais

### 1. Editores de Texto
- Caracteres compartilham mesmo estilo/fonte
- Milhões de caracteres com poucos estilos

### 2. Jogos
- Partículas com mesma textura compartilham dados
- Sprites reutilizam imagens

### 3. Navegadores Web
- URLs armazenadas uma vez
- Strings compartilhadas entre páginas

### 4. Sistemas de Banco de Dados
- Registros similares compartilham estrutura
- Caching de objetos frequentes

### 5. Sistemas de Cache Distribuído
- Redis usa Flyweight para chaves similares
- Memcached otimiza armazenamento

## 🔄 Padrões Relacionados

| Padrão | Relação |
|--------|---------|
| **Factory** | Factory Pattern para criar/cachear Flyweights |
| **Singleton** | TreeTypeFactory usa cache estático |
| **Composite** | Forest é composto de Trees |
| **Decorator** | Pode adicionar comportamentos aos Flyweights |
| **Strategy** | Diferentes estratégias de compartilhamento |

## 📝 Exemplo de Saída

```
╔════════════════════════════════════════════════════╗
║      PADRÃO FLYWEIGHT - SISTEMA DE FLORESTA        ║
╚════════════════════════════════════════════════════╝

>>> FASE 1: Plantando Árvores na Floresta

--- Plantando Carvalhos ---
✓ Criando novo TreeType (Flyweight): Carvalho
🌱 Árvore #0 plantada em (10, 20)

✓ Reutilizando TreeType (Flyweight): Carvalho
🌱 Árvore #1 plantada em (30, 40)

📦 TreeTypes em Cache (Flyweights):
Total: 3
  1. TreeType{nome='Carvalho', cor='Marrom', textura='Rugosa'}
  2. TreeType{nome='Pinheiro', cor='Verde Escuro', textura='Lisa'}
  3. TreeType{nome='Bétula', cor='Branco', textura='Suave'}

📊 ESTATÍSTICAS DA FLORESTA:
Total de árvores plantadas: 7
Árvores vivas: 7
Árvores mortas: 0
Tipos de árvores únicos (Flyweights): 3
```

## 👨‍💻 Tecnologias Utilizadas

- **Java 8+** - Linguagem de programação
- **HashMap** - Para cache de Flyweights
- **ArrayList** - Para gerenciar coleção de árvores
- **POO** - Programação Orientada a Objetos
- **Design Patterns** - Padrões de Projeto

## 📚 Referências

- **Gang of Four (GoF)** - Design Patterns: Elements of Reusable Object-Oriented Software
- **Refactoring.Guru** - Design Patterns
- **SourceMaking** - Design Patterns
- **Java Design Patterns** - Tutorials Point

## 🎯 Objetivos de Aprendizado

Após estudar este projeto, você entenderá:

✅ O que é o padrão Flyweight e quando usá-lo  
✅ Como separar dados intrínsecos e extrínsecos  
✅ Implementação de Factory Pattern para cache  
✅ Otimização de memória em aplicações Java  
✅ Trade-offs entre performance e complexidade  
✅ Casos de uso reais do padrão  

## 🤝 Contribuições

Este é um projeto educacional. Você pode:
- Estudar o código
- Criar variações
- Adicionar novos tipos de árvores
- Implementar novos subsistemas
- Melhorar a documentação

## 📄 Licença

Disponível como material educacional.

---

**Desenvolvido como material educacional para compreender o padrão Flyweight** 🌲🌲🌲

