package tn.esprit.java.CSVmapper;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.Repository.AutocarriRepository;
import tn.esprit.java.Repository.AutoveicoliRepository;
import tn.esprit.java.Repository.ConcessionnarioRepository;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ConcessionnarioCSV {
    ConcessionnarioRepository concessionnarioRepository = new ConcessionnarioRepository ();
    AutocarriRepository autocarriRepository = new AutocarriRepository ();
    AutoveicoliRepository autoveicoliRepository = new AutoveicoliRepository ();

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
            // 2.1 for each Concessionario produce a string with field separate
            FileWriter myWriter = new FileWriter("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\Concessionario.csv");
            myWriter.write(" Iva " + "," + " Nome " + "," + " Citta " + "," + " Indirizzo" + "," + "Listcars"+ "\n");
            for (Concessionario conc : listConc) {
                String Iva = String.valueOf(conc.getIva());
                String Citta = conc.getCitta();
                String Indirizzo = conc.getIndirizzo();
                String Listcars = String.valueOf (conc.getListcars ());
                // add a string in a file
                myWriter.write(Iva + "," + Citta + "," + Indirizzo + ","+ Listcars+"\n");
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
        String split = "/";

        boolean imported = false;
        try {
            //   1/  parsing a CSV file into BufferedReader class
            BufferedReader br = new BufferedReader(new FileReader (pathurl));
            // 2/ logic of reading and send data to DB
            //retrive every cells from the csv file and use it as parameters for insertConcessionario method
            while ((line = br.readLine ()) != null) {
                //use comma as separator
                String [] concessionario = line.split(splitBy);
                    Concessionario conc = new Concessionario ();
                    conc.setIva (Integer.parseInt (concessionario[0]));
                    conc.setNome (concessionario[1]);
                    conc.setCitta (concessionario[2]);
                    conc.setIndirizzo ( (concessionario[3]));
                    concessionnarioRepository.insertConc (conc);
                    Autocarri autoc = new Autocarri ();
                    autoc.setNbr_telaio (Integer.parseInt (concessionario[4]));
                    autoc.setMarca (concessionario[5]);
                    autoc.setModello (concessionario[6]);
                    autoc.setIva (Integer.parseInt (concessionario[7]));
                    autoc.setMax_capacity (Integer.parseInt ((concessionario[8])));
                    autocarriRepository.insertAutocarri (autoc);
                    Autoveicolo autov = new Autoveicolo ();
                    autov.setNbr_telaio (Integer.parseInt (concessionario[9]));
                    autov.setMarca (concessionario[10]);
                    autov.setModello (concessionario[11]);
                    autov.setIva (Integer.parseInt (concessionario[12]));
                    autov.setNbr_door (Integer.parseInt (concessionario[13]));
                    autoveicoliRepository.insertAutoveicolii (autov);
                    //returns a Boolean value
                    imported = true;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        // 3/ return of boolean
        return imported;
    }

}
