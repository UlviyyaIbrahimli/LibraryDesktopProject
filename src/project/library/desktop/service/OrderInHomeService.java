/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.orderDao.OrderInHomeDao;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.OrderInHome;
import project.library.desktop.service.interfaces.IOrderInHomeService;

/**
 *
 * @author user
 */
public class OrderInHomeService implements IOrderInHomeService {

    private OrderInHomeDao orderInHomeDao;

    public OrderInHomeService(OrderInHomeDao orderInHomeDao) {
        this.orderInHomeDao = orderInHomeDao;
    }

    @Override
    public boolean addOrderInHome(Long employeeId, Long readerId, Long bookId) throws Exception {
        return orderInHomeDao.addOrderInHome(employeeId, readerId, bookId);
    }

    @Override
    public boolean updateOrderActive(Long id, Long bookId) throws Exception {
        return orderInHomeDao.updateOrderActive(id, bookId);
    }

    @Override
    public List<OrderInHome> orderInHomeCurrent(String choose) throws Exception {
        return orderInHomeDao.orderInHomeCurrent(choose);
    }

    @Override
    public Integer getActiveOrderInHome(Long readerId, Long bookId) throws Exception {
        return orderInHomeDao.getActiveOrderInHome(readerId, bookId);
    }

    @Override
    public Integer getBooksCountSpecifig(int choose, Long id, String sqlChoose1) throws Exception {
        return orderInHomeDao.getBooksCountSpecifig(choose, id, sqlChoose1);
    }

    @Override
    public List<OrderInHome> getBooksForTime(int bookId, String time1, String time2) throws Exception {
        return orderInHomeDao.getBooksForTime(bookId, time1, time2);
    }

    @Override
    public List<OrderInHome> getCountForSearch(int choose, Long id, String time1, String time2) throws Exception {
        return orderInHomeDao.getCountForSearch(choose, id, time1, time2);
    }

    @Override
    public Integer getOrderActive(Long readerId, Long bookId) throws Exception {
        return orderInHomeDao.getActiveOrderInHome(readerId, bookId);
    }

    @Override
    public List<GiveBackBook> getGives(int choose, String time1, String time2) throws Exception {
        return orderInHomeDao.getGives(choose, time1, time2);
    }

    @Override
    public boolean updateGiveFromHome(Long readerId, Long bookId) throws Exception {
         return  orderInHomeDao.updateGiveFromHome(readerId, bookId);
    }

}
