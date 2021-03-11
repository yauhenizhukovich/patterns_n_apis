package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.work_type.WorkType;
import by.belinvest.panel.admin.nsi.db.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkTypeService {
    @Autowired
    private WorkTypeRepository workTypeRepository;

    public DirectoryDTO get() {
        return workTypeRepository.get();
    }

    public boolean create(WorkType workType) {
        return workTypeRepository.create(workType);
    }

    public boolean update(WorkType workType) {
        return workTypeRepository.update(workType);
    }

    public boolean remove(String dimid) {
        return workTypeRepository.remove(dimid);
    }
}
