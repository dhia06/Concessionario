package tn.esprit.java.PO;

import tn.esprit.java.BO.Autocarri;

import java.util.ArrayList;
import java.util.List;

public class ConcessionarioPO {
    private int iva ;
    public String nome ;
    public String citta ;
    public String indirizzo ;
   // public String veicolilist ;
   //private List<Autocarri> listcars = new ArrayList<>();




    public ConcessionarioPO() {
    }

    public ConcessionarioPO(int iva, String nome, String citta, String indirizzo) {
        this.iva = iva;
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
       // this.veicolilist = veicolilist;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {

        this.iva = iva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    @Override
    public String toString() {
        return "Concessionario{" +
                "Iva=" + iva +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                 '\'' +
                '}';
    }

    //private List<Veicolo> Veicolo;
}
