package SistemaSeguridad;

public class CamaraSeguridad extends DispositivoSeguridad {

    private String habitacion;
    private int resolucion;

    public CamaraSeguridad(String nombreDispositivo, String habitacion) {
        super(nombreDispositivo);
        this.habitacion = habitacion;
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
