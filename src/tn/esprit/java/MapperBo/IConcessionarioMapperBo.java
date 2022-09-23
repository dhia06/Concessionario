package tn.esprit.java.MapperBo;

import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.PO.ConcessionarioPO;

public interface IConcessionarioMapperBo {
    public Concessionario mapp(ConcessionarioPO concessionarioPO);
    public ConcessionarioPO mapinverse(Concessionario concessionario);
}
