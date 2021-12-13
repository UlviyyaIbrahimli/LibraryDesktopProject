package project.library.desktop.dao.interfaces.emp;

import java.util.List;
import project.library.desktop.model.employee.Position;

public interface IPosition {

    List<Position> getPositionList() throws Exception;

    boolean addPosition(Position position) throws Exception;

    boolean updatePosition(Long id, Position position) throws Exception;

    Position getPositionById(Long id) throws Exception;

    List<Position> getPositionListByBranchId(Long id) throws Exception;

    boolean deletePosition(long id) throws Exception;

    List<Position> searchPosition(String keyword) throws Exception;
}
