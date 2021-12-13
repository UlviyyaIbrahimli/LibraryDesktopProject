package project.library.desktop.model.employee;

import project.library.desktop.model.AbstractClass;

import java.util.Date;

public class Department extends AbstractClass {

    private Long id;
    private Long number;
    private String departmentName;
    private String obligation;
    private Date foundate;
    private Integer branchCount;
    private Integer employeeCount;
    private Float assets;
    private String Address;
private String Phone;
private String eMail;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getObligation() {
        return obligation;
    }

    public void setObligation(String obligation) {
        this.obligation = obligation;
    }

    public Date getFoundate() {
        return foundate;
    }

    public void setFoundate(Date foundate) {
        this.foundate = foundate;
    }

    public Integer getBranchCount() {
        return branchCount;
    }

    public void setBranchCount(Integer branchCount) {
        this.branchCount = branchCount;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Float getAssets() {
        return assets;
    }

    public void setAssets(Float assets) {
        this.assets = assets;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", number=" + number + ", departmentName=" + departmentName + ", obligation=" + obligation + ", foundate=" + foundate + ", branchCount=" + branchCount + ", employeeCount=" + employeeCount + ", assets=" + assets + ", Address=" + Address + ", Phone=" + Phone + ", eMail=" + eMail + '}';
    }

   

}
