package tn.esprit.java.Mapper;

import com.mysql.cj.protocol.Resultset;
import tn.esprit.java.PO.AutocarriPO;

import java.sql.ResultSet;


public interface IAutocarriMapper {
    public AutocarriPO map(ResultSet resultset);
}
