package tn.esprit.java.Repository;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.DAO.AutoveicoliDaoImpl;
import tn.esprit.java.DAO.AutoveicoloDao;
import tn.esprit.java.MapperBo.AutoveicoliMapperBo;
import tn.esprit.java.PO.AutoveicoloPO;
import java.util.ArrayList;
import java.util.List;

public class AutoveicoliRepository implements IAutoveicoliRepository {
    private AutoveicoloDao autoveicoloDao;

    public AutoveicoliRepository() {
        this.autoveicoloDao = new AutoveicoliDaoImpl();
    }

    @Override
    public List<Autoveicolo> getAutoveicolo() {
        List<Autoveicolo> list1 = new ArrayList<>();
        List<AutoveicoloPO> list = this.autoveicoloDao.getAutoveicolo();
        for (AutoveicoloPO i : list) {
            AutoveicoliMapperBo autoveicoliMapperBo = new AutoveicoliMapperBo();
            list1.add(autoveicoliMapperBo.mapp(i));

        }
        return list1;
    }

    @Override
    public Autoveicolo gettAutoByID(int nbr_telaio) {
        AutoveicoloPO autoveicoloPO = this.autoveicoloDao.getAutoByID(nbr_telaio);
        Autoveicolo autoveicolo = new Autoveicolo();
        AutoveicoliMapperBo autoveicoliMapperBo = new AutoveicoliMapperBo();
        autoveicolo = autoveicoliMapperBo.mapp(autoveicoloPO);
        return autoveicolo;
    }


    @Override
    public List<Autoveicolo> getbyMarca(String marca) {
        List<AutoveicoloPO> list = this.autoveicoloDao.getbyMarca(marca);
        List<Autoveicolo> list1 = new ArrayList<>();
        for (AutoveicoloPO cc : list) {
            AutoveicoliMapperBo autoveicoliMapperBo = new AutoveicoliMapperBo();
            list1.add(autoveicoliMapperBo.mapp(cc));
        }
        return list1;
    }

    @Override
    public void insertAutoveicolii(Autoveicolo autoveicolo) {
        this.autoveicoloDao.insertAutoveicoli(autoveicolo.getMarca(), autoveicolo.getModello(), autoveicolo.getIva(), autoveicolo.getNbr_door());

    }

    @Override
    public void updateAutoveicoli(Autoveicolo ppo) {
        this.autoveicoloDao.insertAutoveicoli(ppo.getMarca(), ppo.getModello(), ppo.getIva(), ppo.getNbr_door());

    }

    @Override
    public void deleteAutoveicoli(Autoveicolo autoveicolo) {
        this.autoveicoloDao.deleteAutoveicoli(autoveicolo.getMarca());
    }
}
