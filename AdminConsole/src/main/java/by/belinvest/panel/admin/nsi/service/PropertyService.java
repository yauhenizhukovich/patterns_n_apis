package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.property.Property;
import by.belinvest.panel.admin.nsi.db.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public DirectoryDTO get() {
        return propertyRepository.get();
    }

    public boolean create(Property property) {
        return propertyRepository.create(property);
    }

    public boolean update(Property property) {
        return propertyRepository.update(property);
    }

    public boolean remove(String id) {
        return propertyRepository.remove(id);
    }
}
