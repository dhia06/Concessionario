package tn.esprit.java.Mapper;

import tn.esprit.java.PO.AutoveicoloPO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoveicoliMapper implements IAutoveicoliMapper {
    @Override
    public AutoveicoloPO map( ResultSet resultSet ) {
        AutoveicoloPO auto = new AutoveicoloPO();
        try {
            auto.setMarca(resultSet.getString("Marca"));
            auto.setIva(resultSet.getInt("Iva"));
            auto.setModello(resultSet.getString("Modello"));
            auto.setNbr_door(resultSet.getInt("Nbr_door"));
            auto.setNbr_telaio(resultSet.getInt("Nbr_telaio"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auto;
    }

}
