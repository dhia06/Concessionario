package tn.esprit.java.Mapper;

import com.mysql.cj.protocol.Resultset;
import tn.esprit.java.PO.AutocarriPO;
import java.sql.ResultSet;
import java.sql.*;

public class AutocarriMapper implements IAutocarriMapper {

    @Override
    public AutocarriPO map(ResultSet resultSet) {

            AutocarriPO auto1 = new AutocarriPO();
        try {
            auto1.setMax_capacity(resultSet.getInt("Max_capacity"));
            auto1.setMarca(resultSet.getString("Marca"));
            auto1.setIva(resultSet.getInt("Iva"));
            auto1.setModello(resultSet.getString("Modello"));
            auto1.setNbr_telaio(resultSet.getInt("Nbr_telaio"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  auto1;
    }



}