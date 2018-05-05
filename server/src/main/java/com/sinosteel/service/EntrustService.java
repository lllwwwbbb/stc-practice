package com.sinosteel.service;

import com.sinosteel.domain.Entrust;
import com.sinosteel.repository.EntrustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrustService extends BaseService<Entrust> {

    static Entrust onlyme = new Entrust();
    @Autowired
    private EntrustRepository entrustRepository;

    public Entrust queryEntrusts() {
        return onlyme;
    }

    public void updateEntrusts(String content) throws Exception {
        onlyme.setEntrustString(content);
        entrustRepository.save(onlyme);
    }

    public void checkEntrustsPass() {
        //调用流程引擎
    }

    public void checkEntrustsFail() {
        //调用流程引擎
    }

    public void pushEntrusts(String content) throws Exception
    {
        //调用流程引擎
        updateEntrusts(content);
    }

}
