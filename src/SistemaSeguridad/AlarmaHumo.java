package SistemaSeguridad;

public class AlarmaHumo extends DispositivoSeguridad implements AlertaEmergencia {

    public AlarmaHumo(String nombreDispositivo) {
        super(nombreDispositivo);
    }

    public void setNivelBateria(double nivelbateria) {
        super.setNivelbateria(nivelbateria);
        if (enLinea && getNivelbateria() < 10) {
            System.out.println("BATERÍA CRÍTICA en " + getNombreDispositivo());
            notificarAutoridades();
        }
    }

    @Override
    public void ejecutarAccion() {
        if (enLinea) {
            System.out.println("Analizando partículas de aire en " + getNombreDispositivo());
        } else {
            System.out.println(getNombreDispositivo() + ": Alarma de humo desactivada");
        }
    }

    @Override
    public void notificarAutoridades() {
        System.out.println("EMERGENCIA!!: Conectando con la central de seguridad...");
        System.out.println("Notificación: Fallo crítico en el sensor de " + getNombreDispositivo());
    }
}
