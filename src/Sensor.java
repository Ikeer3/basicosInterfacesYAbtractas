import java.util.ArrayList;
import java.util.Random;

public abstract class Sensor implements AparatoElectrico {

    private int valor;
    protected String habitacion;
    protected boolean encendido;

    public Sensor(String habitacion) {
        this.habitacion = habitacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Encendiendo sensor de " + habitacion);
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Apagando sensor de " + habitacion);
    }

    @Override
    public void mostrarEstado() {
        String estado;
        if (encendido) {
            estado = "Encendido";
        } else {
            estado = "Apagado";
        }
        System.out.println("Estado del sensor de " + habitacion + ": " + estado);
    }

    public abstract void medir();

    static class SensorHumedad extends Sensor {

        public SensorHumedad(String habitacion) {
            super(habitacion);
        }

        @Override
        public void medir() {
            if (!encendido) {
                System.out.println("Sensor de humedad de " + habitacion + ": desconectado");
            } else {
                System.out.println("Sensor de humedad de " + habitacion + ": " + getValor() + "%");
            }
        }
    }

    static class SensorTemperatura extends Sensor {

        private boolean mostrarFahrenheit = false;

        public SensorTemperatura(String habitacion) {
            super(habitacion);
        }

        public void configurarCelsius() {
            mostrarFahrenheit = false;
        }

        public void configurarFahrenheit() {
            mostrarFahrenheit = true;
        }

        @Override
        public void medir() {
            if (!encendido) {
                System.out.println("Sensor de temperatura de " + habitacion + ": desconectado");
            } else {
                if (mostrarFahrenheit) {
                    double fahrenheit = getValor() * 1.8 + 32;
                    System.out.println("Sensor de temperatura de " + habitacion + ": " + fahrenheit + " grados Fahrenheit");
                } else {
                    System.out.println("Sensor de temperatura de " + habitacion + ": " + getValor() + " grados Celsius");
                }
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Sensor> listaSensores = new ArrayList<>();

        SensorHumedad humSalon = new SensorHumedad("salón");
        humSalon.setValor(55);
        humSalon.encender();

        SensorTemperatura tempDormitorio = new SensorTemperatura("dormitorio");
        tempDormitorio.setValor(24);

        SensorTemperatura tempBanho = new SensorTemperatura("baño");
        tempBanho.setValor(19);
        tempBanho.encender();
        tempBanho.configurarFahrenheit();

        listaSensores.add(humSalon);
        listaSensores.add(tempDormitorio);
        listaSensores.add(tempBanho);

//        String[] habitaciones = {"dormitorio", "baño", "cocina", "salón"};
//
//        Random random = new Random();
//
//        for (String hab: habitaciones) {
//            SensorHumedad humedad = new SensorHumedad(hab);
//            humedad.setValor(random.nextInt(50, 61));
//
//            SensorTemperatura temperatura = new SensorTemperatura(hab);
//            temperatura.setValor(random.nextInt(20, 31));
//
//            if (hab.equals("dormitorio")) {
//                temperatura.configurarFahrenheit();
//            }
//
//            listaSensores.add(humedad);
//            listaSensores.add(temperatura);
//        }

        System.out.println("\n---SENSORES DE LA CASA---");
        for (Sensor s: listaSensores) {
            s.mostrarEstado();
            s.medir();
        }

//        temperatura.configurarCelsius();
//        temperatura.medir();
//
//        temperatura.configurarFahrenheit();
//        temperatura.medir();
    }
}
