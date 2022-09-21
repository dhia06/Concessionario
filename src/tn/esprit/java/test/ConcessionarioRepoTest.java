package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;

import tn.esprit.java.BO.Veicolo;
import tn.esprit.java.Repository.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConcessionarioRepoTest {
    public IConcessionnarioRepository ConRepo = new ConcessionnarioRepository();
    public IAutocarriRepository autocRepo = new AutocarriRepository();
    public IAutoveicoliRepository autovRepo = new AutoveicoliRepository();
    public AutocarriRepository autocarriRepository ;
    List<Concessionario> list = new ArrayList<>();

    public ConcessionarioRepoTest() {

        this.autocarriRepository = autocarriRepository;

    }

    @Test
    public void getConcessionarioTest(){


        for (Concessionario cond : ConRepo.getConcessionario()) {

            list.add(cond);
        }
        assertNotNull(ConRepo);
        assertEquals(4, list.size());
    }
    @Test
    public void getConcessionarNameTest(){

        System.out.println("--------");
        int o=0;
        for (Concessionario cond : ConRepo.getConcessionario("Med")) {
            System.out.println("Concessionario/a with this Name "+o+": [ Citta : " + cond.getCitta()  +
                    " , Iva : "+ cond.getIva()+" , list : "+ " , Indirizzo :" +cond.getIndirizzo()+ ", ]");
            o++;
            assertNotNull(cond);
            assertEquals("Med", cond.getNome());
        }


    }
    @Test
    public void insertConcessionarioTest(){

        List<Veicolo> listcars = new ArrayList<> ();
        Autocarri autoc = new Autocarri(1,"ferrari1", "f19", 1, 13);
        Autoveicolo autov = new Autoveicolo(1,"ferrari1","serie 1",1,7);
        listcars.add (autoc);
        System.out.println ("lllllll"+autoc);
        System.out.println (listcars);
        listcars.add (autov);
        System.out.println ("5"+listcars);
        Concessionario concessionario = new Concessionario(1,"test","como","avenue  Dolce");
        ConRepo.insertConcessionario(concessionario);
        /* autocRepo.insertAutocarri(autoc);
        autovRepo.insertAutoveicolii(autov);*/
        assertNotNull(ConRepo);
    }
    @Test
    public void updateConcessionarioTest(){

        Concessionario cc = new Concessionario(12,"Ale","Paris","avenue Cherles Digole");
        ConRepo.UpdateConcessionario(cc);
        List<Concessionario> listConct = ConRepo.getConcessionario("Ale");
        for (Concessionario con :listConct){
            assertEquals("Paris",con.getCitta());
        }

        assertNotNull(ConRepo);
    }
    @Test
    public void deleteConcessionario(){
        ConRepo.DeleteConcessionario("sassi");
        assertNotNull(ConRepo);
    }
    @Test
    public void getconcById(){
        Concessionario conn= ConRepo.getConcessionarioById(2);

        assertEquals("Dhia",conn.getNome());
       // assertEquals("rome",conn.getCitta());


       // assertNotNull(conn);



    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
