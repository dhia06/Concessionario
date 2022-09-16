package tn.esprit.java.Repository;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.DAO.AutocarriDao;
import tn.esprit.java.DAO.AutocarriDaoImpl;
import tn.esprit.java.MapperBo.AutocarriMapperBo;
import tn.esprit.java.PO.AutocarriPO;
import java.util.ArrayList;
import java.util.List;

public class AutocarriRepository implements IAutocarriRepository {
     private AutocarriDao autocarriDao;

     public AutocarriRepository() {
         this.autocarriDao = new AutocarriDaoImpl();
     }

    @Override
    public List<Autocarri> getAutocarri() {
         List<Autocarri> lista = new ArrayList<>();
         // 1. use a DAO to retrieve data
        List<AutocarriPO> listAutocarriPO = this.autocarriDao.getAutocarri();
        for (AutocarriPO lis: listAutocarriPO){
            // 2. transform PO -> BO
            // create a class mapper PO -> BO
            AutocarriMapperBo autocarriMapperBo= new AutocarriMapperBo();
            lista.add(autocarriMapperBo.mapp(lis));
         }
        // 3. return the BO
        return lista;
    }

    @Override
    public Autocarri findAutoByid(int nbr_telaio) {
         Autocarri auto = new Autocarri();
         AutocarriPO ss = this.autocarriDao.findAutoByid(nbr_telaio);
         AutocarriMapperBo autocarriMapperBo = new AutocarriMapperBo();
         auto=autocarriMapperBo.mapp(ss);
        return auto;
    }

    @Override
    public List<Autocarri> finfByMArca(String marca) {
        List<Autocarri> lista = new ArrayList<>();
        // 1. use a DAO to retrieve data
        List<AutocarriPO> listAutocarriPO = this.autocarriDao.finfByMArca(marca);
        for (AutocarriPO lis: listAutocarriPO){
            // 2. transform PO -> BO
            // create a class mapper PO -> BO
            AutocarriMapperBo autocarriMapperBo= new AutocarriMapperBo();
            lista.add(autocarriMapperBo.mapp(lis));
        }
        // 3. return the BO
        return lista;
    }
    @Override
    public List <Autocarri> findByIva(int iva){
         List <Autocarri>lista = new ArrayList<>();
         List<AutocarriPO> autocarriPOList = this.autocarriDao.findByIva(iva);
         for ( AutocarriPO autocarriPO: autocarriPOList){
             AutocarriMapperBo autocarriMapperBo= new AutocarriMapperBo();
             lista.add(autocarriMapperBo.mapp(autocarriPO));

         }
         return lista;
    }


    @Override
    public void insertAutocarri(Autocarri autocarri) {
         autocarriDao.insertAutocarri(autocarri.getMarca(), autocarri.getModello(), (int) autocarri.getIva(), autocarri.getMax_capacity());

         System.out.println("okeyy");
     }

    @Override
    public void updateAutocarri(Autocarri po ) {
      //   AutocarriPO autocarriPO = new AutocarriPO();

     this.autocarriDao.updateAutocarri(po.getMarca(), po.getModello(), (int) po.getIva(), po.getMax_capacity());



    }

    @Override
    public void deleteAutocarri(Autocarri po) {
         this.autocarriDao.deleteAutocarri(po.getMarca());

    }
}
