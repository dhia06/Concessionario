package tn.esprit.java.CSVmapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.Repository.AutocarriRepository;


public class AutocarriCSV {



    public void export() {
        // 1. use a ropository to retrieve data
        AutocarriRepository autocRepo = new AutocarriRepository();
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
    }
}










