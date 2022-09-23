package tn.esprit.java.PO;

public abstract class VeicoloPO {
    private int Nbr_telaio ;
    public String Marca;
    public String Modello ;
    public int Iva;

    public VeicoloPO() {
    }

    public VeicoloPO(int nbr_telaio, String marca, String modello, int iva) {
        Nbr_telaio = nbr_telaio;
        Marca = marca;
        Modello = modello;
        Iva = iva;
    }

    public VeicoloPO(String marca, String modello, int iva) {

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

    public int getIva() {
        return Iva;
    }

    public void setIva(int iva) {
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
