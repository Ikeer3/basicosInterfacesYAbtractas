public abstract class Sensor {

    protected int valor;

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public abstract String medir();
}
