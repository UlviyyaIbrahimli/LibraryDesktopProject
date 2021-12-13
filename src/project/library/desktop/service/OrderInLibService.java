/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.orderDao.OrderInLibDao;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.OrderInLib;
import project.library.desktop.service.interfaces.IOrderInLibService;

/**
 *
 * @author user
 */
public class OrderInLibService implements IOrderInLibService {

    private OrderInLibDao orderInLibDao;

    public OrderInLibService(OrderInLibDao orderInLibDao) {
        this.orderInLibDao = orderInLibDao;
    }

    @Override
    public boolean addOrder(Long employeeId, Long reader_id, Long bookId, Long roomId, Long tableId) throws Exception {
        return orderInLibDao.addOrder(employeeId, reader_id, bookId, roomId, tableId);
    }

    @Override
    public List<OrderInLib> getOrderListForAll() throws Exception {
        return orderInLibDao.getOrderListForAll();
    }

    @Override
    public List<OrderInLib> getOrderForSpecifig(String Choose) throws Exception {
        return orderInLibDao.getOrderForSpecifig(Choose);
    }

    @Override
    public List<OrderInLib> getOrderInfo(int choose, String sqlChoose1, String sqlChoose2) throws Exception {
        return orderInLibDao.getOrderInfo(choose, sqlChoose1, sqlChoose2);
    }

    @Override
    public Integer getOrderInfoSpecifig(int choose, String sqlChoose1, String sqlChoose2) throws Exception {
        return orderInLibDao.getOrderInfoSpecifig(choose, sqlChoose1, sqlChoose2);
    }

    @Override
    public boolean updateOrderActive(Long id, Long bookId) throws Exception {
        return orderInLibDao.updateOrderActive(id, bookId);
    }

    @Override
    public Long getRoomId(Long readerId,Long bookId) throws Exception {
        return orderInLibDao.getRoomId(readerId,bookId);
    }

    @Override
    public Long getOrderId(Long readerId, Long bookId) throws Exception {
        return orderInLibDao.getOrderId(readerId, bookId);
    }

    @Override
    public List<OrderInLib> getOrderForCurrent(String Choose) throws Exception {
        return orderInLibDao.getOrderForCurrent(Choose);
    }

    @Override
    public List<OrderInLib> getOrderWarning() throws Exception {
        return orderInLibDao.getOrderWarning();
    }

    @Override
    public Float getTimeLimite(Long id) throws Exception {
        return orderInLibDao.getTimeLimite(id);
    }

    @Override
    public Integer getActive(Long readerId, Long bookId) throws Exception {
      return orderInLibDao.getActive(readerId, bookId);
    }

    @Override
    public OrderInLib getReaderCurrentRoomAndTable(Long readerId) throws Exception {
return  orderInLibDao.getReaderCurrentRoomAndTable(readerId);}

    @Override
    public List<OrderInLib> getOrdersForTable(int choose, Long readerId, Long bookId) throws Exception {
return orderInLibDao.getOrdersForTable(choose, readerId, bookId);    }

    @Override
    public List<OrderInLib> getResultWithTimeArround(int choose, Long id, String time1, String time2) throws Exception {
return orderInLibDao.getResultWithTimeArround(choose, id, time1, time2) ;   }

    @Override
    public List<OrderInLib> getResultSysdate(int choose, Long id, String time1) throws Exception {
return  orderInLibDao.getResultSysdate(choose, id, time1);}

    @Override
    public List<OrderInLib> getBooksForTime(Long bookId, String time1, String time2) throws Exception {
return orderInLibDao.getBooksForTime(bookId, time1, time2);    }

    @Override
    public List<OrderInLib> getCountForSearch(int choose, Long id, String time1, String time2) throws Exception {
return orderInLibDao.getCountForSearch(choose, id, time1, time2)  ;  }

    @Override
    public List<GiveBackBook> getGiveBackBook(int choose, String time1, String time2) throws Exception {
return orderInLibDao.getGiveBackBook(choose, time1, time2) ;   }

   

}
