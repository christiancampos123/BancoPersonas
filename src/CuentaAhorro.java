public class CuentaAhorro extends Cuenta{
    public CuentaAhorro(String nombre, int dni, int numCuenta, double saldo) {
        super(nombre, dni, numCuenta, saldo);
    }
    @Override
    public void retirarSaldo(double retirado){
        if(retirado > this.getSaldo()){
            System.out.println("Nanai, no hay tanta pasta, "+ this.getNombre());
            System.out.println("Recuerda que tu salde es de: "+ this.getSaldo());
        } else {
            double saldo = this.getSaldo();
            double newSaldo = saldo - retirado;
            this.setSaldo(newSaldo);
        }
    }
}
