package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.DAO.ConcessionarioDao;
import tn.esprit.java.DAO.ConcessionarioImp;
import tn.esprit.java.PO.ConcessionarioPO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConcessionarioDaoImplTest {
    ConcessionarioDao ConDao = new ConcessionarioImp();
    List <ConcessionarioPO> conc = new ArrayList<>();
    @Test
    public void getConcessionarioTest(){

        int p=0;
        for (ConcessionarioPO cond :ConDao.getConcessionario()) {
            conc.add(cond);
        }
        System.out.println(conc);
        assertNotNull(conc);
        assertEquals(6, conc.size());
    }
    @Test
public void getConcessionarNameTest(){

    System.out.println("--------");
    int o=0;
    for (ConcessionarioPO cond : ConDao.getConcessionario("Ale")) {
        System.out.println("Concessionario/a with this Name "+o+": [ Citta : " + cond.getCitta()  +
                " , Iva : "+ cond.getIva()+ " , Indirizzo :" +cond.getIndirizzo()+ ", ]");
        o++;
        assertNotNull(cond);
        assertEquals("Ale", cond.getNome());
    }


}
@Test
    public void insertConcessionarioTest(){


        ConDao.insertConcessionario(1,"Andrea","bologne","lambardia");
    assertNotNull(ConDao);
    }
    @Test
public void updateConcessionarioTest(){


    ConDao.updateConcessionario("Ferrar","Torrino","Ale");
    List<ConcessionarioPO> listConct = ConDao.getConcessionario("Ale");
    for (ConcessionarioPO con :listConct){
        assertEquals("Torrino",con.getCitta());
    }

        assertNotNull(ConDao);
}
@Test
public void deleteConcessionario(){


    ConDao.deleteConcessionario("Ale");
    assertNotNull(ConDao);
}
@Test

public void getconcById(){
     ConcessionarioPO conn=ConDao.getConcessionarioById(1);

    System.out.println("The Concessionario is : "+conn);
      assertEquals("dhia",conn.getNome());
      assertEquals("rome",conn.getCitta());


    assertNotNull(conn);



}




}
