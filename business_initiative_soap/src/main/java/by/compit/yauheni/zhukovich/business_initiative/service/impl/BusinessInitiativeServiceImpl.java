package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TBusinessInitiative;
import org.example.TUserInfo;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessInitiativeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.HistoryChangeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.ListRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.service.BusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.ListConversionUtil;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative.BusinessInitiativeConversionUtil;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBusinessInitiativeForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative.BusinessInitiativeConversionUtil.convertDTOToDatabaseObject;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative.BusinessInitiativeConversionUtil.setDatabaseObjectByDTO;

@Service
@Transactional
public class BusinessInitiativeServiceImpl implements BusinessInitiativeService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BusinessInitiativeRepository businessInitiativeRepository;
    private final ListRepository listRepository;
    private final HistoryChangeRepository historyChangeRepository;

    public BusinessInitiativeServiceImpl(
            BusinessInitiativeRepository businessInitiativeRepository,
            ListRepository listRepository,
            HistoryChangeRepository historyChangeRepository) {
        this.businessInitiativeRepository = businessInitiativeRepository;
        this.listRepository = listRepository;
        this.historyChangeRepository = historyChangeRepository;
    }

    @Override
    public Long add(TBusinessInitiative biDTO) {
        BusinessInitiative bi = convertDTOToDatabaseObject(biDTO);
        bi = businessInitiativeRepository.persist(bi);
        ListBI listBI = ListConversionUtil.convertDTOToDatabaseObject(bi);
        listRepository.persist(listBI);
        logger.info("The business initiative was successfully added.");
        return bi.getId();
    }

    @Override
    public TBusinessInitiative getById(Long id) throws NonexistentBusinessInitiativeException {
        BusinessInitiative bi = businessInitiativeRepository.getById(id);
        checkBusinessInitiativeForNotNull(bi);
        return BusinessInitiativeConversionUtil.convertDatabaseObjectToDTO(bi);
    }

    @Override
    public void updateById(TBusinessInitiative biDTO, Long id) throws NonexistentBusinessInitiativeException {
        TUserInfo userInfo = biDTO.getUserInfo();
        if (userInfo != null) {
            historyChangeRepository.initUser(userInfo);
        }
        BusinessInitiative bi = businessInitiativeRepository.getById(id);
        checkBusinessInitiativeForNotNull(bi);
        setDatabaseObjectByDTO(biDTO, bi);
        ListBI listBI = listRepository.getByBusinessInitiativeId(id);
        if (listBI != null) {
            ListConversionUtil.setDatabaseObjectByDTO(bi, listBI);
        }
        logger.info("The business initiative with ID: " + id + " was successfully updated.");
    }

}
