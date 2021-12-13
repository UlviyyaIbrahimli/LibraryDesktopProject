package project.library.desktop.dao.interfaces.emp;

import java.util.List;

import project.library.desktop.model.employee.Branch;
/**
 * 
 * @Ulviyye Ibrahimli
 */
public interface IBranch {

    List<Branch> getBranchList() throws Exception;

    boolean addBranch(Branch branch) throws Exception;

    Branch getBranchById(Long id) throws Exception;

    boolean updateBranch(Long id, Branch branch) throws Exception;

    boolean deleteBranc(Long id) throws Exception;

    Branch countEmployee(String name) throws Exception;

    List<Branch> getBranchListForDepartment(Long id) throws Exception;

    List<Branch> searchBranch(String keyword) throws Exception;

    List<Branch> showBranchForDeleteDep(Long id) throws Exception;
}
