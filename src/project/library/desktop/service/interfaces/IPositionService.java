package project.library.desktop.service.interfaces;

import java.util.List;
import project.library.desktop.dao.emp.PositionDao;
import project.library.desktop.model.employee.Position;

public interface IPositionService {

    List<Position> getPositionList() throws Exception;

    boolean addPosition(Position position) throws Exception;

    boolean updatePosition(Long id, Position position) throws Exception;

    Position getPositionById(Long id) throws Exception;

    List<Position> getPositionListByBranchId(Long id) throws Exception;

    boolean deletePosition(long id) throws Exception;

    List<Position> searchPosition(String keyword) throws Exception;

}
