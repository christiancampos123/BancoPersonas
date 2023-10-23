public class CuentaCorriente extends Cuenta{
    private double comision;
    private boolean activa;

    public CuentaCorriente(String nombre, int dni, int numCuenta, double saldo, double comision, boolean activa) {
        super(nombre, dni, numCuenta, saldo);
        this.comision = comision;
        this.activa = activa;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void pasarYear(){
        double saldo = this.getSaldo();
        double newSaldo = saldo * comision + saldo;
        this.setSaldo(newSaldo);
        System.out.println("se ha calculado la comision, y es de +" + (saldo*comision)+"€");
        System.out.println("Nuevo saldo de: "+ this.getNombre()+ ": " + newSaldo);
    }

}
