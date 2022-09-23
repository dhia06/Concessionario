package tn.esprit.java.Mapper;

import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.ConcessionarioPO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcessionarioMapper implements IConcessionarioMapper{
    @Override
    public ConcessionarioPO map(ResultSet resultSet) {
        ConcessionarioPO concessionaria = new ConcessionarioPO();
        try {
            concessionaria.setCitta(resultSet.getString("Citta"));
            concessionaria.setNome(resultSet.getString("Nome"));
            concessionaria.setIva(resultSet.getInt("Iva"));
            concessionaria.setIndirizzo(resultSet.getString("Indirizzo"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  concessionaria;
    }

}
