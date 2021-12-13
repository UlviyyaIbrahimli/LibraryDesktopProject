package project.library.desktop.dao.interfaces.emp;

import java.util.List;
import project.library.desktop.model.employee.TimeType;

public interface ITimeType {

    List<TimeType> timeTypeList() throws Exception;

    boolean addTimetype(TimeType timeType) throws Exception;
}
