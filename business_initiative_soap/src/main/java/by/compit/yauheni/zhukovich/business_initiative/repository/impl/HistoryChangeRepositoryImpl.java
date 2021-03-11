package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.example.TUserInfo;
import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.business_initiative.repository.HistoryChangeRepository;

@Repository
public class HistoryChangeRepositoryImpl implements HistoryChangeRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void initUser(TUserInfo userInfo) {
        String comment = userInfo.getComment();
        String username = userInfo.getUsername();
        String queryString = "begin ctl.utl_ctl.Init(:username, :comment);end;";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter("username", username);
        query.setParameter("comment", comment);
        query.executeUpdate();
    }

}
