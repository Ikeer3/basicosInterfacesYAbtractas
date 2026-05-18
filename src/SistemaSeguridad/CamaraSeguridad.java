package SistemaSeguridad;

public class CamaraSeguridad extends DispositivoSeguridad {

    private int resolucion;

    public CamaraSeguridad(String nombreDispositivo, int resolucion) {
        super(nombreDispositivo);
        this.resolucion = resolucion;
    }

    public void configurarResolucion(int res) {
        this.resolucion = res;
    }

    @Override
    public void ejecutarAccion() {
        if (enLinea) {
            System.out.println("Grabando en " + getNombreDispositivo() + " con resolución " + resolucion);
        } else {
            System.out.println(getNombreDispositivo() + ": Cámara fuera de servicio");
        }
    }
}
