package tn.esprit.java.PO;

public class AutocarriPO extends VeicoloPO {

    public int Max_capacity;

    public AutocarriPO() {
    }

    public AutocarriPO(int max_capacity) {

        Max_capacity = max_capacity;
    }

    public AutocarriPO( String marca, String modello, long iva, int max_capacity) {
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
                "Max_capacity=" + getMax_capacity() +
                ", Marca='" + getMarca() + '\'' +
                ", Modello='" + getModello() + '\'' +
                ", Iva=" + getIva() +
                ", Nbr_telaio"+getNbr_telaio()+
                '}';
    }


}
