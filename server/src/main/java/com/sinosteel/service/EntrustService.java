package com.sinosteel.service;

import com.sinosteel.domain.Entrust;
import com.sinosteel.repository.EntrustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrustService extends BaseService<Entrust> {

    @Autowired
    private EntrustRepository entrustRepository;

    public Entrust queryEntrusts() {
        Entrust entrust = entrustRepository.findById("1");
        if ( entrust == null) {
            entrust = new Entrust();
            entrust.setId("1");
            return entrust;
        }
        return entrust;
    }

    public void updateEntrusts(Entrust entrust) throws Exception {
        entrust.setId("1");
        entrustRepository.save(entrust);
    }

    public void checkEntrustsPass() {
        //调用流程引擎
    }

    public void checkEntrustsFail() {
        //调用流程引擎
    }

    public void pushEntrusts(Entrust entrust) throws Exception
    {
        //调用流程引擎
        updateEntrusts(entrust);
    }

}
