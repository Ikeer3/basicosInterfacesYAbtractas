package SistemaSeguridad;

public abstract class DispositivoSeguridad implements ControlRemoto {

    private String nombreDispositivo;
    protected String habitacion;
    private double nivelbateria;
    protected boolean enLinea;

    public DispositivoSeguridad(String nombreDispositivo, String habitacion) {
        this.habitacion = habitacion;
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

//
//            4. Ejecución (Main)
//    Crea una lista de DispositivoSeguridad que contenga:
//
//    Una cámara en el "Garaje".
//
//    Una alarma de humo en la "Cocina".
//
//    Una cámara en la "Entrada".
//
//    Prueba lo siguiente:
//
//    Conecta todos los dispositivos.
//
//    Llama a ejecutarAccion() de todos ellos recorriendo la lista.
//
//    Baja manualmente la batería de la alarma de la cocina al 5% usando el setter para comprobar que la notificación de emergencia salta sola.
}
