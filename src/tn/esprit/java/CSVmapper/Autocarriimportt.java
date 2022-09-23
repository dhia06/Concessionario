package tn.esprit.java.CSVmapper;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.Repository.AutocarriRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Autocarriimportt {
    AutocarriRepository autocRepo = new AutocarriRepository();
    public  boolean importcsv() {
        String line = "";
        String splitBy = ",";
        boolean imported = false;
        try {
            //  1/  parsing a CSV file into BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader ("C:\\Users\\mohsassi\\Desktop\\lambda1.csv"));
            // 2/ logic of reading and send data to DB
            while ((line = br.readLine()) != null)
            {
                //returns a Boolean value
                imported = true;
                //use comma as separator
                String[] autocarri = line.split(splitBy);
                //retrive every cells from the csv file and use it as parameters for insertautocarri method
                Autocarri auto1 = new Autocarri ();
                auto1.setMax_capacity(Integer.parseInt (autocarri[4]));
                auto1.setMarca(autocarri[1]);
                auto1.setIva(Integer.parseInt (autocarri[3]));
                auto1.setModello(autocarri[0]);
                auto1.setNbr_telaio(Integer.parseInt (autocarri[2]));
                System.out.println ("auto1"+auto1);
                autocRepo.insertAutocarri (auto1);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        // 3/ return of boolean
        return imported;
    }
}
