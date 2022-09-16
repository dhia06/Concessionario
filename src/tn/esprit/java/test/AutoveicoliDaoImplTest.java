package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.DAO.AutoveicoliDaoImpl;
import tn.esprit.java.DAO.AutoveicoloDao;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.AutoveicoloPO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AutoveicoliDaoImplTest {
    AutoveicoloDao aut = new AutoveicoliDaoImpl();
    List<AutoveicoloPO> auto = new ArrayList<>();
    @Test


    public void findAll(){
        int a=0;
        for(AutoveicoloPO autoveicolo:aut.getAutoveicolo()){
            System.out.println("Autoveicoli "+a+": [ Marca : " + autoveicolo.getMarca()+
                    " , Modello : "+ autoveicolo.getModello()+ " , IVA :" +autoveicolo.getIva()+" , Nbr doors :"+ autoveicolo.getNbr_door()+ ", Nbrteleio :"+autoveicolo.getNbr_telaio()+" ]");
            a++;
            auto.add(autoveicolo);
            System.out.println("wiiw"+autoveicolo);
        }
        assertNotNull(auto);
        assertEquals(112, auto.size());
    }
    @Test
    public void findByMarca(){
        int b=0;
        for (AutoveicoloPO auticar : aut.getbyMarca("peugeot")) {
            System.out.println("Autoveicoli with this Marca "+b+": [ Marca : " + auticar.getMarca() +
                    " , Modello : "+ auticar.getModello()+ " , IVA :" +auticar.getIva()+" , Capacity :"+ auticar.getNbr_door()+ " ]");
            b++;

            assertNotNull(auticar);
            assertEquals("peugeot", auticar.getMarca());
        }
    }
    @Test
    public void findById() {
        aut.getAutoByID(39);
        System.out.println("here is "+ aut.getAutoByID(39));
    }
    @Test
    public void insertTest(){
        aut.insertAutoveicoli("peugeot","308",3,4);
        aut.insertAutoveicoli("tesla","dhia2022",3,26);
    }
    @Test
    public void updateAutoveicoliTest(){
        aut.updateAutoveicoli("mercedes","Gle",210,240);
        assertNotNull(aut);
    }
    @Test
    public void deleteAutoveicoliTest(){
       aut.deleteAutoveicoli("ford");
        assertNotNull(aut);
   }
    @Test
    public void testByIva(){
        int j=0;
        for (AutoveicoloPO autoveicoloPO: aut.findbyIva(1)){
            System.out.println("The list of autocarri for this Concessionnairio is "+j+": [ Marca : " + autoveicoloPO.getMarca()+
                    " , Modello: "+autoveicoloPO.getModello()+" ,Nbr of doors: "+autoveicoloPO.getNbr_door()+"]");
            j++;
            //System.out.println(+autoDao.findAutoByid(1));
        }
    }
}
