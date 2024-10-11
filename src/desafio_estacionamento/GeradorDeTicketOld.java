package desafio_estacionamento;

public class GeradorDeTicketOld {
    private int numeroDoTicket;
    private final double valorDoTicket;
    private boolean estaPago;
    private double receitaTotal;

    public GeradorDeTicketOld(double valorDoTicket) {
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

        maquina.emitirTicket();
        maquina.pagarTicket(15.0);
        maquina.verificarSaldo();

        maquina.emitirTicket();
        maquina.pagarTicket(5.0);
        maquina.verificarSaldo();
    }
}