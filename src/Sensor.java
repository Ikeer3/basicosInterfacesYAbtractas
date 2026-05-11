import java.util.ArrayList;

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
                System.out.println("Sensor de temperatura de " + fahrenheit + " grados Fahrenheit");
            } else {
                System.out.println("Sensor de temperatura de " + getValor() + " grados");
            }
        }
    }

    public static void main(String[] args) {
        
        SensorHumedad humedad = new SensorHumedad("dormitorio");
        humedad.setValor(55);
        humedad.medir();

        SensorTemperatura temperatura = new SensorTemperatura("salón");
        temperatura.setValor(23);

        temperatura.configurarCelsius();
        temperatura.medir();

        temperatura.configurarFahrenheit();
        temperatura.medir();
    }
}
