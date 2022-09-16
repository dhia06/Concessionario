package tn.esprit.java.test;

import org.junit.Test;
import tn.esprit.java.CSVmapper.AutocarriCSV;
import tn.esprit.java.CSVmapper.AutoveicoliCSV;
import tn.esprit.java.CSVmapper.ConcessionnarioCSV;

public class CsvTest {

    AutocarriCSV autocarriCSV = new AutocarriCSV();
    AutoveicoliCSV autoveicoliCSV = new AutoveicoliCSV();
    ConcessionnarioCSV concessionnarioCSV = new ConcessionnarioCSV();


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

}
