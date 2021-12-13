package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.emp.LoginDao;
import project.library.desktop.model.Login;
import project.library.desktop.service.interfaces.ILoginService;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class LoginService implements ILoginService {

    private LoginDao loginDao;

    public LoginService() {
    }

    public LoginService(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public List<Login> logins() throws Exception {
        return loginDao.logins();
    }

    @Override
    public boolean addLogin(Login login) throws Exception {
        return loginDao.addLogin(login);
    }

    @Override
    public boolean updateLogin(Long loginId, Login login) throws Exception {
        return loginDao.updateLogin(loginId, login);
    }

    @Override
    public boolean deleteLogin(Long loginId) throws Exception {
        return loginDao.deleteLogin(loginId);
    }

    @Override
    public Login getLoginById(Long id) throws Exception {
        return loginDao.getLoginById(id);
    }

    @Override
    public Login checkLogin(String userName, String password, String roleName) throws Exception {
        return loginDao.checkLogin(userName, password, roleName);
    }

}
