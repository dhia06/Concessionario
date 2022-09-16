package tn.esprit.java.Repository;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.PO.AutocarriPO;

import java.util.List;

public interface IAutocarriRepository {
    public List<Autocarri> getAutocarri();

    public Autocarri findAutoByid(int nbr_telaio);
    public List<Autocarri> finfByMArca(String marca);
public List <Autocarri>findByIva(int iva);
    public  void insertAutocarri(Autocarri autocarri);
    public void updateAutocarri(Autocarri po);
    public void deleteAutocarri(Autocarri po);
}
