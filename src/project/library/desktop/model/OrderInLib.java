/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.model;

import project.library.desktop.model.employee.Employee;

/**
 *
 * @author user
 */
public class OrderInLib  extends AbstractClass{
    private Long id;
    private Long number;
    private Employee employee;
    private Book book;
    private Reader reader;
    private ReadRoom readRoom;
    private ReadTable readTable;
    private Subjects subjects;
    private  Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public ReadRoom getReadRoom() {
        return readRoom;
    }

    public void setReadRoom(ReadRoom readRoom) {
        this.readRoom = readRoom;
    }

    public ReadTable getReadTable() {
        return readTable;
    }

    public void setReadTable(ReadTable readTable) {
        this.readTable = readTable;
    }

    @Override
    public String toString() {
        return "OrderInLib{" + "id=" + id + ", number=" + number + ", employee=" + employee + ", book=" + book + ", reader=" + reader + ", readRoom=" + readRoom + ", readTable=" + readTable + ", subjects=" + subjects + ", author=" + author + '}';
    }

    

   
  
    
    
}
