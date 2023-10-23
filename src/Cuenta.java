public class Cuenta extends Persona{
    private int numCuenta;
    private double saldo;


    public Cuenta(String nombre, int dni, int numCuenta, double saldo) {
        super(nombre, dni);
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {

        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void retirarSaldo(double retirado){
        double saldo = this.getSaldo();
        double newSaldo = saldo - retirado;
        this.setSaldo(newSaldo);
    }
    public void ingresarSaldo(double ingresado){
        double saldo = this.getSaldo();
        double newSaldo = saldo + ingresado;
        this.setSaldo(newSaldo);
    }

}
