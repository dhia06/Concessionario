package tn.esprit.java.BO;

public class Autocarri  extends Veicolo{
    private int Max_capacity;

    public Autocarri() {
    }

    public Autocarri(int max_capacity) {

        Max_capacity = max_capacity;
    }

    public Autocarri( String marca, String modello, long iva, int max_capacity) {
        super( marca, modello, iva);
        Max_capacity = max_capacity;
    }

    public int getMax_capacity() {
        return Max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        Max_capacity = max_capacity;
    }



    @Override
    public String toString() {
        return "Autocarri{" +
                "Nbr_telaio: "+getNbr_telaio()+
                ", Max_capacity: " + getMax_capacity() +
                ", Marca: '" + getMarca() + '\'' +
                ", Modello: '" + getModello() + '\'' +
                ", Iva: " + getIva() +
                '}';
    }


}
