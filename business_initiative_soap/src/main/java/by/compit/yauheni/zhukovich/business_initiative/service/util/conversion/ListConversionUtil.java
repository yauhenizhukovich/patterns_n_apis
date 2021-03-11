package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion;

import java.time.LocalDate;

import org.example.TList;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.BankingProductCard;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class ListConversionUtil {

    public static ListBI convertDTOToDatabaseObject(BusinessInitiative bi) {
        ListBI listBI = new ListBI();
        setDatabaseObjectByDTO(bi, listBI);
        return listBI;
    }

    public static void setDatabaseObjectByDTO(BusinessInitiative bi, ListBI listBI) {
        String name = bi.getName();
        if (name != null) {
            listBI.setBiName(name);
        }
        Long id = bi.getId();
        if (id != null) {
            listBI.setBiId(id);
        }
        LocalDate date = bi.getDate();
        if (date != null) {
            listBI.setBiDate(date);
        }
        String status = bi.getStatus();
        if (status != null) {
            listBI.setBiStatus(status);
        }
        LocalDate businessAppImplDate = bi.getBusinessAppImplDate();
        if (businessAppImplDate != null) {
            listBI.setBoDate(businessAppImplDate);
        }
    }

    public static void setDatabaseObjectByDTO(BusinessOffer bo, ListBI listBI) {
        String name = bo.getName();
        if (name != null) {
            listBI.setBoName(name);
        }
        Long id = bo.getId();
        if (id != null) {
            listBI.setBoId(id);
        }
        String status = bo.getStatus();
        if (status != null) {
            listBI.setBoStatus(status);
        }
    }

    public static void setDatabaseObjectByDTO(BankingProductCard bpc, ListBI listBI) {
        String name = bpc.getProductName();
        if (name != null) {
            listBI.setBpcName(name);
        }
        Long bpcId = bpc.getId();
        if (bpcId != null) {
            listBI.setBpcId(bpcId);
        }
        String status = bpc.getProductStatus();
        if (status != null) {
            listBI.setBpcStatus(status);
        }
    }

    public static void updateByBusinessOffer(BusinessOffer bo, BusinessInitiative bi, ListBI listBI) {
        String name = bo.getName();
        if (name != null) {
            listBI.setBoName(name);
        }
        Long id = bo.getId();
        if (id != null) {
            listBI.setBoId(id);
        }
        LocalDate businessAppImplDate = bi.getBusinessAppImplDate();
        if (businessAppImplDate != null) {
            listBI.setBoDate(businessAppImplDate);
        }
        String status = bo.getStatus();
        if (status != null) {
            listBI.setBoStatus(status);
        }
    }

    public static void updateByBankingProductCard(BankingProductCard bpc, ListBI listBI) {
        String productName = bpc.getProductName();
        if (productName != null) {
            listBI.setBpcName(productName);
        }
        Long bpcId = bpc.getId();
        if (bpcId != null) {
            listBI.setBpcId(bpcId);
        }
        String productStatus = bpc.getProductStatus();
        if (productStatus != null) {
            listBI.setBpcStatus(productStatus);
        }
    }

    public static TList convertDatabaseObjectToDTO(ListBI list) {
        TList listDTO = new TList();
        Long biId = list.getBiId();
        if (biId != null) {
            listDTO.setBusinessInitiativeId(String.valueOf(biId));
        }
        Long boId = list.getBoId();
        if (boId != null) {
            listDTO.setBusinessOfferId(String.valueOf(boId));
        }
        Long bpcId = list.getBpcId();
        if (bpcId != null) {
            listDTO.setBPCardId(String.valueOf(bpcId));
        }
        LocalDate biDate = list.getBiDate();
        if (biDate != null) {
            listDTO.setBusinessInitiativeDate(convertLocalDateToCalendar(biDate));
        }
        LocalDate boDate = list.getBoDate();
        if (boDate != null) {
            listDTO.setBusinessOfferDate(convertLocalDateToCalendar(boDate));
        }
        String biName = list.getBiName();
        if (biName != null) {
            listDTO.setBusinessInitiativeName(biName);
        }
        String biStatus = list.getBiStatus();
        if (biStatus != null) {
            listDTO.setBusinessInitiativeStatus(biStatus);
        }
        String boName = list.getBoName();
        if (boName != null) {
            listDTO.setBusinessOfferName(boName);
        }
        String boStatus = list.getBoStatus();
        if (boStatus != null) {
            listDTO.setBusinessOfferStatus(boStatus);
        }
        String bpcName = list.getBpcName();
        if (bpcName != null) {
            listDTO.setBPCardProductName(bpcName);
        }
        String bpcStatus = list.getBpcStatus();
        if (bpcStatus != null) {
            listDTO.setBPCardProductStatus(bpcStatus);
        }
        Long id = list.getId();
        if (id != null) {
            listDTO.setListRecordId(String.valueOf(id));
        }
        return listDTO;
    }

}
