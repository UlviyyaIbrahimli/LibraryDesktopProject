/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.orderDao.GiveBackBookDao;
import project.library.desktop.model.Book;
import project.library.desktop.model.Reader;
import project.library.desktop.service.interfaces.IGiveBackBookService;

/**
 *
 * @author user
 */
public class GiveBackBookService implements IGiveBackBookService {

    private GiveBackBookDao backBookDao;

    public GiveBackBookService(GiveBackBookDao backBookDao) {
        this.backBookDao = backBookDao;
    }

    @Override
    public List<Reader> inLibReader() throws Exception {
        return backBookDao.inLibReader();
    }

    @Override
    public List<Reader> inHomeReader() throws Exception {
        return backBookDao.inHomeReader();
    }

    @Override
    public List<Reader> readerGetBook() throws Exception {
        return backBookDao.readerGetBook();
    }

    @Override
    public List<Book> bookInLib(Long readerId) throws Exception {
        return backBookDao.bookInLib(readerId);
    }

    @Override
    public List<Book> bookInHome(Long readerId) throws Exception {
        return backBookDao.bookInHome(readerId);
    }

    @Override
    public boolean addGiveBackBook(Long employeeId, Long readerId, Long bookId) throws Exception {
        return backBookDao.addGiveBackBook(employeeId, readerId, bookId);
    }

    @Override
    public boolean addGiveBackBookFromHome(Long employeeId, Long readerId, Long bookId) throws Exception {
    return backBookDao.addGiveBackBookFromHome(employeeId, readerId, bookId);
    }

}
