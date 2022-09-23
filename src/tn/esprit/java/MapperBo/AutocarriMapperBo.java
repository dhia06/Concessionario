package tn.esprit.java.MapperBo;

import tn.esprit.java.BO.Autocarri;
import tn.esprit.java.PO.AutocarriPO;


public class AutocarriMapperBo  implements IAutocarriMapperBo {

    @Override
    public Autocarri mapp(AutocarriPO autocarriPO) {
        Autocarri auto1 = new Autocarri();

            auto1.setMax_capacity(autocarriPO.getMax_capacity());
            auto1.setMarca(autocarriPO.getMarca());
            auto1.setIva(autocarriPO.getIva());
            auto1.setModello(autocarriPO.getModello());
            auto1.setNbr_telaio(autocarriPO.getNbr_telaio());

        return  auto1;
    }

    @Override
    public AutocarriPO mappinverse(Autocarri autocarri) {
        AutocarriPO auto = new AutocarriPO ();
        auto.setNbr_telaio (autocarri.getNbr_telaio ());
        auto.setMarca (autocarri.getMarca ());
        auto.setModello (autocarri.getModello ());
        auto.setMax_capacity (autocarri.getMax_capacity ());
        return auto;
    }
}
