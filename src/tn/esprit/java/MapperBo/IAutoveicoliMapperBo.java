package tn.esprit.java.MapperBo;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.PO.AutoveicoloPO;

public interface IAutoveicoliMapperBo {
    public Autoveicolo mapp(AutoveicoloPO autoveicoloPO);
    public AutoveicoloPO mapinverse(Autoveicolo autoveicolo);
}
