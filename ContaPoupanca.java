public class ContaPoupanca extends Conta {
    private double rendimentoAutomatico;

    public ContaPoupanca(double saldo, double limite, double rendimentoAutomatico) {
        super(saldo, limite, "Conta Poupança");
        this.rendimentoAutomatico = rendimentoAutomatico;
    }

    // Getter e Setter
    public double getRendimentoAutomatico() {
        return rendimentoAutomatico;
    }

    public void setRendimentoAutomatico(double rendimentoAutomatico) {
        this.rendimentoAutomatico = rendimentoAutomatico;
    }
}
