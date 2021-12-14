/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.dao.interfaces;

import java.util.List;
import project.library.desktop.model.Status;
import project.library.desktop.model.Subjects;

/**
 *
 * @author user
 */
public interface IStatus {
    List<Status> getStatusList() throws Exception;
}
