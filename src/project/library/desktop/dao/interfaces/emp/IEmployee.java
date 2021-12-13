package project.library.desktop.dao.interfaces.emp;

import project.library.desktop.model.employee.Employee;

import java.util.List;
import project.library.desktop.model.employee.EducationType;
/**
 * 
 * @Ulviyye Ibrahimli
 */
public interface IEmployee {

    List<Employee> getEmployeeList(int choose) throws Exception;

    boolean addEmployee(Employee employee) throws Exception;

    boolean updateEmployee(Long id, Employee employee) throws Exception;

    Employee getEmployeeById(Long id) throws Exception;

    boolean deleteEmployee(Long id) throws Exception;

    Float count(int choose, String chooseSql) throws Exception;

    List<Employee> getEmployeeForOrder(Long id) throws Exception;

    List<Employee> searchEmployee(String keyword) throws Exception;

    List<Employee> getEmployeeWithoutPosition(Long positionId) throws Exception;

    Long getCurrentId() throws Exception;

    boolean addEducationDegree(Long eduTypeId, Long employeeId) throws Exception;

    List<EducationType> eduDegreForEdit(Long employeeId) throws Exception;

    boolean updateEduDegree(Long employeeId, Long eduId) throws Exception;

    boolean deleteEducationDegree(Long employeeId, Long eduId) throws Exception;
    boolean addEmployee(Long employeeId, Employee employee) throws Exception;

}
