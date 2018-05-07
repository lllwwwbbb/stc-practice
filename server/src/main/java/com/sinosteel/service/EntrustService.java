package com.sinosteel.service;

import com.sinosteel.domain.Entrust;
import com.sinosteel.repository.EntrustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosteel.activiti.ActivitiController;
@Service
public class EntrustService extends BaseService<Entrust> {

    @Autowired
    private EntrustRepository entrustRepository;

    static ActivitiController activitiController = new ActivitiController();

    public Entrust queryEntrusts() {
        Entrust entrust = entrustRepository.findById("1");
        if ( entrust == null) {
            activitiController.startProcess("1");
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

    //委托审核通过
    public void checkEntrustsPass() {
        activitiController.Check(true);
    }

    //委托审核未通过
    public void checkEntrustsFail() {
        activitiController.Check(false);
    }

    public void submitEntrusts(Entrust entrust) throws Exception
    {
        //提交委托
        //调用流程引擎
        activitiController.Submit();
        updateEntrusts(entrust);
    }

}
