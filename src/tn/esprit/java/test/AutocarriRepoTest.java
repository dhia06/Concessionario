package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.Repository.AutocarriRepository;
import tn.esprit.java.Repository.IAutocarriRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AutocarriRepoTest {
    IAutocarriRepository autorepo = new AutocarriRepository();
    List<Autocarri> list = new ArrayList<>();


    @Test
    public void getAllTest( ) {
        int i = 0;
        for (Autocarri autocarri : autorepo.getAutocarri()) {
          /*  System.out.println("Autocarri " + i + ": [ Marca : " + ss.getMarca() +
                    " , Modello : " + ss.getModello() + " , IVA :" + ss.getIva() + " , Capacity :" + ss.getMax_capacity() + " ]");
            i++;*/
            list.add(autocarri);
            System.out.println(autocarri);
        }
        assertNotNull(autorepo);
        assertEquals(4, list.size());
    }

    @Test
    public void testgetbyID( ) {
        System.out.println("--------");
        int k = 0;
        Autocarri autocarr = autorepo.findAutoByid(88);

        System.out.println("Autocarri with this ID " + k + ": [ Marca : " + autocarr.getMarca() +
                " , Modello : " + autocarr.getModello() + " Telaio_nbr : " + autocarr.getNbr_telaio() + " , IVA :" + autocarr.getIva() + " , Capacity :" + autocarr.getMax_capacity() + " ]");


        assertNotNull(autocarr);
        assertEquals("smartcar", autocarr.getMarca());
        assertEquals(88, autocarr.getNbr_telaio());


    }

    @Test
    public void testgetByMarca( ) {
        int j = 0;
        for (Autocarri autocarr : autorepo.finfByMArca("ford")) {
            System.out.println("Autocarri with this Marca " + j + ": [ Marca : " + autocarr.getMarca() +
                    " , Modello : " + autocarr.getModello() + " , IVA :" + autocarr.getIva() + " , Capacity :" + autocarr.getMax_capacity() + " ]");
            j++;

            assertNotNull(autocarr);
            assertEquals("ford", autocarr.getMarca());
        }

    }
    @Test
    public void testByIva(){
        int j=0;
        for (Autocarri autocarri: autorepo.findByIva(1)){
            System.out.println("The list of autocarri for this Concessionnairio is "+j+": [ Marca : " + autocarri.getMarca()+
                    " , Modello: "+autocarri.getModello()+" ,Max Capacity: "+autocarri.getMax_capacity()+"]");
            j++;
            //System.out.println(+autoDao.findAutoByid(1));
        }
    }

    @Test
    public void insertAutocarriTest( ) {
        Autocarri au = new Autocarri("ss", "2020", 1, 77);
        autorepo.insertAutocarri(au);
        // autoDao.insertAutocarri("volvo","dhia2022",1996,26);
        assertNotNull(autorepo);
    }

    @Test
    public void updateAutocarriTest( ) {
        Autocarri au = new Autocarri("ford", "2020", 74, 77);
        autorepo.updateAutocarri(au);
        assertNotNull(autorepo);
    }

    @Test
    public void deleteAutocarriTest( ) {
        Autocarri au = new Autocarri("ford", "2020", 74, 77);
        autorepo.deleteAutocarri(au);
        assertNotNull(autorepo);
    }


}
