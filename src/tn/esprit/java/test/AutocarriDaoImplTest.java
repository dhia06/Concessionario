package tn.esprit.java.test;

import com.mysql.cj.jdbc.Blob;
import org.junit.Test;
import org.junit.runner.RunWith;
import tn.esprit.java.DAO.AutocarriDao;
import tn.esprit.java.DAO.AutocarriDaoImpl;
import tn.esprit.java.PO.AutocarriPO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class AutocarriDaoImplTest {
   AutocarriDao autoDao = new AutocarriDaoImpl();
    List<AutocarriPO> autocarri = new ArrayList<>();
@Test
    public void testRetrieveAllUsers() {

        int i=0;
        for (AutocarriPO autocarr : autoDao.getAutocarri()) {
           /* System.out.println("Autocarri "+i+": [ Marca : " + autocarr.getMarca() +
                    " , Modello : "+ autocarr.getModello()+ " , IVA :" +autocarr.getIva()+" , Capacity :"+ autocarr.getMax_capacity()+ " ]");
            i++;*/
            autocarri.add(autocarr);
            System.out.println(autocarr);
        }
         assertNotNull(autoDao);
         assertEquals(4, autocarri.size());


    }
    @Test
    public void testgetbyID() {
        System.out.println("--------");
        int k=0;
        AutocarriPO autocarr= autoDao.findAutoByid(88);

            System.out.println("Autocarri with this ID "+k+": [ Marca : " + autocarr.getMarca() +
                    " , Modello : "+ autocarr.getModello()+ " Telaio_nbr : "+autocarr.getNbr_telaio()+ " , IVA :" +autocarr.getIva()+" , Capacity :"+ autocarr.getMax_capacity()+ " ]");


            assertNotNull(autocarr);
            assertEquals("smartcar", autocarr.getMarca());
            assertEquals(88, autocarr.getNbr_telaio());


    }
    @Test
    public void testgetByMarca(){
        int j=0;
        for (AutocarriPO autocarr : autoDao.finfByMArca("ford")) {
            System.out.println("Autocarri with this Marca "+j+": [ Marca : " + autocarr.getMarca() +
                    " , Modello : "+ autocarr.getModello()+ " , IVA :" +autocarr.getIva()+" , Capacity :"+ autocarr.getMax_capacity()+ " ]");
            j++;

            assertNotNull(autocarr);
            assertEquals("ford", autocarr.getMarca());
        }

    }
    @Test
    public void testByIva(){
    int j=0;
    for (AutocarriPO autocarriPO: autoDao.findByIva(1)){
        System.out.println("The list of autocarri for this Concessionnairio is "+j+": [ Marca : " + autocarriPO.getMarca()+
                " , Modello: "+autocarriPO.getModello()+" ,Max Capacity: "+autocarriPO.getMax_capacity()+"]");
        j++;
        //System.out.println(+autoDao.findAutoByid(1));
    }
    }
    @Test
    public void insertAutocarriTest() throws FileNotFoundException {
        InputStream im = new FileInputStream ("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\pic\\1.jpg");
        Blob dhia = null;
        autoDao.insertAutocarri(1,"ford","fiesta",2,3,dhia);
        autoDao.insertAutocarri(1,"bmw","E280",2,26,dhia);
        assertNotNull(autoDao);
}
@Test
public void updateAutocarriTest(){
    autoDao.updateAutocarri("alpha Romeo","400cc",20,20);
    assertNotNull(autoDao);
}
@Test
public void deleteAutocarriTest(){
    autoDao.deleteAutocarri("tesla");
    assertNotNull(autocarri);
}

}
