
package project.library.desktop.dao.interfaces;

import java.util.List;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.OrderInLib;

/**
 *
 * @Ulviyye Ibrahimli
 */
public interface IOrderInLib {

    boolean addOrder(Long employeeId, Long reader_id, Long bookId, Long roomId, Long tableId) throws Exception;

    List<OrderInLib> getOrderListForAll() throws Exception;

    List<OrderInLib> getOrderForSpecifig(String Choose) throws Exception;

    List<OrderInLib> getOrderInfo(int choose, String sqlChoose1, String sqlChoose2) throws Exception;

    Integer getOrderInfoSpecifig(int choose, String sqlChoose1, String sqlChoose2) throws Exception;

    boolean updateOrderActive(Long id, Long bookId) throws Exception;

    Long getRoomId(Long readerId, Long bookId) throws Exception;

    Long getOrderId(Long readerId, Long bookId) throws Exception;

    List<OrderInLib> getOrderForCurrent(String Choose) throws Exception;

    List<OrderInLib> getOrderWarning() throws Exception;

    Float getTimeLimite(Long id) throws Exception;

    Integer getActive(Long readerId, Long bookId) throws Exception;

    OrderInLib getReaderCurrentRoomAndTable(Long readerId) throws Exception;

    List<OrderInLib> getOrdersForTable(int choose, Long readerId, Long bookId) throws Exception;

    List<OrderInLib> getResultWithTimeArround(int choose, Long id, String time1, String time2) throws Exception;

    List<OrderInLib> getResultSysdate(int choose, Long id, String time1) throws Exception;

    List<OrderInLib> getBooksForTime(Long bookId, String time1, String time2) throws Exception;

    List<OrderInLib> getCountForSearch(int choose, Long id, String time1, String time2) throws Exception;

    List<GiveBackBook> getGiveBackBook(int choose, String time1, String time2) throws Exception;
}
