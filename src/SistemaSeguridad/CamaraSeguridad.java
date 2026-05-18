package SistemaSeguridad;

public class CamaraSeguridad extends DispositivoSeguridad {

    private int resolucion;

    public CamaraSeguridad(String nombreDispositivo, String habitacion, int resolucion) {
        super(nombreDispositivo, habitacion);
        this.resolucion = resolucion;
    }

    public void configurarResolucion(int res) {
        this.resolucion = res;
    }

    @Override
    public void ejecutarAccion() {
        if (enLinea) {
            System.out.println("Grabando en " + habitacion + " con resolución " + resolucion);
        } else {
            System.out.println(getNombreDispositivo() + ": Cámara fuera de servicio");
        }
    }
}
