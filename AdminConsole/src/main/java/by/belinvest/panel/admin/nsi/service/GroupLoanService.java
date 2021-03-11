package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.group_loan.GroupLoan;
import by.belinvest.panel.admin.nsi.db.GroupLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupLoanService {
    @Autowired
    private GroupLoanRepository groupLoanRepository;

    public DirectoryDTO get() {
        return groupLoanRepository.get();
    }

    public boolean create(GroupLoan groupLoan) {
        return groupLoanRepository.create(groupLoan);
    }

    public boolean update(GroupLoan groupLoan) {
        return groupLoanRepository.update(groupLoan);
    }

    public boolean remove(String id) {
        return groupLoanRepository.remove(id);
    }
}
