package by.compit.yauheni.zhukovich.business_initiative.repository;

import java.time.LocalDate;
import java.util.List;

import org.example.TBusinessOffer;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;

public interface BusinessOfferRepository extends GenericRepository<Long, BusinessOffer> {

    List<Long> getByPreliminaryMonitoringTerm(LocalDate date);

    List<Long> getByProfitability(LocalDate date);

}
