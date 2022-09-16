package tn.esprit.java.BO;

public abstract class Veicolo {
    private int Nbr_telaio ;
    private String Marca;
    private String Modello ;
    private long Iva;

    public Veicolo(int nbr_telaio, String marca, String modello, long iva) {
        Nbr_telaio = nbr_telaio;
        Marca = marca;
        Modello = modello;
        Iva = iva;
    }

    public Veicolo() {
    }

    public Veicolo( String marca, String modello, long iva) {

        Marca = marca;
        Modello = modello;
        Iva = iva;
    }

    public int getNbr_telaio() {
        return Nbr_telaio;
    }

    public void setNbr_telaio(int nbr_telaio) {
        Nbr_telaio = nbr_telaio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModello() {
        return Modello;
    }

    public void setModello(String modello) {
        Modello = modello;
    }

    public long getIva() {
        return Iva;
    }

    public void setIva(long iva) {
        Iva = iva;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "Nbr_telaio=" + Nbr_telaio +
                ", Marca='" + Marca + '\'' +
                ", Modello='" + Modello + '\'' +
                ", Iva=" + Iva +
                '}';
    }
}
