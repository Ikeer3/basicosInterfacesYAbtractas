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
}
