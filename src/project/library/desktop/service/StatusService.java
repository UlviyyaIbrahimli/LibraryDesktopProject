/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.StatusDao;
import project.library.desktop.model.Status;
import project.library.desktop.service.interfaces.IStatusService;

/**
 *
 * @author user
 */
public class StatusService implements IStatusService{
    StatusDao statusDao;

    public StatusService(StatusDao statusDao) {
        this.statusDao = statusDao;
    }
    
    @Override
    public List<Status> getStatusList() throws Exception {
         return  statusDao.getStatusList();
    }
    
}
