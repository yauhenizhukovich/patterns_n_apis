package by.compit.yauheni.zhukovich.entity_to_docx.repository;

public interface GenericRepository<I, T> {
    T getById(I id);
}

