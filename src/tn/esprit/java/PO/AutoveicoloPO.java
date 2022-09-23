package tn.esprit.java.PO;

public class AutoveicoloPO extends VeicoloPO {
    public int Nbr_door;

    public AutoveicoloPO(int nbr_telaio, String marca, String modello, int iva, int nbr_door) {
        super (nbr_telaio, marca, modello, iva);
        Nbr_door = nbr_door;
    }

    public AutoveicoloPO() {
    }

    public AutoveicoloPO(int nbr_door) {
        Nbr_door = nbr_door;
    }

    public AutoveicoloPO( String marca, String modello, int iva, int nbr_door) {
        super( marca, modello, iva);
        Nbr_door = nbr_door;
    }

    public int getNbr_door() {
        return Nbr_door;
    }

    public void setNbr_door(int nbr_door) {
        Nbr_door = nbr_door;
    }
    @Override
    public String toString() {
        return "Autoveicoli{" +
                "Nbr_telaio "+getNbr_telaio()+
                ", Nbr_doors=" + getNbr_door() +
                ", Marca='" + getMarca() + '\'' +
                ", Modello='" + getModello() + '\'' +
                ", Iva=" + getIva() +
                '}';

    }

}
