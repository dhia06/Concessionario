package tn.esprit.java.test;
import log4j.Testlog;
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
        Concessionario newConc = new Concessionario ();
        newConc = this.concessionnarioRepository.getConcessionarioById (1);
        System.out.println ("resultfindone"+newConc);
        if (newConc.getIva () == 0){
            logger.info ("Inserting New Concessionario in pregress");
            List<Veicolo> listcars = new ArrayList<> ();
            Autocarri autoc = new Autocarri (1,"marca","modello",1,4);
            Autoveicolo autov = new Autoveicolo(1,"ferrari1","serie 1",1,7);
            listcars.add (autoc);
            listcars.add (autov);
            Concessionario concessionario = new Concessionario(1,"dhia","como","avenue  Dolce",listcars);
            ConRepo.insertConcessionario(concessionario);}
            else{
            logger.info ("Concessionario Already Exist,Inserting Veicoli");
            AutocarriRepository autocarriRepository = new AutocarriRepository ();
            AutoveicoliRepository autoveicoliRepository = new AutoveicoliRepository ();
            Autocarri autoc = new Autocarri (2,"marca2","modello",1,4);
            Autoveicolo autov = new Autoveicolo(2,"ferrari2","serie 1",1,7);
            autocarriRepository.insertAutocarri (autoc);
            autoveicoliRepository.insertAutoveicolii (autov);

            }

        assertNotNull(ConRepo);
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
