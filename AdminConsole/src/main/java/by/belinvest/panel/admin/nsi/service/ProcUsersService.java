package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.proc_users.ProcUsers;
import by.belinvest.panel.admin.nsi.db.ProcUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcUsersService {
    @Autowired
    private ProcUsersRepository procUsersRepository;

    public DirectoryDTO get() {
        return procUsersRepository.get();
    }

    public boolean create(ProcUsers procUsers) {
        return procUsersRepository.create(procUsers);
    }

    public boolean update(ProcUsers procUsers) {
        return procUsersRepository.update(procUsers);
    }

    public boolean remove(String id) {
        return procUsersRepository.remove(id);
    }
}
