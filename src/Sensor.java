public abstract class Sensor {

    private int valor;

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public abstract void medir();

    static class SensorHumedad extends Sensor {

        @Override
        public void medir() {
            System.out.println("\nHay una humedad del " + getValor() + "%");
        }
    }

    static class SensorTemperatura extends Sensor {

        private boolean mostrarFahrenheit = false;

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
                System.out.println("Hay una temperatura de " + fahrenheit + " grados Fahrenheit");
            } else {
                System.out.println("Hay una temperatura de " + getValor() + " grados");
            }
        }
    }

    public static void main(String[] args) {

        SensorHumedad humedad = new SensorHumedad();
        humedad.setValor(55);
        humedad.medir();

        SensorTemperatura temperatura = new SensorTemperatura();
        temperatura.setValor(23);

        temperatura.configurarCelsius();
        temperatura.medir();

        temperatura.configurarFahrenheit();
        temperatura.medir();
    }
}
