package tn.esprit.java.BO;

import tn.esprit.java.PO.VeicoloPO;

import java.util.ArrayList;
import java.util.List;

public class Concessionario {

    private int iva;
    private String nome ;
    private String citta ;
    private String indirizzo ;
    private List<Veicolo> listcars = new ArrayList<>();


    public Concessionario() {
    }


    public Concessionario(String nome, String citta, String indirizzo) {
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
    }

    public Concessionario(String nome, String citta, String indirizzo, List<Veicolo> listcars) {
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.listcars = listcars;
    }

    public Concessionario(int iva, String nome, String citta, String indirizzo, List<Veicolo> listcars) {
        this.iva = iva;
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.listcars = listcars;
    }

    public Concessionario(int iva, String nome, String citta, String indirizzo) {
        this.iva = iva;
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;

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

    public List<Veicolo> getListcars( ) {
        return listcars;
    }

    public void setListcars(List<Veicolo> listcars) {
        this.listcars = listcars;
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
    public String toString( ) {
        return "Concessionario{" +
                "iva=" + iva +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", listcars=" + listcars +
                '}';
    }
}
