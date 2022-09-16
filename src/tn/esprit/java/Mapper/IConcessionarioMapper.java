package tn.esprit.java.Mapper;

import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.ConcessionarioPO;

import java.sql.ResultSet;

public interface IConcessionarioMapper {
    public ConcessionarioPO map(ResultSet resultset);
}
