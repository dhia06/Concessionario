package tn.esprit.java.Repository;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.PO.ConcessionarioPO;

import java.util.List;

public interface IConcessionnarioRepository {
    public List<Concessionario> getConcessionario();
    public List<Concessionario> getConcessionario(String nome);
    public  void insertConcessionario(Concessionario concessionario);
    public void UpdateConcessionario(Concessionario poc);
    public void DeleteConcessionario(String nome);
    public Concessionario getConcessionarioById(int iva);
    public void deleteConsByid(int Iva);
    public void updateByidd(Concessionario pocc);
}
