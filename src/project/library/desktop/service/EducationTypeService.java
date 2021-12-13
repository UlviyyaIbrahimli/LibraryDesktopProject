/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.emp.EducationTypeDao;
import project.library.desktop.dao.interfaces.IEducationType;
import project.library.desktop.model.employee.EducationType;
import project.library.desktop.service.interfaces.IEducationTypeService;

/**
 *
 * @author user
 */
public class EducationTypeService implements IEducationTypeService{
    EducationTypeDao educationTypeDao;

    public EducationTypeService() {
    }

    public EducationTypeService(EducationTypeDao educationTypeDao) {
        this.educationTypeDao = educationTypeDao;
    }
    
    @Override
    public List<EducationType> getEeducationTypeList() throws Exception {
      return educationTypeDao.getEeducationTypeList();
    }
    
}
