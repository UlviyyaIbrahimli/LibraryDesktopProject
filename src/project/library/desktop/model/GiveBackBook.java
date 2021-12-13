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
public class GiveBackBook extends AbstractClass{
    private Long id;
    private Long number;
    private Employee employee;
    private Reader reader;
    private Book book;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "GiveBackBook{" + "id=" + id + ", number=" + number + ", employee=" + employee + ", reader=" + reader + ", book=" + book + '}';
    }
    
}
