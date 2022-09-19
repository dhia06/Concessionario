package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.CSVmapper.*;

public class CsvTest {

    AutocarriCSV autocarriCSV = new AutocarriCSV();
    AutoveicoliCSV autoveicoliCSV = new AutoveicoliCSV();
    ConcessionnarioCSV concessionnarioCSV = new ConcessionnarioCSV();
AutocarriCsvlamda autocarriCsvlamda = new AutocarriCsvlamda();
AutocarriCsvlambda2 autocarriCsvlambda2 = new AutocarriCsvlambda2();
    @Test
    public void exportAutocTest(){

        autocarriCSV.export();
    }
    @Test
    public void exportAutovTest(){
        autoveicoliCSV.export();
    }
    @Test
    public void exportConcTest(){
        concessionnarioCSV.export();
    }
@Test
    public void exportlambda(){
        autocarriCsvlamda.export();

}
@Test
    public void export(){
        autocarriCsvlambda2.export();
}

}

