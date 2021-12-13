package project.library.desktop.model.employee;

import project.library.desktop.model.AbstractClass;

public class Position extends AbstractClass {
    private Long id;
    private Long number;
    private String positionName;
    private Branch branch;
    private String positionObligation;
    private TimeType pTimeType;



    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
  
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getPositionObligation() {
        return positionObligation;
    }

    public void setPositionObligation(String positionObligation) {
        this.positionObligation = positionObligation;
    }

    public TimeType getpTimeType() {
        return pTimeType;
    }

    public void setpTimeType(TimeType pTimeType) {
        this.pTimeType = pTimeType;
    }

    @Override
    public String toString() {
        return "Position{" + "id=" + id + ", number=" + number + ", positionName=" + positionName + ", branch=" + branch + ", positionObligation=" + positionObligation + ", pTimeType=" + pTimeType + '}';
    }

    
   
    
}
