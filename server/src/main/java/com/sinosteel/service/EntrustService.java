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
            entrust.setEntrustString("");
            return entrust;
        }
        return entrust;
    }

    public void updateEntrusts(Entrust entrust) throws Exception {
        entrust.setId("1");
        entrustRepository.save(entrust);
    }

    public void passEntrust()
    {
        activitiController.Check(true);
    }

    public void rejectEntrust()
    {
        activitiController.Check(false);
    }

    public void submitEntrust()
    {
        activitiController.Submit();
    }

    public String getEntrustState()
    {
        return activitiController.GetProcessState();
    }

}
