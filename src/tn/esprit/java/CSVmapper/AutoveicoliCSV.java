package tn.esprit.java.CSVmapper;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.Repository.AutoveicoliRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AutoveicoliCSV {
    public void export(){
        // 1. use a ropository to retrieve data
        AutoveicoliRepository autovRepo = new AutoveicoliRepository();
        List<Autoveicolo> listautov = autovRepo.getAutoveicolo();
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
}
