package tn.esprit.java.DAO;

import tn.esprit.java.PO.ConcessionarioPO;
import tn.esprit.java.PO.VeicoloPO;

import java.util.List;

public interface ConcessionarioDao {
    public List<ConcessionarioPO> getConcessionario();
    public List<ConcessionarioPO> getConcessionario(String nome);
    public  void insertConcessionario(int iva,String nome,  String citta, String indirizzo);
    public void updateConcessionario(String citta,String indirizzo,String nome);
    public void deleteConcessionario(String nome);
    public ConcessionarioPO getConcessionarioById(int iva);
    public void deleteConsByid(int Iva);
    public void updateByid(String nome,String citta , String indirizzo);





}