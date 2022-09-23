package tn.esprit.java.CSVmapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.Repository.AutocarriRepository;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class AutocarriCSV {
    AutocarriRepository autocRepo = new AutocarriRepository();


    public String export() {
        // 1. use a ropository to retrieve data

        List<Autocarri>  listautoc = autocRepo.getAutocarri();
        // 2. start to write a file
        //2.0 Create a file
        try {
            File myObj = new File("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Autocarrii.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            // 2.1 for each autocarro produce a string with field separate ;
               listautoc.forEach( (n) -> {
                String Capacity = String.valueOf(n.getMax_capacity());
                String Marca = n.getMarca();
                String Modello = n.getModello();
                String Iva = String.valueOf(n.getIva());
            } );
            FileWriter myWriter = new FileWriter("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Autocarrii.csv");
            myWriter.write(" Iva "+","+" Marca "+","+" Modello "+","+" MaxCapacity "+","+"Nbr_telaio"+"\n");
            for (Autocarri autocarri : listautoc) {
                String Capacity = String.valueOf(autocarri.getMax_capacity());
                String Marca = autocarri.getMarca();
                String Modello = autocarri.getModello();
                String Iva = String.valueOf(autocarri.getIva());
                String telaio = String.valueOf(autocarri.getNbr_telaio());
                // add a string in a file
                myWriter.write(Iva+","+Marca+","+Modello+","+Capacity +","+telaio+"\n");

            }
            // close file
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    public  boolean importcsv(String pathurl) {
        String line = "";
        String splitBy = ",";
        boolean imported = false;
        try {
            //  1/  parsing a CSV file into BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader (pathurl));
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










