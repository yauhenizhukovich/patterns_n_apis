package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.base_value_type.BaseValueType;
import by.belinvest.panel.admin.nsi.db.BaseValueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseValueTypeService {

    @Autowired
    private BaseValueTypeRepository baseValueTypeRepository;

    public DirectoryDTO get() {
        return baseValueTypeRepository.get();
    }

    public boolean create(BaseValueType baseValueType) {
        return baseValueTypeRepository.create(baseValueType);
    }

    public boolean update(BaseValueType baseValueType) {
        return baseValueTypeRepository.update(baseValueType);
    }

    public boolean remove(String id) {
        return baseValueTypeRepository.remove(id);
    }
}
