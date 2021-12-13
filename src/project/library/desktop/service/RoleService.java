
package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.emp.RoleDao;
import project.library.desktop.model.Role;
import project.library.desktop.service.interfaces.IRoleService;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class RoleService implements IRoleService {

    private RoleDao roleDao;

    public RoleService() {
    }

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() throws Exception {
        return roleDao.getRoles();
    }

    @Override
    public boolean addRole(Role role) throws Exception {
        return roleDao.addRole(role);
    }

    @Override
    public boolean update(Role role, Long roleId) throws Exception {
        return roleDao.update(role, roleId);
    }

    @Override
    public boolean deleteRole(Long roleId) throws Exception {
        return roleDao.deleteRole(roleId);
    }

    @Override
    public Role getRoleById(Long id) throws Exception {
 return  roleDao.getRoleById(id) ;   }

    @Override
    public String getRoleName(String userName, String password) throws Exception {
return roleDao.getRoleName(userName, password);    }

}
