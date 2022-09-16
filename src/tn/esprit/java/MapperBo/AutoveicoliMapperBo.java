package tn.esprit.java.MapperBo;

import tn.esprit.java.BO.Autoveicolo;
import tn.esprit.java.PO.AutoveicoloPO;

public class AutoveicoliMapperBo implements IAutoveicoliMapperBo {
    @Override
    public Autoveicolo mapp(AutoveicoloPO autoveicoloPO) {
        Autoveicolo autoveicolo = new Autoveicolo();

            autoveicolo.setMarca(autoveicoloPO.getMarca());
            autoveicolo.setIva(autoveicoloPO.getIva());
            autoveicolo.setModello(autoveicoloPO.getModello());
            autoveicolo.setNbr_door(autoveicoloPO.getNbr_door());
            autoveicolo.setNbr_telaio(autoveicoloPO.getNbr_telaio());

        return autoveicolo;
    }
}
