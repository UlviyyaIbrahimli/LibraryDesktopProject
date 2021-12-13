package project.library.desktop.service.interfaces;

import java.util.List;
import project.library.desktop.model.employee.TimeType;

public interface ITimeTypeService {
        List<TimeType> timeTypeList() throws Exception;

}
