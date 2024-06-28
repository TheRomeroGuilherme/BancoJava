public class ContaCorrente extends Conta {
    private double rendimentoCDB;

    public ContaCorrente(double saldo, double limite, double rendimentoCDB) {
        super(saldo, limite, "Conta Corrente");
        this.rendimentoCDB = rendimentoCDB;
    }

    // Getter e Setter
    public double getRendimentoCDB() {
        return rendimentoCDB;
    }

    public void setRendimentoCDB(double rendimentoCDB) {
        this.rendimentoCDB = rendimentoCDB;
    }
}
