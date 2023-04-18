public class Participante {
    private String nombre;
    private int puntaje;

    public Participante(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }
}
