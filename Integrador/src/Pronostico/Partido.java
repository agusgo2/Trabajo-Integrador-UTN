package Pronostico;
public class Partido{

    public Equipo equipo1;
    public Equipo equipo2;
    public int golesEquipo1;
    public int golesEquipo2;

    public Partido() {
    }



    public String resultado() {
        if (golesEquipo1 < golesEquipo2) {
            return equipo2.nombre;
        } else if (golesEquipo2 < golesEquipo1) {
            return equipo1.nombre;
        } else {
            return "empate";
        }
    }

}
