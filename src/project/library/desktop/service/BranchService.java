package project.library.desktop.service;

import java.util.List;

import project.library.desktop.dao.emp.BranchDao;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.service.interfaces.IBranchService;

public class BranchService implements IBranchService {

    BranchDao branchDao;

    public BranchService() {
    }

    public BranchService(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    @Override
    public List<Branch> getBranchList() throws Exception {
        return branchDao.getBranchList();
    }

    @Override
    public boolean addBranch(Branch branch) throws Exception {
        return branchDao.addBranch(branch);
    }

    @Override
    public Branch getBranchById(Long id) throws Exception {
        return branchDao.getBranchById(id);
    }

    @Override
    public boolean updateBranch(Long id, Branch branch) throws Exception {
        return branchDao.updateBranch(id, branch);
    }

    @Override
    public boolean deleteBranc(Long id) throws Exception {
        return branchDao.deleteBranc(id);
    }

    @Override
    public Branch countEmployee(String name) throws Exception {
        return branchDao.countEmployee(name);
    }

    @Override
    public List<Branch> getBranchListForDepartment(Long id) throws Exception {
        return branchDao.getBranchListForDepartment(id);
    }

    @Override
    public List<Branch> searchBranch(String keyword) throws Exception {
        return branchDao.searchBranch(keyword);
    }

    @Override
    public List<Branch> showBranchForDeleteDep(Long id) throws Exception {
 return branchDao.showBranchForDeleteDep(id);    }

}
