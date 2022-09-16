package tn.esprit.java.Repository;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.PO.AutoveicoloPO;

import java.util.List;

public interface IAutoveicoliRepository {
    public List<Autoveicolo> getAutoveicolo();
    public Autoveicolo gettAutoByID(int nbr_telaio);
    public List<Autoveicolo> getbyMarca(String Marca);
    public  void insertAutoveicolii(Autoveicolo autoveicolo);


    public void updateAutoveicoli(Autoveicolo autoveicolo);
    public void deleteAutoveicoli(Autoveicolo autoveicolo);

}
