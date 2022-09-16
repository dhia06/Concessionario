package tn.esprit.java.CSVmapper;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.Repository.ConcessionnarioRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConcessionnarioCSV {

    public void export( ) {
        // 1. use a ropository to retrieve data
        ConcessionnarioRepository concRepo = new ConcessionnarioRepository();
        List<Concessionario> listConc = concRepo.getConcessionario();
        // 2. start to write a file
        //2.0 Create a file
        try{
            File myObj = new File("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Concessionario.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            // 2.1 for each autocarro produce a string with field separate
            FileWriter myWriter = new FileWriter("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Concessionario.csv");
            myWriter.write(" Iva " + "," + " Nome " + "," + " Citta " + "," + " Indirizzo" + "\n");
            for (Concessionario conc : listConc) {
                String Iva = String.valueOf(conc.getIva());
                String Citta = conc.getCitta();
                String Indirizzo = conc.getIndirizzo();
                // add a string in a file
                myWriter.write(Iva + "," + Citta + "," + Indirizzo + "\n");
            }
            // add a string in a file
            //close file
            myWriter.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}
