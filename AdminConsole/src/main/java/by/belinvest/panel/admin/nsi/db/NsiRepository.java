package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;

public interface NsiRepository {

    DirectoryDTO get();

    boolean update(Object o);

    boolean remove(String id);

    boolean create(Object o);

}
