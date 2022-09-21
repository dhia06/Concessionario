import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.Repository.AutocarriRepository;
import tn.esprit.java.test.AutocarriDaoImplTest;
import tn.esprit.java.test.AutoveicoliDaoImplTest;
import tn.esprit.java.test.ConcessionarioDaoImplTest;

import java.io.FileNotFoundException;


public class Client {
    public static void main(String[] args) throws FileNotFoundException {
    /*    AutocarriRepository autocarriRepository= new AutocarriRepository();
        System.out.println("test");
        AutocarriPO oo =new AutocarriPO(231,"dhia","5",555,5);
        autocarriRepository.insertAutocarri("fer","fer1",7,78);
        System.out.println("fin test");*/
        //////
       // AutocarriDao autoDao = new AutocarriDaoImpl();
       // AutoveicoloDao aut = new AutoveicoliDaoImpl();
        ConcessionarioDaoImplTest concessionarioDaoImplTest = new ConcessionarioDaoImplTest();
        AutocarriDaoImplTest autocarriDaoImplTest = new AutocarriDaoImplTest();
        AutoveicoliDaoImplTest autoveicoliDaoImplTest = new AutoveicoliDaoImplTest();
        //GET ALL AUTOCARRI
        autocarriDaoImplTest.testRetrieveAllUsers();


        System.out.println("--------");
         //GET BY ID
        System.out.println("--------");
        autocarriDaoImplTest.testgetbyID();
        System.out.println("--------");


        //GET BY MARCA
        System.out.println("--------");
        autocarriDaoImplTest.testgetByMarca();
        System.out.println("--------");

       //INSERT AUTOCARRI
        System.out.println("INSERTING NEW AUTOCARRI");
       autocarriDaoImplTest.insertAutocarriTest();
        System.out.println("--------");


        //UPDATE AUTOCARRI
        System.out.println("UPDATING AUTOCARRI");
       autocarriDaoImplTest.updateAutocarriTest();
        System.out.println("--------");

        //DELETE AUTOCARRI
        System.out.println("Deleting AUTOCARRI");
        autocarriDaoImplTest.deleteAutocarriTest();
        System.out.println("--------");
        System.out.println("***********************************************************************");

        //GET ALL AUTOVEICOLI
        System.out.println("--------");
        System.out.println("THIS IS THE LIST OF AUTOVEICOLI");
        autoveicoliDaoImplTest.findAll();

        System.out.println("--------");
        //GET AUTOVEICOLI BY MARCA
        System.out.println("--------");
       autoveicoliDaoImplTest.findByMarca();
        System.out.println("--------");
        //GET AUTOVEICOLO BY ID
        System.out.println("--------");
       autoveicoliDaoImplTest.findById();
        System.out.println("--------");


        //INSERT AUTOVEICOLO
        System.out.println("INSERTING NEW AUTOVEICOLO");
        autoveicoliDaoImplTest.insertTest();
        System.out.println("--------");
         //UPDATE AUTOVEICOLO
        System.out.println("UPDATING AUTOVEICOLO");
       autoveicoliDaoImplTest.updateAutoveicoliTest();
        System.out.println("--------");
        //DELETE AUTOVEICOLO
        System.out.println("Deleting Autoveicoli");
       autoveicoliDaoImplTest.deleteAutoveicoliTest();
        System.out.println("--------" );
        System.out.println("*******************************");
        //GET ALL Concessionari
        System.out.println("--------");
        concessionarioDaoImplTest.getConcessionarioTest();
        System.out.println("THIS IS THE LIST OF Concessionari");

        System.out.println("--------");
        //GET BY Name
        concessionarioDaoImplTest.getConcessionarNameTest();
        System.out.println("--------");
        //INSERT Concessionario
        System.out.println("INSERTING NEW Concessionario");
        concessionarioDaoImplTest.insertConcessionarioTest();
        System.out.println("--------");
        //UPDATE Concessionario
        System.out.println("UPDATING Concessionario");
        concessionarioDaoImplTest.updateConcessionarioTest();
        System.out.println("--------");
        //DELETE Concessionario
        System.out.println("Deleting Concessionario");
       concessionarioDaoImplTest.deleteConcessionario();
        System.out.println("--------" );


        AutocarriRepository r = new AutocarriRepository();


    }




}







