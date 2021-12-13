package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.emp.DepartmentDao;
import project.library.desktop.model.employee.Department;
import project.library.desktop.service.interfaces.IDepartmentService;

public class DepartmentService implements IDepartmentService {

    DepartmentDao departmentDao;

    public DepartmentService() {
    }

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getDepartmentList() throws Exception {
        return departmentDao.getDepartmentList();
    }

    @Override
    public boolean addDepartment(Department department) throws Exception {
        return departmentDao.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(Long id) throws Exception {
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public boolean updateDepartment(Department department, Long id) throws Exception {
        return departmentDao.updateDepartment(department, id);
    }

    @Override
    public boolean deleteDepartment(Long id) throws Exception {
        return departmentDao.deleteDepartment(id);
    }

    @Override
    public Department branchCount(Long id) throws Exception {
        return departmentDao.branchCount(id);
    }

    @Override
    public Department employeeCount(Long id) throws Exception {
        return departmentDao.employeeCount(id);
    }

    @Override
    public List<Department> getDepHaveBranch() throws Exception {
        return departmentDao.getDepHaveBranch();
    }

    @Override
    public List<Department> searchDepartment(String keyword) throws Exception {
        return departmentDao.searchDepartment(keyword);
    }
}
