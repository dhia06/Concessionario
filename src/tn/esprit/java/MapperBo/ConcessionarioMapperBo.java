package tn.esprit.java.MapperBo;

import tn.esprit.java.BO.Concessionario;
import tn.esprit.java.PO.ConcessionarioPO;

public class ConcessionarioMapperBo implements IConcessionarioMapperBo {

    @Override
    public Concessionario mapp( ConcessionarioPO concessionarioPO ) {
        Concessionario concessionario = new Concessionario();

            concessionario.setCitta(concessionarioPO.getCitta());
            concessionario.setNome(concessionarioPO.getNome());
            concessionario.setIva(concessionarioPO.getIva());
            concessionario.setIndirizzo(concessionarioPO.getIndirizzo());
           // concessionario.setVeicolilist(concessionarioPO.getVeicolilist());
      //  concessionario.setListcars(concessionarioPO.);

            return concessionario;
    }
}
