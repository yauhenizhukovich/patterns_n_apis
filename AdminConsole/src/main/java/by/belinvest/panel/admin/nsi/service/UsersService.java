package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.users.Users;
import by.belinvest.panel.admin.entity.nsi.users.UsersDirectory;
import by.belinvest.panel.admin.nsi.db.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersDirectory get() {
        System.out.println("###################"+usersRepository.get());
        return usersRepository.get();
    }

    public boolean create(Users roles) {
        return usersRepository.create(roles);
    }

    public boolean update(Users roles) {
        return usersRepository.update(roles);
    }

    public boolean remove(String id) {
        return usersRepository.remove(id);
    }
}

