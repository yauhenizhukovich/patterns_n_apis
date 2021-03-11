package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessInitiativeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.DevelopmentBusinessInitiativeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.DevelopmentBusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBusinessInitiativeForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative.DevelopmentBusinessInitiativeConversionUtil.convertDTOToDatabaseObject;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative.DevelopmentBusinessInitiativeConversionUtil.convertDatabaseObjectToDTO;

@Service
@Transactional
public class DevelopmentBusinessInitiativeServiceImpl implements DevelopmentBusinessInitiativeService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BusinessInitiativeRepository businessInitiativeRepository;
    private final DevelopmentBusinessInitiativeRepository developmentBusinessInitiativeRepository;

    public DevelopmentBusinessInitiativeServiceImpl(BusinessInitiativeRepository businessInitiativeRepository, DevelopmentBusinessInitiativeRepository developmentBusinessInitiativeRepository) {
        this.businessInitiativeRepository = businessInitiativeRepository;
        this.developmentBusinessInitiativeRepository = developmentBusinessInitiativeRepository;
    }

    @Override
    public TBIOnDevelopmentRec add(TBIOnDevelopmentRec onDevelopmentRec, Long biId) throws NonexistentBusinessInitiativeException {
        BusinessInitiative bi = businessInitiativeRepository.getById(biId);
        checkBusinessInitiativeForNotNull(bi);
        List<DevelopmentBusinessInitiative> onDevelopments = bi.getOnDevelopments();
        List<TBIOnDevelopment> onDevelopmentsDTO = onDevelopmentRec.getRecord();
        TBIOnDevelopmentRec addedOnDevelopmentRec = new TBIOnDevelopmentRec();
        for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
            DevelopmentBusinessInitiative onDevelopment = convertDTOToDatabaseObject(onDevelopmentDTO);
            onDevelopment.setBusinessInitiative(bi);
            onDevelopment = developmentBusinessInitiativeRepository.persist(onDevelopment);
            onDevelopments.add(onDevelopment);
            addedOnDevelopmentRec.getRecord().add(convertDatabaseObjectToDTO(onDevelopment));
        }
        logger.info("The \"on development(s)\" was successfully added to business initiative with ID: " + biId);
        return addedOnDevelopmentRec;
    }

    @Override
    public List<TBIOnDevelopment> getDevelopmentHistory(Long biId, String devPhase) throws NonexistentBusinessInitiativeException {
        BusinessInitiative bi = businessInitiativeRepository.getById(biId);
        checkBusinessInitiativeForNotNull(bi);
        List<DevelopmentBusinessInitiative> onDevelopments = bi.getOnDevelopments();
        List<TBIOnDevelopment> onDevelopmentsDTO = new ArrayList<>();
        for (DevelopmentBusinessInitiative onDevelopment : onDevelopments) {
            if (onDevelopment.getDevPhase().equals(devPhase)) {
                TBIOnDevelopment onDevelopmentDTO = convertDatabaseObjectToDTO(onDevelopment);
                onDevelopmentsDTO.add(onDevelopmentDTO);
            }
        }
        return onDevelopmentsDTO;
    }

}
