
package project.library.desktop.Desktop_Gui;

import project.library.desktop.dao.AuthorDao;
import project.library.desktop.dao.BookDao;
import project.library.desktop.dao.BookRoomDao;
import project.library.desktop.dao.BookShelfDao;
import project.library.desktop.dao.LanguageDao;
import project.library.desktop.dao.ReadRoomDao;
import project.library.desktop.dao.ReadTableDao;
import project.library.desktop.dao.ReaderDao;
import project.library.desktop.dao.SubjectDao;
import project.library.desktop.dao.emp.BranchDao;
import project.library.desktop.dao.emp.DepartmentDao;
import project.library.desktop.dao.emp.EducationTypeDao;
import project.library.desktop.dao.emp.EmployeeDao;
import project.library.desktop.dao.emp.LoginDao;
import project.library.desktop.dao.emp.PositionDao;
import project.library.desktop.dao.emp.RoleDao;
import project.library.desktop.dao.emp.TimeTypeDao;
import project.library.desktop.dao.orderDao.GiveBackBookDao;
import project.library.desktop.dao.orderDao.OrderInHomeDao;
import project.library.desktop.dao.orderDao.OrderInLibDao;
import project.library.desktop.service.AuthorService;
import project.library.desktop.service.BookRoomService;
import project.library.desktop.service.BookService;
import project.library.desktop.service.BranchService;
import project.library.desktop.service.DepartmentService;
import project.library.desktop.service.EducationTypeService;
import project.library.desktop.service.EmployeeService;
import project.library.desktop.service.PositionService;
import project.library.desktop.service.BookShelfService;
import project.library.desktop.service.GiveBackBookService;
import project.library.desktop.service.LanguageService;
import project.library.desktop.service.LoginService;
import project.library.desktop.service.OrderInHomeService;
import project.library.desktop.service.OrderInLibService;
import project.library.desktop.service.ReadRoomService;
import project.library.desktop.service.ReadTableService;
import project.library.desktop.service.ReaderService;
import project.library.desktop.service.RoleService;
import project.library.desktop.service.SubjectService;
import project.library.desktop.service.TimeTypeService;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class MainGui {

    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        DepartmentService departmentService = new DepartmentService(departmentDao);
        PositionDao positionDao = new PositionDao();
        PositionService positionService = new PositionService(positionDao);
        BranchDao branchDao = new BranchDao();
        BranchService branchService = new BranchService(branchDao);
        EmployeeDao employeeDao = new EmployeeDao();
        EmployeeService employeeService = new EmployeeService(employeeDao);
        TimeTypeDao timeTypeDao = new TimeTypeDao();
        TimeTypeService timeTypeService = new TimeTypeService(timeTypeDao);
        EducationTypeDao educationTypeDao = new EducationTypeDao();
        EducationTypeService educationTypeService = new EducationTypeService(educationTypeDao);
        BookDao bookDao = new BookDao();
        BookService bookService = new BookService(bookDao);
        SubjectDao subjectDao = new SubjectDao();
        SubjectService subjectService = new SubjectService(subjectDao);
        AuthorDao authorDao = new AuthorDao();
        AuthorService authorService = new AuthorService(authorDao);
        BookShelfDao bookShelfDao = new BookShelfDao();
        BookShelfService bookShelfService = new BookShelfService(bookShelfDao);
        BookRoomDao bookRoomDao = new BookRoomDao();
        BookRoomService bookRoomService = new BookRoomService(bookRoomDao);
        ReadRoomDao readRoomDao = new ReadRoomDao();
        ReadRoomService readRoomService = new ReadRoomService(readRoomDao);
        ReadTableDao readTableDao = new ReadTableDao();
        ReadTableService readTableService = new ReadTableService(readTableDao);
        LanguageDao languageDao = new LanguageDao();
        LanguageService languageService = new LanguageService(languageDao);
        ReaderDao readerDao = new ReaderDao();
        ReaderService readerService = new ReaderService(readerDao);
        OrderInLibDao orderInLibDao = new OrderInLibDao();
        OrderInLibService orderInLibService = new OrderInLibService(orderInLibDao);
        OrderInHomeDao orderInHomeDao = new OrderInHomeDao();
        OrderInHomeService orderInHomeService = new OrderInHomeService(orderInHomeDao);
        GiveBackBookDao giveBackBookDao = new GiveBackBookDao();
        GiveBackBookService giveBackBookService = new GiveBackBookService(giveBackBookDao);
        LoginDao loginDao = new LoginDao();
        LoginService loginService = new LoginService(loginDao);
        RoleDao roleDao = new RoleDao();
        RoleService roleService = new RoleService(roleDao);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            LoginFrame loginFrame = new LoginFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService,loginService,roleService);
            loginFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
