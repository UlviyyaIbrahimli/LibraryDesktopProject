package project.library.desktop.dao.interfaces.emp;

import java.util.List;
import project.library.desktop.model.employee.Department;

public interface IDepartment {
    List<Department>  getDepartmentList() throws Exception;
    boolean addDepartment(Department department) throws  Exception;
    Department getDepartmentById(Long id) throws Exception;
    boolean updateDepartment(Department department,Long id) throws Exception;
    boolean deleteDepartment(Long id) throws  Exception;
    Department branchCount(Long id) throws Exception;
    Department employeeCount(Long id) throws  Exception;
    List<Department> getDepHaveBranch() throws Exception;
    List<Department> searchDepartment(String keyword) throws Exception;
    
}
