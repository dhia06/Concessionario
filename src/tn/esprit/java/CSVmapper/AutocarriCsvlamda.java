package tn.esprit.java.CSVmapper;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.Repository.AutocarriRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AutocarriCsvlamda {
    public void export() {
        // 1. use a ropository to retrieve data
        AutocarriRepository autocRepo = new AutocarriRepository();
        List<Autocarri> listautoc = autocRepo.getAutocarri();
        // 2. start to write a file
        //2.0 Create a file
        try {
            File myObj = new File("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\lambda.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\lambda.csv");
            myWriter.write(" Iva "+","+" Marca "+","+" Modello "+","+" MaxCapacity "+","+"Nbr_telaio"+"\n");
            listautoc.forEach( (n) -> {
                String Capacity = String.valueOf(n.getMax_capacity());
                String Marca = n.getMarca();
                String Modello = n.getModello();
                String Iva = String.valueOf(n.getIva());
                String telaio = String.valueOf(n.getNbr_telaio());
                try{

                    myWriter.write(Iva+","+Marca+","+Modello+","+Capacity +","+telaio+"\n");
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            } );
            // close file
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
