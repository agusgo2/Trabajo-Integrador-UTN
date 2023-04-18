public class Resultado {
    private String nombre;
    private String pais1;
    private String pais2;
    private boolean ganoPais1;
    private boolean empate;
    private boolean ganoPais2;

    public Resultado(String pais1, String pais2, boolean ganoPais1, boolean empate, boolean ganoPais2) {
        this.nombre = nombre;
        this.pais1 = pais1;
        this.pais2 = pais2;
        this.ganoPais1 = ganoPais1;
        this.empate = empate;
        this.ganoPais2 = ganoPais2;
    }
    public String getPais1() {
        return pais1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais1(String pais1) {
        this.pais1 = pais1;
    }

    public void setPais2(String pais2) {
        this.pais2 = pais2;
    }

    public boolean isGanoPais1() {
        return ganoPais1;
    }

    public void setGanoPais1(boolean ganoPais1) {
        this.ganoPais1 = ganoPais1;
    }

    public boolean isEmpate() {
        return empate;
    }

    public void setEmpate(boolean empate) {
        this.empate = empate;
    }

    public boolean isGanoPais2() {
        return ganoPais2;
    }

    public void setGanoPais2(boolean ganoPais2) {
        this.ganoPais2 = ganoPais2;
    }

    public String getPais2() {
        return pais2;
    }


}
