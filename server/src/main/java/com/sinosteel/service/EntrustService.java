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

    private static ActivitiController activitiController = new ActivitiController();

    //为了使每次初始化时一个新的委托，暂时添加一个bool变量
    private boolean isInitial = true;

    public Entrust queryEntrusts() {

        if (isInitial)
        {
            isInitial = false;
            //第一次访问时,初始化引擎
            activitiController.deploy();
            activitiController.startProcess("entrust");
            //新建一个委托并存入数据库中
            Entrust entrust = new Entrust();
            entrust.setId("1");
            entrust.setEntrustString("");
            entrustRepository.save(entrust);
        }


        return entrustRepository.findById("1");
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
