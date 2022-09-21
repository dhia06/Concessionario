package tn.esprit.java.CSVmapper;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.Repository.AutocarriRepository;
import tn.esprit.java.Repository.AutoveicoliRepository;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class Autoveicoliimport  {


   AutoveicoliRepository autoveicoliRepository = new AutoveicoliRepository ();
    public  boolean importcsv() {
        String line = "";
        String splitBy = ",";
        boolean imported = false;
        try {
            //  1/  parsing a CSV file into BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mohsassi\\Desktop\\Autoveicoli.csv"));
            // 2/ logic of reading and send data to DB
            while ((line = br.readLine()) != null)
            {
                //returns a Boolean value
                imported = true;
                //use comma as separator
                String[] autocarri = line.split(splitBy);
                //retrive every cells from the csv file and use it as parameters for insertautocarri method
                Autoveicolo autov = new Autoveicolo ();
                autov.setIva (Long.parseLong (autocarri[0]));
                autov.setMarca (autocarri[1]);
                autov.setModello (autocarri[2]);
                autov.setNbr_door (Integer.parseInt (autocarri[3]));
                autov.setNbr_telaio(Integer.parseInt (autocarri[4]));
                System.out.println ("autov"+autov);
                autoveicoliRepository.insertAutoveicolii (autov);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        // 3/ return of boolean
        return imported;
    }
}

