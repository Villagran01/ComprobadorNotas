package skillnest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class controlnota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el Nombre del estudiantes: ");
        String nombre = sc.nextLine().trim();

        List<Double> notas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese la nota del estudiante: ");
            double nota = sc.nextDouble();
            notas.add(nota);
        }
        double promedio = calcularPromedio(notas);
        String estado = determinarEstado(promedio, 60);
        System.out.printf("Estudiante: %s Promedio: %.2f Estado: %s%n",
                nombre, promedio, estado);





    }
    /**
     * Calcula el promedio aritmético de una lista de calificaciones.
     *
     * @param notas lista de calificaciones (no nula ni vacía)
     * @return promedio en el rango 0–100
     * @throws IllegalArgumentException si la lista es nula o está vacía
     */
    public static double calcularPromedio(List<Double> notas){
        if (notas.isEmpty() || notas == null ) {
            throw new IllegalArgumentException("La lista de notas no puede ser nula o vacia");
        }
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();

    }

    /**
     * Determina el estado del estudiante según su promedio y la mínima aprobatoria.
     *
     * @param promedio           promedio del estudiante
     * @param minimaAprobatoria  nota mínima para aprobar
     * @return "Aprobado" si promedio & ; mínima; de lo contrario, "Reprobado"
     */
    public static String determinarEstado(double promedio, double minimaAprobatoria) {
        return promedio >= minimaAprobatoria ? "Aprobado" : "Reprobado";
    }

    /**
     * Lee una calificación desde consola con validación.
     * Acepta coma o punto como separador decimal y exige rango 0–100.
     *
     * @param sc     scanner a usar
     * @param numero número de calificación (1..3) para la indicación
     * @return calificación válida entre 0 y 100
     */
    private static double leerNota(Scanner sc, int numero) {
        while (true) {
            System.out.printf("Ingrese la calificación %d (0–100, admite decimales): ", numero);
            String entrada = sc.nextLine().trim().replace(',', '.');

            try {
                double nota = Double.parseDouble(entrada);
                if (nota < 0 || nota > 100) {
                    System.out.println("⚠️  La calificación debe estar entre 0 y 100.");
                } else {
                    return nota;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Entrada inválida. Intente nuevamente (ej.: 73.5).");
            }
        }
    }
}