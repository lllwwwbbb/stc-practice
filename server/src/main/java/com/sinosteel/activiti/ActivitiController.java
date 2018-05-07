package com.sinosteel.activiti;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitiController {
    private static final Logger logger = LoggerFactory.getLogger(com.sinosteel.activiti.ActivitiController.class);

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    private HistoryService historyService;
    ProcessEngine processEngine;
    RepositoryService repositoryService;
    String ProcessInstanceId;
    //deploy the dpmn
    public void deploy() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
        repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .addClasspathResource("processes/entrust.bpmn20.xml")
                .deploy();
        System.out.println("deploy success, processEngine name: " + processEngine.getName());
    }

    //流程引擎启动
    public void startProcess(String id){
        ProcessInstance pi=processEngine.getRuntimeService().startProcessInstanceByKey(id);
       ProcessInstanceId = new String(pi.getProcessInstanceId());
     //   System.out.println("pid:"+pi.getId()+",activitiId:"+pi.getActivityId()+" "+pi.getProcessInstanceId());
    }
    //查询任务
   public String GetTaskState(String name)
    {
        List<Task> tasks=processEngine.getTaskService()
                .createTaskQuery().taskAssignee(name).list();
        String st = new String();
        for (Task task : tasks) {
            st+=new String(task.getId() + " " + task.getName() + " " + task.getAssignee()+"\n");
        }
        return st;
    }
    //查询流程
    public String GetProcessState()
    {
        ProcessInstance pi=processEngine.getRuntimeService().createProcessInstanceQuery()
                .processInstanceId(ProcessInstanceId).singleResult();
        if(pi!=null)
        {
            return "running";//pi.getActivityId();
        }
        else return "finished";
    }
    //提交审核
    public void Submit()
    {
        List<Task> tasks=processEngine.getTaskService()
                .createTaskQuery().taskAssignee("客户").list();
        for (Task task : tasks) {
            if (task.getProcessInstanceId() == ProcessInstanceId)
                processEngine.getTaskService().complete(task.getId());
        }
       // System.out.println("finished");
    }
    //评审审核
    public void Check(Boolean pass)
    {
        Map<String,Object> variables1=new HashMap<String, Object>();
        variables1.put("Approval",pass);
        Task task=processEngine.getTaskService()
                .createTaskQuery().taskAssignee("市场部工作人员").singleResult();
        processEngine.getTaskService().complete(task.getId(),variables1);
       // System.out.println("finished");
    }
    //停止引擎
    public void suspendTask()
    {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        repositoryService.suspendProcessDefinitionByKey("entrust");
    }
}
