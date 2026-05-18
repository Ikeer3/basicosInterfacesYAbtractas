package SistemaSeguridad;

public class AlarmaHumo extends DispositivoSeguridad {

    public AlarmaHumo(String nombreDispositivo, String habitacion) {
        super(nombreDispositivo, habitacion);
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("Analizando partículas de aire en " + habitacion);
    }
}
