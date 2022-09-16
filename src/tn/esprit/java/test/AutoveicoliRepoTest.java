package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.PO.AutoveicoloPO;
import tn.esprit.java.Repository.AutoveicoliRepository;
import tn.esprit.java.Repository.IAutoveicoliRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AutoveicoliRepoTest {
    public IAutoveicoliRepository repoo = new AutoveicoliRepository();
    List<Autoveicolo> list = new ArrayList<>();
@Test
    public void findAll(){
        int a=0;
        for(Autoveicolo autoveicolo:repoo.getAutoveicolo()){
         /*   System.out.println("Autoveicoli "+a+": [ Marca : " + autoveicolo.getMarca()+
                    " , Modello : "+ autoveicolo.getModello()+ " , IVA :" +autoveicolo.getIva()+" , Nbr doors :"+ autoveicolo.getNbr_door()+ " ]");
            a++;*/
            list.add(autoveicolo);
            System.out.println(autoveicolo);
        }
        assertNotNull(list);
        assertEquals(3, list.size());
    }

    @Test
    public void findByMarca(){
        int b=0;
        for (Autoveicolo auticar : repoo.getbyMarca("peugeot")) {
            System.out.println("Autoveicoli with this Marca "+b+": [ Marca : " + auticar.getMarca() +
                    " , Modello : "+ auticar.getModello()+ " , IVA :" +auticar.getIva()+" , Capacity :"+ auticar.getNbr_door()+ " ]");
            b++;
            assertNotNull(auticar);
            assertEquals("peugeot", auticar.getMarca());
        }
    }
    @Test
    public void findById() {
        repoo.gettAutoByID(39);
        System.out.println("here is "+ repoo.gettAutoByID(39));
        assertNotNull(repoo);
    }

    @Test
    public void insertTest(){
        Autoveicolo jdida = new Autoveicolo("newMarca","ultimo",1,999);
        repoo.insertAutoveicolii(jdida);
        assertNotNull(repoo);
        //aut.insertAutoveicoli("tesla","dhia2022",1996,26);
    }


    @Test
    public void updateAutoveicoliTest(){
        Autoveicolo jdida = new Autoveicolo("newMarca","ultimo",12,999);
        repoo.updateAutoveicoli(jdida);
        assertNotNull(repoo);
    }
    @Test
    public void deleteAutoveicoliTest(){
        Autoveicolo jdida = new Autoveicolo("newMarca","ultimo",12,999);
        repoo.deleteAutoveicoli(jdida);
        assertNotNull(repoo);
    }


}
