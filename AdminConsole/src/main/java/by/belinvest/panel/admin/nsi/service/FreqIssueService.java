package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.freq_issue.FreqIssue;
import by.belinvest.panel.admin.nsi.db.FreqIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreqIssueService {
    @Autowired
    private FreqIssueRepository freqIssueRepository;

    public DirectoryDTO get() {
        return freqIssueRepository.get();
    }

    public boolean create(FreqIssue freqIssue) {
        return freqIssueRepository.create(freqIssue);
    }

    public boolean update(FreqIssue freqIssue) {
        return freqIssueRepository.update(freqIssue);
    }

    public boolean remove(String id) {
        return freqIssueRepository.remove(id);
    }
}
