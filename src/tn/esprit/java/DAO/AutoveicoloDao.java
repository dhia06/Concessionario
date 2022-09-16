package tn.esprit.java.DAO;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.AutoveicoloPO;

import java.util.List;

public interface AutoveicoloDao {
    public List<AutoveicoloPO> getAutoveicolo();
    public AutoveicoloPO getAutoByID( int nbr_telaio);
    public List<AutoveicoloPO> getbyMarca(String marca);
    public  void insertAutoveicoli(String marca,String modello,int iva,int nbr_door);


    public void updateAutoveicoli(String marca,String modello,int iva ,int nbr_door);
    public void deleteAutoveicoli(String marca);
    public List<AutoveicoloPO> findbyIva(int iva);



}
