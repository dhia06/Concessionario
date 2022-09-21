package tn.esprit.java.CSVmapper;

import org.dom4j.rule.Mode;
import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.Repository.AutocarriRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AutocarriCsvlambda2 {
    public void export() {
        // 1. use a ropository to retrieve data
        AutocarriRepository autocRepo = new AutocarriRepository();
        List<Autocarri> listautoc = autocRepo.getAutocarri();
        // 2. start to write a file
        //2.0 Create a file
        try {
            File myObj = new File("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\lambda1.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
           FileWriter myWriter = new FileWriter("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\lambda1.csv");
            // 2.1 for each autocarro produce a string with field separate ;
            String modello = listautoc.stream()
                    .map(p -> p.getModello()+","+p.getMarca()+","+p.getNbr_telaio()+","+p.getIva()+","+p.getMax_capacity()+"\n").collect(Collectors.joining("", "", ""));
            System.out.println("Modello "+modello);

            myWriter.write(" Modello "+","+" Marca "+","+" Nbr_telaio "+","+" Iva "+","+"Max_capacity"+"\n");
            myWriter.write(modello);
                    // close file
                    myWriter.close();



        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
