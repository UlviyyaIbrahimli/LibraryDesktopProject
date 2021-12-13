/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.model.employee;

import project.library.desktop.model.AbstractClass;

/**
 *
 * @author user
 */
public class EducationType extends AbstractClass{
    private Long id;
    private String degreeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    @Override
    public String toString() {
        return "EducationType{" + "id=" + id + ", degreeName=" + degreeName + '}';
    }
    
}
