package tn.esprit.java.BO;

import com.mysql.cj.jdbc.Blob;

public class Autocarri  extends Veicolo{
    private int Max_capacity;
    public Blob image ;

    public Autocarri() {
    }

    public Autocarri(int nbr_telaio, String marca, String modello, int iva, int max_capacity) {
        super (nbr_telaio, marca, modello, iva);
        Max_capacity = max_capacity;
    }

    public Autocarri(int max_capacity) {


        Max_capacity = max_capacity;
    }

    public Autocarri( String marca, String modello, int iva, int max_capacity) {
        super( marca, modello, iva);
        Max_capacity = max_capacity;
    }

    public int getMax_capacity() {
        return Max_capacity;
    }

    public Autocarri(int nbr_telaio, String marca, String modello, int iva, int max_capacity, Blob image) {
        super (nbr_telaio, marca, modello, iva);
        Max_capacity = max_capacity;
        this.image = image;
    }

    public void setMax_capacity(int max_capacity) {
        Max_capacity = max_capacity;
    }

    public Blob getImage( ) {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
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
