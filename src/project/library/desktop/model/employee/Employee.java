package project.library.desktop.model.employee;

import project.library.desktop.model.AbstractClass;

import java.sql.Blob;
import java.util.Date;

public class Employee extends AbstractClass {

    private Long id;
    private Long number;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String gender;
    private Date dob;
    private String maritalStatus;
    private String indentifyNumber;
    private Blob image;
    private String nationality;
    private String cardNumber;
    private Float salary;
    private Date beginToWork;
    private String university;
    private Date graduateDate;
    private String diplomaNumber;
    private String certification;
    private Branch branc;
    private Position position;
    private EducationType educationType;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String homeNumber;
    private String eMail;
    private String phone1;
    private String phone2;
    private String homePhone;
    private String note;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getIndentifyNumber() {
        return indentifyNumber;
    }

    public void setIndentifyNumber(String indentifyNumber) {
        this.indentifyNumber = indentifyNumber;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Date getBeginToWork() {
        return beginToWork;
    }

    public void setBeginToWork(Date beginToWork) {
        this.beginToWork = beginToWork;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getDiplomaNumber() {
        return diplomaNumber;
    }

    public void setDiplomaNumber(String diplomaNumber) {
        this.diplomaNumber = diplomaNumber;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Branch getBranc() {
        return branc;
    }

    public void setBranc(Branch branc) {
        this.branc = branc;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", number=" + number + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName=" + fatherName + ", gender=" + gender + ", dob=" + dob + ", maritalStatus=" + maritalStatus + ", indentifyNumber=" + indentifyNumber + ", image=" + image + ", nationality=" + nationality + ", cardNumber=" + cardNumber + ", salary=" + salary + ", beginToWork=" + beginToWork + ", university=" + university + ", graduateDate=" + graduateDate + ", diplomaNumber=" + diplomaNumber + ", certification=" + certification + ", branc=" + branc + ", position=" + position + ", educationType=" + educationType + ", country=" + country + ", city=" + city + ", street=" + street + ", houseNumber=" + houseNumber + ", homeNumber=" + homeNumber + ", eMail=" + eMail + ", phone1=" + phone1 + ", phone2=" + phone2 + ", homePhone=" + homePhone + ", note=" + note + '}';
    }

}
