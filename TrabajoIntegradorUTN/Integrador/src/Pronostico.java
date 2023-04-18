public class Pronostico {
    private String nombre;
    private String pais1;
    private String pais2;
    private boolean ganoPais1;
    private boolean empate;
    private boolean ganoPais2;

    public Pronostico(String nombre, String pais1, String pais2, boolean ganoPais1, boolean empate, boolean ganoPais2) {
        this.nombre = nombre;
        this.pais1 = pais1;
        this.pais2 = pais2;
        this.ganoPais1 = ganoPais1;
        this.empate = empate;
        this.ganoPais2 = ganoPais2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais1() {
        return pais1;
    }

    public String getPais2() {
        return pais2;
    }

    public boolean getGanoPais1() {
        return ganoPais1;
    }

    public boolean getEmpate() {
        return empate;
    }

    public boolean getGanoPais2() {
        return ganoPais2;
    }
}
