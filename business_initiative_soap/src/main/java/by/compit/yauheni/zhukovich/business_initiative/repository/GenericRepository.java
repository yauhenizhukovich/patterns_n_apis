package by.compit.yauheni.zhukovich.business_initiative.repository;

import java.util.List;

public interface GenericRepository<I, T> {

    T getById(I id);

    T persist(T bi);

    List<T> getAll();

}
