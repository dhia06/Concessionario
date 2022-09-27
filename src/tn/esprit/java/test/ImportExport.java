package tn.esprit.java.test;
import log4j.Testlog;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.BO.Veicolo;
import tn.esprit.java.CSVmapper.*;
import tn.esprit.java.Repository.AutocarriRepository;
import tn.esprit.java.Repository.AutoveicoliRepository;
import tn.esprit.java.Repository.ConcessionnarioRepository;
import tn.esprit.java.Repository.IConcessionnarioRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ImportExport {
    static Logger logger = Logger.getLogger(ImportExport.class.getName ());


    ConcessionnarioCSV concessionnarioCSV = new ConcessionnarioCSV ();
    AutocarriCsvlamda autocarriCsvlamda = new AutocarriCsvlamda ();
    AutocarriCsvlambda2 autocarriCsvlambda2 = new AutocarriCsvlambda2 ();
    AutocarriCSV autocarriCSV = new AutocarriCSV();
    AutoveicoliCSV autoveicoliCSV = new AutoveicoliCSV ();
    Autocarriimportt autocarriimportt = new Autocarriimportt ();
    public IConcessionnarioRepository ConRepo = new ConcessionnarioRepository ();
    ConcessionnarioRepository concessionnarioRepository = new ConcessionnarioRepository ();



    @Test
    public void Importautoc(){

        autocarriimportt.importcsv ();

    }
    @Test
    public void insertConcessionarioTest(){
        BasicConfigurator.configure();
        Autocarri autoc = new Autocarri (7,"marca","modello",5,4);
        Autoveicolo autov = new Autoveicolo(7,"ferrari1","serie 1",5,7);
        Autocarri autoc1 = new Autocarri (6,"marca","modello",5,4);
        Autoveicolo autov1 = new Autoveicolo(6,"ferrari1","serie 1",5,7);
        List<Veicolo> listcars = new ArrayList<> ();
        listcars.add (autoc);
        listcars.add (autov);
        Concessionario concessionario = new Concessionario(6,"chichou","venice","avenue due",listcars);
        ConRepo.insertConcessionario(concessionario);
        }
    @Test
    public void importAutoc()  {
        String pathurl = "C:\\Users\\mohsassi\\Desktop\\lambda1.csv";
        autocarriCSV.importcsv (pathurl);
    }
    @Test
    public void impoortConc(){
        String pathurl = "C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Concessionario.csv";
        concessionnarioCSV.importcsv (pathurl);
    };


    @Test()
    public void importAutov() {
        String pathurl = "C:\\Users\\mohsassi\\Desktop\\Autoveicoli.csv";
        autoveicoliCSV.importcsv (pathurl);
    }

    @Test
    public void export(){
        autocarriCsvlambda2.export();
    }
    @Test
    public void exportlambda(){
        autocarriCsvlamda.export();

    }
    @Test
    public void exportConcTest(){
        concessionnarioCSV.export();
    }
    @Test
    public void exportAutovTest(){
        autoveicoliCSV.export();
    }
    @Test
    public void exportAutocTest(){

        autocarriCSV.export();
    }
}
