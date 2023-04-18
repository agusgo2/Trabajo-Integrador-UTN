import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Resultado> resultados = leerArchivoResultados("C:\\Users\\agusg\\Desktop\\Trabajo-Integrador-UTN\\resultados2.csv");
        List<Pronostico> pronosticos = leerArchivoPronosticos("C:\\Users\\agusg\\Desktop\\Trabajo-Integrador-UTN\\pronosticos2.csv");
        List<Participante> participantes = calcularPuntajes(pronosticos, resultados);
        mostrarPuntajes(participantes);
    }

    private static List<Resultado> leerArchivoResultados(String rutaArchivo) {
        List<Resultado> resultados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String pais1 = campos[0];
                boolean ganoPais1 = "X".equals(campos[1]);
                boolean empate = "X".equals(campos[2]);
                boolean ganoPais2 = "X".equals(campos[3]);
                String pais2 = campos[4];
                Resultado resultado = new Resultado(pais1, pais2, ganoPais1, empate,ganoPais2);
                resultados.add(resultado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    private static List<Pronostico> leerArchivoPronosticos(String rutaArchivo) {
        List<Pronostico> pronosticos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nombre = campos[0];
                String pais1 = campos[1];
                boolean ganoPais1 = "X".equals(campos[2]);
                boolean empate = "X".equals(campos[3]);
                boolean ganoPais2 = "X".equals(campos[4]);
                String pais2 = campos[5];
                Pronostico pronostico = new Pronostico(nombre, pais1, pais2, ganoPais1, empate, ganoPais2);
                pronosticos.add(pronostico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pronosticos;
    }

    private static List<Participante> calcularPuntajes(List<Pronostico> pronosticos, List<Resultado> resultados) {
        Map<String, Participante> puntajes = new HashMap<>();
        for (Pronostico pronostico : pronosticos) {
            Resultado resultado = encontrarResultado(resultados, pronostico.getPais1(), pronostico.getPais2());
            if (resultado != null) {
                int puntaje = calcularPuntaje(pronostico, resultado);
                String nombre = pronostico.getNombre();
                Participante participante = puntajes.get(nombre);
                if (participante == null) {
                    participante = new Participante(nombre, puntaje);
                    puntajes.put(nombre, participante);
                } else {
                    participante.sumarPuntos(puntaje);
                }
            }
        }
        return puntajes.values().stream()
                .sorted((p1, p2) -> p2.getPuntaje() - p1.getPuntaje())
                .collect(Collectors.toList());
    }

    private static Resultado encontrarResultado(List<Resultado> resultados, String pais1, String pais2) {
        for (Resultado resultado : resultados) {
            if (resultado.getPais1().equals(pais1) && resultado.getPais2().equals(pais2)) {
                return resultado;
            }
        }
        return null;
    }

    private static int calcularPuntaje(Pronostico pronostico, Resultado resultado) {
        int puntaje = 0;
        if (pronostico.getGanoPais1() && resultado.isGanoPais1()) {
            puntaje++;
        }
        if (pronostico.getGanoPais2() && resultado.isGanoPais2()) {
            puntaje++;
        }
        if (pronostico.getEmpate() && resultado.isEmpate()) {
            puntaje++;
        }
        return puntaje;
    }

    private static void mostrarPuntajes(List<Participante> participantes) {
        System.out.println("Puntajes:");
        for (Participante participante : participantes) {
            System.out.println(participante.getNombre() + " - " + participante.getPuntaje() + " puntos");
        }
    }
}

