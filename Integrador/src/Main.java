import Pronostico.Equipo;
import Pronostico.Partido;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int puntos = 0;

        Equipo equipo1 = new Equipo();
        equipo1.setNombre("Argentina");

        Equipo equipo2 = new Equipo();
        equipo2.setNombre("Arabia Saudita");

        Partido partido1 = new Partido();
        partido1.equipo1 = equipo1;
        partido1.equipo2 = equipo2;

        partido1.golesEquipo1 = 1;
        partido1.golesEquipo2 = 2;

        System.out.println("Inserte su resultado de el partido, usando una de las siguientes respuestas:");
        System.out.println("Argentina, Arabia Saudita o empate");
        String pronostico1 = scanner.nextLine();
        if (pronostico1.equals(partido1.resultado())){
            System.out.println("Perfecto acertaste mas 1 punto");
            puntos++;
        }else {
            System.out.println("incorrecto");
        }
        System.out.println("el partido termino: " + equipo1.nombre + " " + partido1.golesEquipo1 + "-" + partido1.golesEquipo2 + " " + equipo2.nombre);

        Equipo equipo3 = new Equipo();
        equipo3.setNombre("Polonia");

        Partido partido2 = new Partido();
        partido2.equipo1 = equipo1;
        partido2.equipo2 = equipo3;

        partido2.golesEquipo1 = 2;
        partido2.golesEquipo2 = 0;
        System.out.println("inserte su resultado para el siguiente partido: ");
        System.out.println("Argentina, Polonia o empate");

        String pronostico2 = scanner.nextLine();
        if (pronostico2.equals(partido2.resultado())){
            System.out.println("Perfecto acertaste mas 1 punto");
            puntos++;
        }else {
            System.out.println("incorrecto");
        }
        System.out.println("el partido termino: " + equipo1.nombre + " " + partido2.golesEquipo1 + "-" + partido2.golesEquipo2 + " " + equipo3.nombre);
        System.out.println("Su total de puntos sumados es de: " + puntos);

    }
}