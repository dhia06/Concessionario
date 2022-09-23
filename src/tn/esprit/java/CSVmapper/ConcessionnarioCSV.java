package tn.esprit.java.CSVmapper;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.Repository.ConcessionnarioRepository;

import java.io.*;
import java.util.List;

public class ConcessionnarioCSV {
    ConcessionnarioRepository concessionnarioRepository = new ConcessionnarioRepository ();

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
                String[] concessionario = line.split(splitBy);
                //retrive every cells from the csv file and use it as parameters for insertConcessionario method
                Concessionario conc = new Concessionario ();

                conc.setIva (Integer.parseInt (concessionario[0]));
                conc.setNome (concessionario[1]);
                conc.setCitta (concessionario[2]);
                conc.setIndirizzo ( (concessionario[3]));
               // conc.setListcars ( (concessionario[4]));
                System.out.println ("autov"+conc);
                concessionnarioRepository.insertConc (conc);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        // 3/ return of boolean
        return imported;
    }

}
