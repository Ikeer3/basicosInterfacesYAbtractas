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
//
//
//    Crea la clase AlarmaHumo:
//
//    El método ejecutarAccion() debe imprimir: "Analizando partículas de aire en [habitación]...".
//
//            3. El Interfaz de Emergencia y la Automatización
//    Crea la interfaz AlertaEmergencia.
//
//    Método: notificarAutoridades(). Añade un Javadoc: / Envía una señal de auxilio inmediata a la central de seguridad */.
//
//    Haz que la clase AlarmaHumo implemente esta interfaz.
//
//    El Reto Técnico:
//    En DispositivoSeguridad, modifica el setter de nivelBateria.
//
//    Si la batería baja del 10%, el dispositivo debe imprimir automáticamente: "¡BATERÍA CRÍTICA EN [nombre]!".
//
//    En el caso específico de la AlarmaHumo, si la batería baja del 10%, además del mensaje anterior, debe llamar automáticamente al método notificarAutoridades() (porque una alarma sin batería es una emergencia de seguridad).
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
