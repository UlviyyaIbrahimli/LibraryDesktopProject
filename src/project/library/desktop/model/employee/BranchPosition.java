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
public class BranchPosition extends AbstractClass{
    private Long id;
    private Position position;
    private  Branch branch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "BranchPosition{" + "id=" + id + ", position=" + position + ", branch=" + branch + '}';
    }
    
}
