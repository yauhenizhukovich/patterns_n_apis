package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.int_rate_reduce.IntRateReduce;
import by.belinvest.panel.admin.nsi.db.IntRateReduceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntRateReduceService {
    @Autowired
    private IntRateReduceRepository intRateReduceRepository;

    public DirectoryDTO get() {
        return intRateReduceRepository.get();
    }

    public boolean create(IntRateReduce intRateReduce) {
        return intRateReduceRepository.create(intRateReduce);
    }

    public boolean update(IntRateReduce intRateReduce) {
        return intRateReduceRepository.update(intRateReduce);
    }

    public boolean remove(String id) {
        return intRateReduceRepository.remove(id);
    }
}
