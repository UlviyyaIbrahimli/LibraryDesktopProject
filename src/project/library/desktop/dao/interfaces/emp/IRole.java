package project.library.desktop.dao.interfaces.emp;

import java.util.List;
import project.library.desktop.model.Role;

/**
 *
 * @Ulviyye Ibrahimli
 */
public interface IRole {

    List<Role> getRoles() throws Exception;

    boolean addRole(Role role) throws Exception;

    boolean update(Role role, Long roleId) throws Exception;

    boolean deleteRole(Long roleId) throws Exception;

    Role getRoleById(Long id) throws Exception;

    String getRoleName(String userName, String password) throws Exception;
}
