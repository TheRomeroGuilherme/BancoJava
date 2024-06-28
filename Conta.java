public class Conta {
    protected double saldo;
    protected double limite;
    protected String tipo;

    public Conta(double saldo, double limite, String tipo) {
        this.saldo = saldo;
        this.limite = limite;
        this.tipo = tipo;
    }

    // Getters e Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
