package com.sinosteel.domain;

import javax.persistence.*;
import com.sinosteel.activiti.ActivitiController;
@Entity
@Table(name = "TBL_SYS_Entrust")
@Inheritance(strategy = InheritanceType.JOINED)
public class Entrust extends BaseEntity{
    @Column(name = "ENTRUST")
    private String entrustString;


    public Entrust() {
        this.setId("1");

    }

    public String getEntrustString() {
        return entrustString;
    }

    public void setEntrustString(String entrustString) {
        this.entrustString = entrustString;
    }
}
