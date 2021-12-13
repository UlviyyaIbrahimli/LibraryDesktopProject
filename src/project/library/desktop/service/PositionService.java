package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.emp.PositionDao;
import project.library.desktop.model.employee.Position;
import project.library.desktop.service.interfaces.IPositionService;
/**
 * 
 * @ Ulviyye Ibrahimli
 */
public class PositionService implements IPositionService {

    PositionDao positionDao;

    public PositionService() {

    }

    public PositionService(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public List<Position> getPositionList() throws Exception {
        return positionDao.getPositionList();
    }

    @Override
    public boolean addPosition(Position position) throws Exception {
        return positionDao.addPosition(position);
    }

    @Override
    public boolean updatePosition(Long id, Position position) throws Exception {
        return positionDao.updatePosition(id, position);

    }

    @Override
    public Position getPositionById(Long id) throws Exception {
        return positionDao.getPositionById(id);

    }

    @Override
    public List<Position> getPositionListByBranchId(Long id) throws Exception {
        return positionDao.getPositionListByBranchId(id);
    }

    @Override
    public boolean deletePosition(long id) throws Exception {
        return positionDao.deletePosition(id);
    }

    @Override
    public List<Position> searchPosition(String keyword) throws Exception {
        return positionDao.searchPosition(keyword);
    }

}
