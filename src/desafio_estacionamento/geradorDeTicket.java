package desafio_estacionamento;

import java.util.Scanner;

public class geradorDeTicket {
    private int numeroDoTicket;
    private final double valorDoTicket;
    private boolean estaPago;
    private double receitaTotal;

    public geradorDeTicket(double valorDoTicket) {
        this.valorDoTicket = valorDoTicket;
        this.numeroDoTicket = 1;
        this.estaPago = false;
        this.receitaTotal = 0.0;
    }

    public void emitirTicket() {
        System.out.println("Ticket emitido: #" + numeroDoTicket + " - Valor: " + valorDoTicket);
        numeroDoTicket++;
    }

    public void pagarTicket(double pagamento) {
        if (!estaPago) {
            if (pagamento >= valorDoTicket) {
                estaPago = true;
                receitaTotal += valorDoTicket;
                System.out.println("Ticket pago com sucesso!");
            } else {
                System.out.println("Pagamento insuficiente. Por favor, tente novamente.");
            }
        } else {
            System.out.println("Ticket já foi pago.");
        }
    }

    public void verificarSaldo() {
        System.out.println("Receita total: " + receitaTotal);
    }

    public static void main(String[] args) {
        geradorDeTicket maquina = new geradorDeTicket(10.0); // Inicialize com um valor fixo de ticket de 10.0
        Scanner scanner = new Scanner(System.in);



            while (true) {
                System.out.println("Opções:");
                System.out.println("1. Emitir ticket");
                System.out.println("2. Pagar ticket");
                System.out.println("3. Verificar saldo");
                System.out.println("4. Sair");



                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        maquina.emitirTicket();
                        break;
                    case 2:
                        System.out.print("Digite o valor do pagamento: ");
                        double pagamento = scanner.nextDouble();
                        maquina.pagarTicket(pagamento);
                        break;
                    case 3:
                        maquina.verificarSaldo();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }


        }
        } 
}
