package project.library.desktop.service;

import java.util.List;
import project.library.desktop.dao.emp.TimeTypeDao;
import project.library.desktop.model.employee.TimeType;
import project.library.desktop.service.interfaces.ITimeTypeService;

public class TimeTypeService  implements ITimeTypeService {
    TimeTypeDao timeTypeDao;

    public TimeTypeService(TimeTypeDao timeTypeDao) {
        this.timeTypeDao = timeTypeDao;
    }

    public TimeTypeService() {
    }

    @Override
    public List<TimeType> timeTypeList() throws Exception {
        return timeTypeDao.timeTypeList();
    }
    
}
