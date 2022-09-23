package tn.esprit.java.PO;

import com.mysql.cj.jdbc.Blob;

public class AutocarriPO extends VeicoloPO {

    public int Max_capacity;

public Blob image;
    public AutocarriPO() {
    }

    public AutocarriPO(int nbr_telaio, String marca, String modello, int iva, int max_capacity) {
        super (nbr_telaio, marca, modello, iva);
        Max_capacity = max_capacity;
    }

    public AutocarriPO(String marca, String modello, int iva, int max_capacity, Blob image) {
        super (marca, modello, iva);
        Max_capacity = max_capacity;
        this.image = image;
    }

    public AutocarriPO(int max_capacity) {

        Max_capacity = max_capacity;
    }

    public AutocarriPO( String marca, String modello, int iva, int max_capacity) {
        super( marca, modello, iva);
        Max_capacity = max_capacity;
    }
    public Blob getImage( ) {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
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
                "Max_capacity=" + getMax_capacity() +
                ", Marca='" + getMarca() + '\'' +
                ", Modello='" + getModello() + '\'' +
                ", Iva=" + getIva() +
                ", Nbr_telaio"+getNbr_telaio()+
                '}';
    }


}
