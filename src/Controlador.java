import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
    public static ArrayList<CuentaCorriente> listaCC = new ArrayList<>();

    public void intro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine(); // Espera a que el usuario pulse Enter

        //System.out.println("Continuaste después de presionar Enter.");
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("|----------------------------------------------------|");
            System.out.println("|Menú de opciones:                                   |");
            System.out.println("|1. Opción 1 - Mostrar CC                            |");
            System.out.println("|2. Opción 2 - Mostrar CA                            |");
            System.out.println("|3. Opción 3 - Pasar Año a Cuenta Corriente          |");
            System.out.println("|4. Opción 4 - Ingresar Saldo a Cuenta Corriente     |");
            System.out.println("|5. Opción 5 - Retirar Saldo de Cuenta Corriente     |");
            System.out.println("|6. opción 6 - Ingresar Saldo a Cuenta Ahorro        |");
            System.out.println("|7. Opción 7 - Retirar Saldo a Cuenta Ahorro         |");
            System.out.println("|8. Opción 8 - Salir del Programa                    |");
            System.out.println("|Seleccione una opción (1-8):                        |");
            System.out.println("|----------------------------------------------------|\n");
            System.out.print("opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    mostrarCuentasCorrientes();
                    this.intro();
                }
                case 2 -> {
                    mostrarCuentasAhorro();
                    this.intro();
                }
                case 3 -> {
                    System.out.println("A que cuenta le pasamos un año?");
                    int i = scanner.nextInt();
                    if (i < listaCC.size() + 1 && i > 0) {
                        if (!listaCC.get(i - 1).isActiva()) {
                            System.out.println("No esta activa");
                            this.intro();
                            break;
                        }
                        pasarYear(i);
                        //System.out.println("Su nuevo saldo es de: "+ listaCC.get(i-1).getSaldo());
                    } else {
                        System.out.println("Esa cuenta no existe");
                    }
                    this.intro();
                }
                case 4 -> {
                    System.out.println("A que cuenta corriente le Ingresamos?");
                    int a = scanner.nextInt();
                    if (a < listaCC.size() + 1 && a > 0) {
                        if (!listaCC.get(a - 1).isActiva()) {
                            System.out.println("No esta activa");
                            this.intro();
                            break;
                        }
                        System.out.println("Cuanto?");
                        double b = scanner.nextDouble();
                        ingresarCC(a, b);
                        System.out.println("Se han ingresado " + b + "€ " + "a " + listaCC.get(a - 1).getNombre());
                        System.out.println("Su nuevo saldo es de: " + listaCC.get(a - 1).getSaldo());

                    } else {
                        System.out.println("Esa cuenta no existe");
                    }
                    this.intro();
                }
                case 5 -> {
                    System.out.println("A que cuenta Corriente le retiramos Saldo?");
                    int c = scanner.nextInt();
                    if (c < listaCC.size() + 1 && c > 0) {
                        if (!listaCC.get(c - 1).isActiva()) {
                            System.out.println("No esta activa");
                            this.intro();
                            break;
                        }
                        System.out.println("Cuanto?");
                        double d = scanner.nextDouble();
                        retirarCC(c, d);
                        System.out.println("Se han Retirado " + d + "€ " + "a " + listaCC.get(c - 1).getNombre());
                        System.out.println("Su nuevo saldo es de: " + listaCC.get(c - 1).getSaldo());
                    } else {
                        System.out.println("Esa cuenta no existe");
                    }
                    this.intro();
                }
                case 6 -> {
                    System.out.println("A que cuenta de Ahorro le ingresamos Saldo?");
                    int e = scanner.nextInt();
                    if (e < listaCC.size() + 1 && e > 0) {
                        System.out.println("Cuanto?");
                        double f = scanner.nextDouble();
                        ingresarCA(e, f);
                        System.out.println("Se han Retirado " + f + "€ " + "a " + listaCA.get(e - 1).getNombre());
                        System.out.println("Su nuevo saldo es de: " + listaCA.get(e - 1).getSaldo());
                    } else {
                        System.out.println("Esa cuenta no existe");
                    }
                    this.intro();
                }
                case 7 -> {
                    System.out.println("A que cuenta de Ahorro le retiramos Saldo?");
                    int g = scanner.nextInt();
                    if (g < listaCC.size() + 1 && g > 0) {
                        System.out.println("Cuanto?");
                        double h = scanner.nextDouble();
                        retirarCA(g, h);
                        if ((listaCA.get(g - 1).getSaldo()) > h) {
                            System.out.println("Se han Retirado " + h + "€ " + "a " + listaCA.get(g - 1).getNombre());
                            System.out.println("Su nuevo saldo es de: " + listaCA.get(g - 1).getSaldo());
                        }
                    } else {
                        System.out.println("Esa cuenta no existe");
                    }
                    this.intro();
                }
                case 8 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 8);
        scanner.close();
    }


    public void generarCuentasCorrientes(){
        CuentaCorriente cc1 = new CuentaCorriente("Chris",434, 123, 1000.95, 0.005,true);
        CuentaCorriente cc2 = new CuentaCorriente("Joan",435, 1234, 11234.91, 0.005,true);
        CuentaCorriente cc3 = new CuentaCorriente("Rafa",436, 12345, 153430.92, 0.005,false);

        listaCC.add(cc1);
        listaCC.add(cc2);
        listaCC.add(cc3);
        System.out.println();

    }

    public void mostrarCuentasCorrientes(){
        int num = 1;
        for (CuentaCorriente CC:listaCC) {
            System.out.println(num + "- "+ CC.getNombre() + " " + String.format("%.2f",CC.getSaldo())+ "\t| activa: " + CC.isActiva());
            num ++;
        }
    }


    public void pasarYear(int numero){
        listaCC.get(numero-1).pasarYear();
    }

    public void ingresarCC(int numero,double saldo){
        listaCC.get(numero-1).ingresarSaldo(saldo);
    }

    public void retirarCC(int numero, double saldo){
        listaCC.get(numero-1).retirarSaldo(saldo);
    }

    //------------------------------------ Cuentas Ahorro------------------------------------------
    public static ArrayList<CuentaAhorro> listaCA = new ArrayList<>();
    public void generarCuentasAhorro(){
        CuentaAhorro ca1 = new CuentaAhorro("Chris",434, 123, 300.95);
        CuentaAhorro ca2 = new CuentaAhorro("Joan",435, 1234, 1234.91);
        CuentaAhorro ca3 = new CuentaAhorro("Rafa",436, 12345, 15339.92);

        listaCA.add(ca1);
        listaCA.add(ca2);
        listaCA.add(ca3);
        System.out.println();

    }

    public void mostrarCuentasAhorro(){
        int num = 1;
        for (CuentaAhorro CA:listaCA) {
            System.out.println(num + "- "+ CA.getNombre() + " " + String.format("%.2f",CA.getSaldo()));
            num ++;
        }
    }

    public void ingresarCA(int numero,double saldo){
        listaCA.get(numero-1).ingresarSaldo(saldo);
    }

    public void retirarCA(int numero, double saldo){
        listaCA.get(numero-1).retirarSaldo(saldo);
    }

}
