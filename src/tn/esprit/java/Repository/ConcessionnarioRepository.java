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

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class ConcessionnarioRepository implements IConcessionnarioRepository {
    private ConcessionarioDao concessionarioDao;
    private AutoveicoloDao autoveicoloDao;
    private AutocarriDao autocarriDao;


    int ivaa;

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
//methode reserve pour le CSV file
    @Override
    public void insertConc(Concessionario conc) {
        concessionarioDao.insertConcessionario (conc.getIva (), conc.getNome (), conc.getCitta (), conc.getIndirizzo ());

        System.out.println("okeyy");
    }
    @Override
    public void insertConcessionario(Concessionario concessionario) {


            System.out.println ("IF");
            this.concessionarioDao.insertConcessionario (concessionario.getIva (), concessionario.getNome (), concessionario.getCitta (), concessionario.getIndirizzo ());
            List<Veicolo> listVeicoli = concessionario.getListcars ();
            for (Veicolo veicolo : listVeicoli) {
                if (veicolo instanceof Autoveicolo) {
                    Autoveicolo v = (Autoveicolo) veicolo;
                    autoveicoloDao.insertAutoveicoli (v.getMarca (), v.getModello (), v.getIva (), v.getNbr_door ());
                } else if (veicolo instanceof Autocarri) {
                    Autocarri c = (Autocarri) veicolo;
                    autocarriDao.insertAutocarri (c.getNbr_telaio (), c.getMarca (), c.getModello (), c.getIva (), c.getMax_capacity (), c.getImage ());
                    System.out.println ("inserted" + concessionario + c);
                }

        }
    };

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
        Concessionario concessionario = new Concessionario ();
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
