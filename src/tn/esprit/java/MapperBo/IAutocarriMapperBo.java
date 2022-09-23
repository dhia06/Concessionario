package tn.esprit.java.MapperBo;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.PO.AutocarriPO;

public interface IAutocarriMapperBo {
    public Autocarri mapp(AutocarriPO autocarriPO);
    public AutocarriPO mappinverse(Autocarri autocarri);
}


