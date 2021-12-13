package project.library.desktop.dao.interfaces;

import java.util.List;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.OrderInHome;

/**
 *
 * @Ulviyye Ibrahimli
 */
public interface IOrderInHome {

    boolean addOrderInHome(Long employeeId, Long readerId, Long bookId) throws Exception;

    boolean updateOrderActive(Long id, Long bookId) throws Exception;

    List<OrderInHome> orderInHomeCurrent(String choose) throws Exception;

    Integer getActiveOrderInHome(Long readerId, Long bookId) throws Exception;

    Integer getBooksCountSpecifig(int choose, Long id, String sqlChoose1) throws Exception;

    List<OrderInHome> getBooksForTime(int bookId, String time1, String time2) throws Exception;

    List<OrderInHome> getCountForSearch(int choose, Long id, String time1, String time2) throws Exception;

    Integer getOrderActive(Long readerId, Long bookId) throws Exception;

    List<GiveBackBook> getGives(int choose, String time1, String time2) throws Exception;

    boolean updateGiveFromHome(Long readerId, Long bookId) throws Exception;
}
