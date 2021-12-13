package project.library.desktop.model.employee;

import project.library.desktop.model.AbstractClass;

import java.util.Date;

public class Branch  extends AbstractClass {
    private Long id;
    private Long number;
    private Department department;
    private String branchName;
    private String phone;
    private Integer employeeCount;
    private String  eMail;
    private Float assets;
    private Date foundate;
    private  String Address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Float getAssets() {
        return assets;
    }

    public void setAssets(Float assets) {
        this.assets = assets;
    }

    public Date getFoundate() {
        return foundate;
    }

    public void setFoundate(Date foundate) {
        this.foundate = foundate;
    }

    @Override
    public String toString() {
        return "Branch{" + "id=" + id + ", number=" + number + ", department=" + department + ", branchName=" + branchName + ", phone=" + phone + ", employeeCount=" + employeeCount + ", eMail=" + eMail + ", assets=" + assets + ", foundate=" + foundate + ", Address=" + Address + '}';
    }

   
}
