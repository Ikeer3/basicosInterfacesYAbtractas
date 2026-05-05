public abstract class Animal {

    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract String hacerSonido();

    static class Zorro extends Animal {
        private String raza;

        public Zorro(String nombre, String raza) {
            super(nombre);
            this.raza = raza;
        }

        @Override
        public String hacerSonido() {
            return nombre + " de raza " + raza + " AULLA!!";
        }
    }

    static class Gato extends Animal {
        private String color;

        public Gato(String nombre, String color) {
            super(nombre);
            this.color = color;
        }

        @Override
        public String hacerSonido() {
            return nombre + " de color " + color + " hace MIAU!!";
        }
    }

    public static void main(String[] args) {

        System.out.println("\n---MIS MASCOTAS---");

        Gato gato1 = new Gato("Dobby", "naranja");
        System.out.println(gato1.hacerSonido());

        Zorro zorro1 = new Zorro("Tod", "ibérica");
        System.out.println(zorro1.hacerSonido());
    }
}