package tn.esprit.java.CSVmapper;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.Repository.AutoveicoliRepository;

import java.io.*;
import java.util.List;

public class AutoveicoliCSV {
    AutoveicoliRepository autoveicoliRepository = new AutoveicoliRepository ();
    public void export(){
        // 1. use a ropository to retrieve data

        List<Autoveicolo> listautov = autoveicoliRepository.getAutoveicolo();
        System.out.println("tostringtest"+listautov);
        // 2. start to write a file
        //2.0 Create a file
        try {
            File myObj = new File("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Autoveicoli.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            // 2.1 for each autocarro produce a string with field separate
        FileWriter myWriter = new FileWriter("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Autoveicoli.csv");
        myWriter.write(" Iva "+","+" Marca "+","+" Modello "+","+" NbrOfDoors "+","+"Nbr_telaio"+"\n");
        for (Autoveicolo autov : listautov) {
            String NbrOfDoors = String.valueOf(autov.getNbr_door());
            String Marca = autov.getMarca();
            String Modello = autov.getModello();
            String Iva = String.valueOf(autov.getIva());
            String telaio = String.valueOf(autov.getNbr_telaio());
            // add a string in a file
            myWriter.write(Iva+","+Marca+","+Modello+","+NbrOfDoors +","+telaio+"\n");
        }
        // add a string in a file
        //close file
        myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public  boolean importcsv( String pathurl) {
        String line = "";
        String splitBy = ",";

        boolean imported = false;
        try {
            //   1/  parsing a CSV file into BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader (pathurl));

            // 2/ logic of reading and send data to DB
            while ((line = br.readLine()) != null)
            {
                //returns a Boolean value
                imported = true;
                //use comma as separator
                String[] autocarri = line.split(splitBy);
                //retrive every cells from the csv file and use it as parameters for insertautocarri method
                Autoveicolo autov = new Autoveicolo ();
                autov.setIva (Integer.parseInt (autocarri[0]));
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
