package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;

@Repository
public class BusinessOfferRepositoryImpl extends GenericRepositoryImpl<Long, BusinessOffer> implements BusinessOfferRepository {

    @Override
    public List<Long> getByPreliminaryMonitoringTerm(LocalDate date) {
        String queryString = "SELECT IDBO FROM BO_PROFITABILITYCALCULATION WHERE PRELIMINARYMONITORINGTERM=?";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter(1, date);
        List resultList = query.getResultList();
        List<Long> ids = new ArrayList<>();
        for (Object resultRow : resultList) {
            BigDecimal row = (BigDecimal) resultRow;
            ids.add((long) row.intValue());
        }
        return ids;
    }

    @Override
    public List<Long> getByProfitability(LocalDate date) {
        String queryString = "SELECT bopc.idbo " +
                "FROM bo_profitabilitycalculation bopc " +
                "JOIN list_bi l ON bopc.idbo=l.businessoffer_id " +
                "JOIN bpcard bpc ON l.bpcard_id=bpc.bpid " +
                "WHERE ADD_MONTHS(bpc.changestatusdate,bopc.profitabilityterm)=?";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter(1, date);
        List resultList = query.getResultList();
        List<Long> ids = new ArrayList<>();
        for (Object resultRow : resultList) {
            BigDecimal row = (BigDecimal) resultRow;
            ids.add((long) row.intValue());
        }
        return ids;
    }

}
