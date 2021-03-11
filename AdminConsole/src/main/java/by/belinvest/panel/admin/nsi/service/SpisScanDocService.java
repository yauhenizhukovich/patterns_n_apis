package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.spis_scan_doc.SpisScanDoc;
import by.belinvest.panel.admin.nsi.db.SpisScanDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpisScanDocService {
    @Autowired
    private SpisScanDocRepository spisScanDocRepository;

    public DirectoryDTO get() {
        return spisScanDocRepository.get();
    }

    public boolean create(SpisScanDoc spisScanDoc) {
        return spisScanDocRepository.create(spisScanDoc);
    }

    public boolean update(SpisScanDoc spisScanDoc) {
        return spisScanDocRepository.update(spisScanDoc);
    }

    public boolean remove(String dimid) {
        return spisScanDocRepository.remove(dimid);
    }
}
