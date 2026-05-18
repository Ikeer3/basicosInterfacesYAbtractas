package SistemaSeguridad;

public abstract class DispositivoSeguridad implements ControlRemoto {

    private String nombreDispositivo;
    private double nivelbateria;
    protected boolean enLinea;

    public DispositivoSeguridad(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
        this.nivelbateria = 100;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public double getNivelbateria() {
        return nivelbateria;
    }

    public void setNivelbateria(double nivelbateria) {
        this.nivelbateria = nivelbateria;
    }

    @Override
    public void conectar() {
        enLinea = true;
        System.out.println("El dispositivo se ha conectado correctamente");
    }

    @Override
    public void desconectar() {
        enLinea = false;
        System.out.println("El dispositivo se ha desconectado");
    }

    @Override
    public void mostrarEstado() {
        String estado;
        if (enLinea) {
            estado = "CONECTADO";
        } else {
            estado = "DESCONECTADO";
        }
        System.out.println("Estado del dispositivo: " + estado);
    }

    public abstract void ejecutarAccion();
}
