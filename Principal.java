import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("--- Configuração Inicial do Shopping ---");
        System.out.print("Nome do Shopping: ");
        String nomeShopping = teclado.nextLine();
        
        Endereco endShopping = new Endereco("Av. Unisinos", "São Leopoldo", "RS", "Brasil", "93022-750", "950", "Campus");
        Shopping meuShopping = new Shopping(nomeShopping, endShopping, 100); 

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n---------- GESTÃO DO SHOPPING: " + meuShopping.getNome() + " ----------");
            System.out.println("(1) Criar uma Loja");
            System.out.println("(2) Criar um Produto");
            System.out.println("(3) Adicionar Loja ao Shopping (Herança)");
            System.out.println("(4) Ver Quantidade de Lojas por Tipo");
            System.out.println("(5) Ver Loja de Informática com Seguro Mais Caro");
            System.out.println("(6) Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = teclado.nextInt();
            teclado.nextLine(); 

            if (opcao == 1) {
                Loja loja = criarLojaGenerica(teclado);
                System.out.println("\nLoja criada com sucesso!\n" + loja);

            } else if (opcao == 2) {
                Produto produto = criarProduto(teclado);
                
                Data dataRef = new Data(20, 10, 2026);
                if (produto.estaVencido(dataRef)) {
                    System.out.println("PRODUTO VENCIDO");
                } else {
                    System.out.println("PRODUTO NÃO VENCIDO");
                }
                System.out.println(produto);

            } else if (opcao == 3) {
                System.out.println("Tipo de Loja: (1) Alimentação (2) Bijuteria (3) Cosmético (4) Informática (5) Vestuário");
                int tipo = teclado.nextInt();
                teclado.nextLine();
                
                Loja novaLoja = cadastrarLojaEspecifica(tipo, teclado);
                if (meuShopping.insereLoja(novaLoja)) {
                    System.out.println("Loja adicionada ao shopping com sucesso!");
                } else {
                    System.out.println("Erro: Shopping lotado!");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o tipo a consultar (Alimentação (1), Bijuteria (2), Cosmético (3), Informática (4) ou Vestuário (5)): ");
                int tipoBusca = teclado.nextInt();
                int qtd = meuShopping.quantidadeLojasPorTipo(tipoBusca);
                System.out.println("Quantidade encontrada: " + (qtd == -1 ? "Tipo inválido" : qtd));

            } else if (opcao == 5) {
                Informatica info = meuShopping.lojaSeguroMaisCaro();
                if (info != null) {
                    System.out.println("Loja de informática com seguro mais caro: " + info);
                } else {
                    System.out.println("Nenhuma loja de informática cadastrada.");
                }

            } else if (opcao != 6) {
                System.out.println("Opção inválida.");
            }
        }
        teclado.close();
    }


    private static Loja criarLojaGenerica(Scanner teclado) {
        System.out.print("Nome da Loja: ");
        String nome = teclado.nextLine();
        System.out.print("Qtd Funcionários: ");
        int qtdF = teclado.nextInt();
        System.out.print("Salário Base: ");
        double sal = teclado.nextDouble();
        teclado.nextLine();
        
        Endereco end = new Endereco("Rua A", "Cidade B", "RS", "Brasil", "000", "10", "Centro");
        Data fund = new Data(1, 1, 2020);
        return new Loja(nome, qtdF, sal, end, fund, 10);
    }

    private static Produto criarProduto(Scanner teclado) {
        System.out.print("Nome do Produto: ");
        String nome = teclado.nextLine();
        System.out.print("Preço: ");
        double preco = teclado.nextDouble();
        System.out.print("Validade (dia mês ano): ");
        Data val = new Data(teclado.nextInt(), teclado.nextInt(), teclado.nextInt());
        return new Produto(nome, preco, val);
    }

    private static Loja cadastrarLojaEspecifica(int tipo, Scanner teclado) {
        System.out.print("Nome da Loja: ");
        String nome = teclado.nextLine();
        System.out.print("Qtd Funcionários: ");
        int qtdF = teclado.nextInt();
        System.out.print("Salário Base: ");
        double sal = teclado.nextDouble();
        teclado.nextLine();

        Endereco end = new Endereco("Rua Teste", "PoA", "RS", "Brasil", "900", "1", "S/C");
        Data fund = new Data(10, 5, 2022);

        switch (tipo) {
            case 1: 
                return new Alimentacao(nome, qtdF, sal, end, fund, new Data(1, 1, 2024));
            case 2: 
                return new Bijuteria(nome, qtdF, sal, end, fund, 5000.0, 20);
            case 3: 
                return new Cosmetico(nome, qtdF, sal, end, fund, 15.5);
            case 4: 
                System.out.print("Valor do Seguro Eletrônicos: ");
                double seguro = teclado.nextDouble();
                return new Informatica(nome, qtdF, sal, end, fund, seguro, 50);
            case 5: 
                return new Vestuario(nome, qtdF, sal, end, fund, true, 30);
            default: 
                return new Loja(nome, qtdF, sal, end, fund, 10);
        }
    }
}