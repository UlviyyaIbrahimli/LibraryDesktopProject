/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.service.interfaces;

import java.util.List;
import project.library.desktop.model.Status;

/**
 *
 * @author user
 */
public interface IStatusService {
   List<Status> getStatusList() throws Exception;

    
}
