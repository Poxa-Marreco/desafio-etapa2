package desafio_ru;

import java.util.*;

record Alimento(String nome) {
}

class Refeicao {
    private final Alimento salada;
    private final Alimento pratoPrincipal;
    private final Alimento acompanhamento;

    public Refeicao(Alimento salada, Alimento pratoPrincipal, Alimento acompanhamento) {
        this.salada = salada;
        this.pratoPrincipal = pratoPrincipal;
        this.acompanhamento = acompanhamento;
    }

    public String getNome() {
        return salada.nome() + ", " + pratoPrincipal.nome() + ", " + acompanhamento.nome();
    }
}

class Menu {
    private final String dia;
    private final String turno;
    private final Refeicao refeicao;

    public Menu(String dia, String turno, Refeicao refeicao) {
        this.dia = dia;
        this.turno = turno;
        this.refeicao = refeicao;
    }

    public String getMenu() {
        return dia + " - " + turno + ": " + refeicao.getNome();
    }
}

public class CardapioSemanal {
    private final List<Alimento> aliments = new ArrayList<>();
    private final List<Refeicao> refeicoes = new ArrayList<>();
    private final List<Menu> menus = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardapioSemanal cardapio = new CardapioSemanal();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Alimento");
            System.out.println("2. Cadastrar Refeição");
            System.out.println("3. Cadastrar Menu");
            System.out.println("4. Imprimir Cardápio Semanal");
            System.out.println("5. Sair");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpar nova linha de caracter

            switch (option) {
                case 1:
                    cadastrarAlimento(scanner, cardapio);
                    break;
                case 2:
                    cadastrarRefeicao(scanner, cardapio);
                    break;
                case 3:
                    cadastrarMenu(scanner, cardapio);
                    break;
                case 4:
                    cardapio.imprimirCardapio();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void imprimirCardapio() {
        for (Menu menu : menus) {
            System.out.println(menu.getMenu());
        }
    }

    private static void cadastrarAlimento(Scanner scanner, CardapioSemanal cardapio) {
        System.out.print("Digite o nome do alimento: ");
        String nome = scanner.nextLine();
        Alimento alimento = new Alimento(nome);
        cardapio.aliments.add(alimento);
        System.out.println("Alimento cadastrado com sucesso!");
    }

    private static void cadastrarRefeicao(Scanner scanner, CardapioSemanal cardapio) {
        System.out.print("Digite o nome da salada: ");
        String saladaNome = scanner.nextLine();
        Alimento salada = new Alimento(saladaNome);

        System.out.print("Digite o nome do prato principal: ");
        String pratoPrincipalNome = scanner.nextLine();
        Alimento pratoPrincipal = new Alimento(pratoPrincipalNome);

        System.out.print("Digite o nome do acompanhamento: ");
        String acompanhamentoNome = scanner.nextLine();
        Alimento acompanhamento = new Alimento(acompanhamentoNome);

        Refeicao refeicao = new Refeicao(salada, pratoPrincipal, acompanhamento);
        cardapio.refeicoes.add(refeicao);
        System.out.println("Refeição cadastrada com sucesso!");
    }

    private static void cadastrarMenu(Scanner scanner, CardapioSemanal cardapio) {
        System.out.print("Digite o dia (ex: SEGUNDA, TERCA, QUARTA, etc.): ");
        String dia = scanner.nextLine().toUpperCase();

        System.out.print("Digite o turno (MANHA, TARDE, NOITE): ");
        String turno = scanner.nextLine().toUpperCase();

        System.out.print("Digite o nome da refeição: ");
        String refeicaoNome = scanner.nextLine();

        Refeicao refeicao = cardapio.getRefeicaoByName(refeicaoNome);

        if (refeicao == null) {
            System.out.println("Refeição não encontrada. Tente novamente.");
            return;
        }

        Menu menu = new Menu(dia, turno, refeicao);
        cardapio.menus.add(menu);
        System.out.println("Menu cadastrado com sucesso!");
    }

    private Refeicao getRefeicaoByName(String nome) {
        for (Refeicao refeicao : refeicoes) {
            if (refeicao.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return refeicao;
            }
        }
        return null;
    }
}
