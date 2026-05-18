package SistemaSeguridad;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<DispositivoSeguridad> listaDispositivos = new ArrayList<>();

        System.out.println("\n--- Iniciando Sistema ---");
        CamaraSeguridad camara1 = new CamaraSeguridad("Garaje", 720);
        camara1.conectar();

        System.out.println("\n--- Simulando fallo de batería ---");
        AlarmaHumo alarma1 = new AlarmaHumo("Cocina");
        alarma1.conectar();
        alarma1.setNivelBateria(5);

        CamaraSeguridad camara2 = new CamaraSeguridad("Entrada", 1080);
        camara2.conectar();
        camara2.configurarResolucion(2160);

        listaDispositivos.add(camara1);
        listaDispositivos.add(alarma1);
        listaDispositivos.add(camara2);

        for (DispositivoSeguridad dispositivos: listaDispositivos) {
            dispositivos.mostrarEstado();
            dispositivos.ejecutarAccion();
        }
    }
}
