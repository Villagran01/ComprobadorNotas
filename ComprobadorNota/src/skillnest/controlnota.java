package skillnest;

import java.util.ArrayList;
import java.util.Scanner;

public class controlnota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> estudiantes = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();




    }
    /*
    *Aqui se muestran las notas de los estudiantes
    * @param estudiantes
    * @param notas
    * @return void
     */


    public static void calcularPromedio(ArrayList<Double> notas){
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for(int i = 0; i < notas.size(); i++){
            suma += notas.get(i);
        }
        return suma / notas.size();

    }
    public static void mostrarNotas(ArrayList<String> estudiantes, ArrayList<Double> notas){
        for(int i = 0; i < estudiantes.size(); i++){
            System.out.println("El estudiante " + estudiantes.get(i) + " tiene una nota de " + notas.get(i));
        }
    }

}