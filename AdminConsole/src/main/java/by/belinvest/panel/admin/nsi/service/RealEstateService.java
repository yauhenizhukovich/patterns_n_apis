package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.real_estate.RealEstate;
import by.belinvest.panel.admin.nsi.db.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealEstateService {
    @Autowired
    private RealEstateRepository realEstateRepository;

    public DirectoryDTO get() {
        return realEstateRepository.get();
    }

    public boolean create(RealEstate realEstate) {
        return realEstateRepository.create(realEstate);
    }

    public boolean update(RealEstate realEstate) {
        return realEstateRepository.update(realEstate);
    }

    public boolean remove(String dimid) {
        return realEstateRepository.remove(dimid);
    }
}
