// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Controlador c = new Controlador();
        c.generarCuentasCorrientes();
        c.generarCuentasAhorro();
        c.menu();
        /*
        System.out.println("\n-----------------------------Cuentas Corrientes---------------------------\n");
        c.generarCuentasCorrientes();
        c.mostrarCuentasCorrientes();
        System.out.println("\nPaso año\n");
        c.pasarYear(2);
        c.mostrarCuentasCorrientes();
        System.out.println("\nIngreso en 2 y retiro en 1\n");
        c.ingresarCC(2,500.01);
        c.retirarCC(1,200.15);
        c.mostrarCuentasCorrientes();

        System.out.println("\n----------------------------------Cuentas Ahorro---------------------------\n");
        c.generarCuentasAhorro();
        c.mostrarCuentasAhorro();
        System.out.println("\nretiro pasta de la 2 y añado pasta a la 1\n");
        c.retirarCA(2,2000);
        c.ingresarCA(1,1200.30);
        c.retirarCA(3,10000000);
        c.mostrarCuentasAhorro();
        */

    }
}