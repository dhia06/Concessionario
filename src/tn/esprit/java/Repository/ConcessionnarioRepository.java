package tn.esprit.java.Repository;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.BO.Veicolo;
import tn.esprit.java.DAO.*;
import tn.esprit.java.MapperBo.AutocarriMapperBo;
import tn.esprit.java.MapperBo.AutoveicoliMapperBo;
import tn.esprit.java.MapperBo.ConcessionarioMapperBo;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.AutoveicoloPO;
import tn.esprit.java.PO.ConcessionarioPO;

import java.util.ArrayList;
import java.util.List;


public class ConcessionnarioRepository implements IConcessionnarioRepository {
    private ConcessionarioDao concessionarioDao;
    private AutoveicoloDao autoveicoloDao;
    private AutocarriDao autocarriDao;
    public AutocarriRepository autocarriRepository;
    private AutocarriRepository autocRepo = new AutocarriRepository ();
    private AutoveicoliRepository autovRepo = new AutoveicoliRepository ();

    public ConcessionnarioRepository( ) {
        this.concessionarioDao = new ConcessionarioImp ();
        this.autocarriDao = new AutocarriDaoImpl ();
        this.autoveicoloDao = new AutoveicoliDaoImpl ();
    }

    @Override
    //the purpose of this method is to retrive all concessionari with their list of cars

    public List<Concessionario> getConcessionario( ) {
        // 1. declare a result and other variable to use in logic
        List<Concessionario> listConcessionario = new ArrayList<> ();
        List<ConcessionarioPO> listConcessionarioPo = this.concessionarioDao.getConcessionario ();
        List<AutocarriPO> listAutocarriPo = this.autocarriDao.getAutocarri ();
        List<AutoveicoloPO> listAutoveicoloPo = this.autoveicoloDao.getAutoveicolo ();
        ConcessionarioMapperBo concessionarioMapperBo = new ConcessionarioMapperBo ();
        AutocarriMapperBo autocarriMapperBo = new AutocarriMapperBo ();
        AutoveicoliMapperBo autoveicoliMapperBo = new AutoveicoliMapperBo ();
        for (ConcessionarioPO concpo : listConcessionarioPo) {
            List<Veicolo> listAutov = new ArrayList<> ();
            Concessionario concessionario = concessionarioMapperBo.mapp (concpo);
            for (AutocarriPO autocpo : listAutocarriPo) {
                if (concpo.getIva () == autocpo.getIva ()) {
                    Autocarri autoc = autocarriMapperBo.mapp (autocpo);
                    listAutov.add (autoc);
                }
            }
            for (AutoveicoloPO autovpo : listAutoveicoloPo) {
                if (concpo.getIva () == autovpo.getIva ()) {
                    Autoveicolo autov = autoveicoliMapperBo.mapp (autovpo);
                    listAutov.add (autov);
                }
            }
            concessionario.setListcars (listAutov);
            listConcessionario.add (concessionario);
        }
        System.out.println (listConcessionario);
        return listConcessionario;
    }

    @Override
    public List<Concessionario> getConcessionario(String nome) {
        List<ConcessionarioPO> list = this.concessionarioDao.getConcessionario (nome);
        List<Concessionario> list1 = new ArrayList<> ();
        for (ConcessionarioPO i : list) {
            ConcessionarioMapperBo concessionarioMapperBo = new ConcessionarioMapperBo ();
            list1.add (concessionarioMapperBo.mapp (i));
        }
        return list1;
    }

    @Override
    public void insertConcessionario(Concessionario concessionario) {
        Autocarri autocarri = new Autocarri ();
        Autoveicolo autoveicolo = new Autoveicolo ();
        List<Veicolo> listv = new ArrayList<> ();
        listv.add (autocarri);
        listv.add (autoveicolo);
        concessionario.setListcars (listv);
        System.out.println ("Listof cars" + listv);
        this.autocRepo.insertAutocarri (autocarri);
        this.autovRepo.insertAutoveicolii (autoveicolo);
        this.concessionarioDao.insertConcessionario (concessionario.getIva (),concessionario.getNome (), concessionario.getCitta (), concessionario.getIndirizzo ());
    }

    @Override
    public void UpdateConcessionario(Concessionario poc) {
        this.concessionarioDao.updateConcessionario (poc.getCitta (), poc.getIndirizzo (), poc.getNome ());

    }

    @Override
    public void DeleteConcessionario(String nome) {
        this.concessionarioDao.deleteConcessionario (nome);

    }


    @Override
    public Concessionario getConcessionarioById(int iva) {
        Concessionario concessionario = null;
        List<Veicolo> listveic = new ArrayList<> ();
        List<AutocarriPO> listAutocarriPo = new ArrayList<> ();
        List<AutoveicoloPO> listAutoveicoliPo = new ArrayList<> ();
        ConcessionarioMapperBo concessionarioMapperBo = new ConcessionarioMapperBo ();
        AutocarriMapperBo autocarriMapperBo = new AutocarriMapperBo ();
        AutoveicoliMapperBo autoveicoliMapperBo = new AutoveicoliMapperBo ();
        ConcessionarioPO concessionarioPO = this.concessionarioDao.getConcessionarioById (iva);
        if (concessionarioPO.getIva () != 0){
        concessionario = concessionarioMapperBo.mapp (concessionarioPO);
        listAutocarriPo = this.autocarriDao.findByIva (iva);
        listAutoveicoliPo = this.autoveicoloDao.findbyIva (iva);
        for (AutoveicoloPO autovpo : listAutoveicoliPo) {
            Autoveicolo autov = autoveicoliMapperBo.mapp (autovpo);
            listveic.add (autov);
        }
        for (AutocarriPO autocpo : listAutocarriPo) {
            Autocarri autoc = autocarriMapperBo.mapp (autocpo);
            listveic.add (autoc);
        }

        concessionario.setListcars (listveic);
        System.out.println ("test" + concessionario);}
        else {
            System.out.println ("no concessionarion exists!!!");
        }
        return concessionario;
    }

    @Override
    public void deleteConsByid(int iva) {
        this.concessionarioDao.deleteConsByid (iva);

    }


    @Override
    public void updateByidd(Concessionario pocc) {

        this.concessionarioDao.updateByid (pocc.getNome (), pocc.getCitta (), pocc.getIndirizzo ());

    }
}
