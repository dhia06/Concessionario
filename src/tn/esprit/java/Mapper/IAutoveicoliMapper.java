package tn.esprit.java.Mapper;

import tn.esprit.java.PO.AutoveicoloPO;
import tn.esprit.java.PO.ConcessionarioPO;

import java.sql.ResultSet;

public interface IAutoveicoliMapper {
    public AutoveicoloPO map(ResultSet resultset);

}
