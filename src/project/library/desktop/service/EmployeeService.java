package project.library.desktop.service;

import project.library.desktop.dao.emp.EmployeeDao;
import project.library.desktop.model.employee.Employee;
import project.library.desktop.service.interfaces.IEmployeeService;
import java.util.List;
import project.library.desktop.model.employee.EducationType;

public class EmployeeService implements IEmployeeService {

    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployeeList(int choose) throws Exception {
        return employeeDao.getEmployeeList(choose);
    }

    @Override
    public boolean addEmployee(Employee employee) throws Exception {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Long id, Employee employee) throws Exception {
        return employeeDao.updateEmployee(id, employee);
    }

    @Override
    public Employee getEmployeeById(Long id) throws Exception {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public boolean deleteEmployee(Long id) throws Exception {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public Float count(int choose, String chooseSql) throws Exception {
        return employeeDao.count(choose, chooseSql);
    }

    @Override
    public List<Employee> getEmployeeForOrder(Long id) throws Exception {
        return employeeDao.getEmployeeForOrder(id);
    }

    @Override
    public List<Employee> searchEmployee(String keyword) throws Exception {
        return employeeDao.searchEmployee(keyword);
    }

    @Override
    public List<Employee> getEmployeeWithoutPosition(Long positionId) throws Exception {
        return employeeDao.getEmployeeWithoutPosition(positionId);
    }

    @Override
    public Long getCurrentId() throws Exception {
        return employeeDao.getCurrentId();
    }

    @Override
    public boolean addEducationDegree(Long eduTypeId, Long employeeId) throws Exception {
        return employeeDao.addEducationDegree(eduTypeId, employeeId);
    }

    @Override
    public List<EducationType> eduDegreForEdit(Long employeeId) throws Exception {
        return employeeDao.eduDegreForEdit(employeeId);
    }

    @Override
    public boolean updateEduDegree(Long employeeId, Long eduId) throws Exception {
        return employeeDao.updateEduDegree(employeeId, eduId);
    }

    @Override
    public boolean deleteEducationDegree(Long employeeId, Long eduId) throws Exception {
        return employeeDao.deleteEducationDegree(employeeId, eduId);
    }

    @Override
    public boolean addEmployee(Long employeeId, Employee employee) throws Exception {
        return employeeDao.addEmployee(employeeId, employee);
    }
}
