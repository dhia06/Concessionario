package tn.esprit.java.BO;

public class Autoveicolo extends Veicolo{
    private int Nbr_door;

    public Autoveicolo() {
    }

    public Autoveicolo(int nbr_telaio, String marca, String modello, long iva, int nbr_door) {
        super(nbr_telaio, marca, modello, iva);
        Nbr_door = nbr_door;
    }

    public Autoveicolo(int nbr_door) {
        Nbr_door = nbr_door;
    }



    public Autoveicolo(String marca, String modello, long iva, int nbr_door) {
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
