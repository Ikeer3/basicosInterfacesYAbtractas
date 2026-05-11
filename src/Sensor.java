import java.util.ArrayList;
import java.util.Random;

public abstract class Sensor {

    private int valor;
    protected String habitacion;

    public Sensor(String habitacion) {
        this.habitacion = habitacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public abstract void medir();

    static class SensorHumedad extends Sensor {

        public SensorHumedad(String habitacion) {
            super(habitacion);
        }

        @Override
        public void medir() {
            System.out.println("\nSensor de humedad de " + habitacion + ": " + getValor() + "%");
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
            if (mostrarFahrenheit) {
                double fahrenheit = getValor() * 1.8 + 32;
                System.out.println("Sensor de temperatura de " + habitacion + ": " + fahrenheit + " grados Fahrenheit");
            } else {
                System.out.println("Sensor de temperatura de " + habitacion + ": " + getValor() + " grados Celsius");
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Sensor> listaSensores = new ArrayList<>();

        String[] habitaciones = {"dormitorio", "baño", "cocina", "salón"};

        Random random = new Random();

        for (String hab: habitaciones) {
            SensorHumedad humedad = new SensorHumedad(hab);
            humedad.setValor(random.nextInt(50, 61));

            SensorTemperatura temperatura = new SensorTemperatura(hab);
            temperatura.setValor(random.nextInt(20, 31));

            if (hab.equals("dormitorio")) {
                temperatura.configurarFahrenheit();
            }

            listaSensores.add(humedad);
            listaSensores.add(temperatura);
        }

        System.out.println("\n---SENSORES DE LA CASA---");
        for (Sensor s: listaSensores) {
            s.medir();
        }

//        temperatura.configurarCelsius();
//        temperatura.medir();
//
//        temperatura.configurarFahrenheit();
//        temperatura.medir();
    }
}
