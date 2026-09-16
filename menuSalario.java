import java.util.Scanner;

public class menuSalario {


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int contador = 0;          // cuántos salarios se han registrado
        double acumulador = 0;     // suma de todos los salarios
        double mayor = 0;          // salario más alto
        double menor = 0;          // salario más bajo
        int opcion;

        do {
            System.out.println();
            System.out.println("===== SISTEMA DE SALARIOS =====");
            System.out.println("1. Registrar salarios");
            System.out.println("2. Mostrar resumen");
            System.out.println("3. Comparar un salario con el promedio");
            System.out.println("4. Reiniciar informacion");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println();
                    System.out.println("Ingrese los salarios uno por uno.");
                    System.out.println("Para terminar escriba un valor negativo.");

                    double salario;
                    int numero = 1;

                    System.out.print("Salario " + numero + ": ");
                    salario = teclado.nextDouble();

                    while (salario >= 0) {
                        if (contador == 0) {
                            mayor = salario;
                            menor = salario;
                        } else {
                            if (salario > mayor) {
                                mayor = salario;
                            }
                            if (salario < menor) {
                                menor = salario;
                            }
                        }

                        acumulador = acumulador + salario;
                        contador = contador + 1;
                        numero = numero + 1;

                        System.out.print("Salario " + numero + ": ");
                        salario = teclado.nextDouble();
                    }

                    System.out.println("Registro terminado. Salarios ingresados: " + contador);
                    break;

                case 2:
                    System.out.println();
                    if (contador == 0) {
                        System.out.println("Todavia no hay salarios registrados.");
                    } else {
                        double promedio = acumulador / contador;
                        System.out.println("----- RESUMEN -----");
                        System.out.println("Cantidad de salarios : " + contador);
                        System.out.printf("Suma total           : %.2f%n", acumulador);
                        System.out.printf("Promedio             : %.2f%n", promedio);
                        System.out.printf("Salario mayor        : %.2f%n", mayor);
                        System.out.printf("Salario menor        : %.2f%n", menor);
                    }
                    break;

                case 3:
                    System.out.println();
                    if (contador == 0) {
                        System.out.println("No se puede comparar: no hay salarios registrados.");
                    } else {
                        double promedio = acumulador / contador;
                        System.out.print("Escriba el salario a comparar: ");
                        double consulta = teclado.nextDouble();

                        System.out.printf("Promedio actual: %.2f%n", promedio);

                        if (consulta > promedio) {
                            System.out.println("El salario esta POR ENCIMA del promedio.");
                        } else if (consulta < promedio) {
                            System.out.println("El salario esta POR DEBAJO del promedio.");
                        } else {
                            System.out.println("El salario es IGUAL al promedio.");
                        }
                    }
                    break;

                case 4:
                    contador = 0;
                    acumulador = 0;
                    mayor = 0;
                    menor = 0;
                    System.out.println();
                    System.out.println("La informacion fue reiniciada.");
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println();
                    System.out.println("Opcion no valida, intente de nuevo.");
                    break;
            }

        } while (opcion != 0);

        teclado.close();
    }
}