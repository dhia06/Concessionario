
package tn.esprit.java.DAO;

import tn.esprit.java.PO.AutocarriPO;

import java.util.List;

public interface AutocarriDao {


    public List<AutocarriPO> getAutocarri();

    public AutocarriPO findAutoByid(int nbr_telaio);
     public List<AutocarriPO> finfByMArca(String marca);
     public List<AutocarriPO> findByIva(int iva);
    public  void insertAutocarri(String marca,String modello,int iva,int max_capacity);
    public void updateAutocarri(String marca,String modello,int iva ,int max_capacity);
    public void deleteAutocarri(String marca);

}