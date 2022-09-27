package tn.esprit.java.Repository;

import org.apache.log4j.BasicConfigurator;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.BO.Veicolo;
import tn.esprit.java.DAO.*;
import tn.esprit.java.Mapper.ConcessionarioMapper;
import tn.esprit.java.MapperBo.AutocarriMapperBo;
import tn.esprit.java.MapperBo.AutoveicoliMapperBo;
import tn.esprit.java.MapperBo.ConcessionarioMapperBo;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.AutoveicoloPO;
import tn.esprit.java.PO.ConcessionarioPO;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static tn.esprit.java.Repository.AutocarriRepository.logger;


public class ConcessionnarioRepository implements IConcessionnarioRepository {
    private ConcessionarioDao concessionarioDao;
    private AutoveicoloDao autoveicoloDao;
    private AutocarriDao autocarriDao;



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

    }

    @Override
    public void insertConcessionario(Concessionario concessionario) {
        BasicConfigurator.configure();
        //call the mapper BO --> PO
        ConcessionarioMapperBo concessionarioMapperBo = new ConcessionarioMapperBo ();
        AutoveicoliMapperBo autoveicoliMapperBo = new AutoveicoliMapperBo ();
        AutocarriMapperBo autocarriMapperBo = new AutocarriMapperBo ();
        //Verify if this Concessionario exist or not!!!
        ConcessionarioPO concessionarioPO = concessionarioDao.getConcessionarioById (concessionarioMapperBo.mapinverse(concessionario).getIva ());;
        if (concessionarioPO.getIva () == 0){   //the concessionario dont exist in the Db
            logger.info ("the concessionario dont exist in the Db");
            this.concessionarioDao.insertConcessionario (concessionario.getIva (), concessionario.getNome (), concessionario.getCitta (), concessionario.getIndirizzo ());
            logger.info ("the concessionario is inserted in the Db");
            List<Veicolo> listVeicoli = concessionario.getListcars (); ////I will ask Fabiano get or set????
            for (Veicolo veicolo : listVeicoli) {
                if (veicolo instanceof Autoveicolo) {
                    //Verify if this Autoveicolo exist or not!!!!
                    Autoveicolo v = (Autoveicolo) veicolo;
                    AutoveicoloPO autoveicoloPO = autoveicoloDao.getAutoByID (autoveicoliMapperBo.mapinverse(v).getNbr_telaio ());
                    if (autoveicoloPO.getNbr_telaio ()==0){ //Autoveicolo dont exist in DB
                        logger.info ("the veicolo don't exist in the DB");
                        autoveicoloDao.insertAutoveicoli (v.getMarca (), v.getModello (), v.getIva (), v.getNbr_door ());
                    }
                    else {
                        logger.error ("this autoveicolo is already exist in the DB");
                    }
                }
                else if (veicolo instanceof Autocarri) {
                    //Verify if this Autocarri exist or not !!!
                    Autocarri c = (Autocarri) veicolo;
                    AutocarriPO autocarriPO = autocarriDao.findAutoByid (autocarriMapperBo.mappinverse (c).getNbr_telaio ());
                    if (autocarriPO.getNbr_telaio ()==0){   //this autocarri dont exist in the DB
                        logger.info ("Inserting autocarri in DB");
                        autocarriDao.insertAutocarri (c.getNbr_telaio (), c.getMarca (), c.getModello (), c.getIva (), c.getMax_capacity (), c.getImage ());
                    }
                    else {
                        logger.error ("this autoveicolo already exist");}
                }
            }
        }
        else{
           logger.error ("this Concessionario already exist in the DB!!");
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
