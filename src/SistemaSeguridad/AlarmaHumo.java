package SistemaSeguridad;

public class AlarmaHumo extends DispositivoSeguridad implements AlertaEmergencia {

    public AlarmaHumo(String nombreDispositivo, String habitacion) {
        super(nombreDispositivo, habitacion);
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("Analizando partículas de aire en " + habitacion);
    }

    @Override
    public void notificarAutoridades() {
        System.out.println("EMERGENCIA!!: Conectando con la central de seguridad...");
        System.out.println("Notificación: Fallo crítico en el sensor de " + getNombreDispositivo());
    }

    public void setBateria(double nivelbateria) {
        super.setNivelbateria(nivelbateria);
        if (enLinea && getNivelbateria() < 10) {
            System.out.println("BATERÍA CRÍTICA en " + getNombreDispositivo());
            notificarAutoridades();
        }
    }
}
