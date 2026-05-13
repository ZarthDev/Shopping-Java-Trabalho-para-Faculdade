# Gerenciador de Lojas - Shopping Center
Este projeto foi desenvolvido como parte do **Desafio de Laboratório I

(Semestre 2026/1)**. O objetivo é criar um sistema robusto de gerenciamento
para um Shopping Center, aplicando conceitos fundamentais de **Programação
Orientada a Objetos (POO)** em Java.
## Descrição do Projeto
O sistema permite a gestão completa de um Shopping Center, desde a
infraestrutura básica (endereços e datas) até a lógica complexa de estoque
de produtos e categorização de lojas. O projeto é dividido em 4 etapas
evolutivas:
1. **Criação de Classes Base:** Implementação de `Loja`, `Produto`,
`Endereco` e `Data` com validações específicas (como anos bissextos).
2. **Associação e Lógica de Negócio:** Interligação entre as classes e
implementação de métodos de verificação (ex: validade de produtos).
3. **Herança e Polimorfismo:** Especialização de lojas em categorias:

`Alimentacao`, `Bijuteria`, `Cosmetico`, `Informatica` e `Vestuario`.
4. **Estruturas de Dados (Arrays):** Gerenciamento de múltiplos produtos
por loja e múltiplas lojas por shopping, incluindo algoritmos de busca e
filtragem.

## Funcionalidades Principais
- **Validação de Datas:** Sistema inteligente que verifica dias, meses e
anos bissextos, corrigindo entradas inválidas para um padrão seguro.

- **Gestão de Estoque:** Cada loja possui seu próprio array de produtos
com métodos para inserção, remoção e listagem.

- **Análise Financeira:** Cálculo automatizado de gastos com salários
baseados na quantidade de funcionários.

- **Busca Especializada:** Localização da loja de informática com o
seguro de eletrônicos mais caro dentro do shopping.

- **Relatórios por Categoria:** Contagem dinâmica de lojas por segmento
(Vestuário, Alimentação, etc.) utilizando polimorfismo.

## Tecnologias Utilizadas
- **Linguagem:** Java
- **Paradigma:** Orientação a Objetos
- **Ferramentas:** JDK, Terminal/CLI para compilação (`javac`) e execução
(`java`).

## Estrutura do Repositório
- `Principal.java`: Ponto de entrada do sistema com menu interativo.
- `Shopping.java`: Classe principal de agregação e lógica de busca.
- `Loja.java`: Classe base para todas as unidades comerciais.
- `Subclasses (Vestuario, Informatica, etc.)`: Implementações específicas
com atributos únicos.
- `Produto.java`, `Endereco.java`, `Data.java`: Classes de suporte para
dados estruturados.

## Como Executar
1. Clone o repositório.
2. Compile todos os arquivos:
```bash
javac *.java
```
3. Execute a classe principal:
```bash
java Principal

```

---
*Projeto acadêmico desenvolvido para a disciplina de Laboratório I.*
