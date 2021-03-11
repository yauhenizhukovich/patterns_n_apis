package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.example.TMonitorProductReport;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.DevelopmentMPR;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.MonitorProductReport;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.FAMILIARIZE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class MonitorProductReportConversionUtil {

    public static MonitorProductReport convertDTOToDatabaseObject(TMonitorProductReport mprDTO) {
        MonitorProductReport mpr = new MonitorProductReport();
        setDatabaseObjectByDTO(mprDTO, mpr);
        return mpr;
    }

    public static TMonitorProductReport convertDatabaseObjectToDTO(MonitorProductReport mpr) {
        TMonitorProductReport mprDTO = new TMonitorProductReport();
        String department = mpr.getDepartment();
        if (department != null) {
            mprDTO.setDepartment(department);
        }
        String author = mpr.getAuthor();
        if (author != null) {
            mprDTO.setAuthor(author);
        }
        String position = mpr.getPosition();
        if (position != null) {
            mprDTO.setPosition(position);
        }
        LocalDate creationReportDate = mpr.getCreationReportDate();
        if (creationReportDate != null) {
            mprDTO.setCreationReportDate(convertLocalDateToCalendar(creationReportDate));
        }
        LocalDate monitoringTerm = mpr.getMonitoringTerm();
        if (monitoringTerm != null) {
            mprDTO.setMonitoringTerm(convertLocalDateToCalendar(monitoringTerm));
        }
        String productName = mpr.getProductName();
        if (productName != null) {
            mprDTO.setProductName(productName);
        }
        String biName = mpr.getBiName();
        if (biName != null) {
            mprDTO.setBiName(biName);
        }
        String profitabilityCalc = mpr.getProfitabilityCalc();
        if (profitabilityCalc != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "profitabilityCalc"),
                    String.class,
                    profitabilityCalc
            );
            mprDTO.setProfitabilityCalc(jaxbElement);
        }
        String paybackTerm = mpr.getPaybackTerm();
        if (paybackTerm != null) {
            mprDTO.setPaybackTerm(paybackTerm);
        }
        String productMonitoringReport = mpr.getProductMonitoringReport();
        if (productMonitoringReport != null) {
            mprDTO.setProductMonitoringReport(productMonitoringReport);
        }
        LocalDate nextMonitoringDate = mpr.getNextMonitoringDate();
        if (nextMonitoringDate != null) {
            XMLGregorianCalendar calendarDate = convertLocalDateToCalendar(nextMonitoringDate);
            JAXBElement<XMLGregorianCalendar> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "nextMonitoringDate"),
                    XMLGregorianCalendar.class,
                    calendarDate
            );
            mprDTO.setNextMonitoringDate(jaxbElement);
        }
        String decision = mpr.getDecision();
        if (decision != null) {
            mprDTO.setDesicion(decision);
        }
        LocalDate biImplDate = mpr.getBiImplDate();
        if (biImplDate != null) {
            XMLGregorianCalendar calendarDate = convertLocalDateToCalendar(biImplDate);
            JAXBElement<XMLGregorianCalendar> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "biImplDate"),
                    XMLGregorianCalendar.class,
                    calendarDate
            );
            mprDTO.setBiImplDate(jaxbElement);
        }
        if (mpr.getOnDevelopments() != null) {
            List<DevelopmentMPR> onDevelopments = mpr.getOnDevelopments();
            List<TBIOnDevelopment> onDevelopmentsDTO = onDevelopments.stream()
                    .map(DevelopmentMPRConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());

            TBIOnDevelopmentRec onFamiliarizeRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> familiarizes = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), FAMILIARIZE_PHASE))
                    .collect(Collectors.toList());
            if (!familiarizes.isEmpty()) {
                onFamiliarizeRec.getRecord().addAll(familiarizes);
            }
            mprDTO.setOnFamiliarizeMPR(onFamiliarizeRec);
        }
        return mprDTO;
    }

    public static void setDatabaseObjectByDTO(TMonitorProductReport mprDTO, MonitorProductReport mpr) {
        String department = mprDTO.getDepartment();
        if (department != null) {
            mpr.setDepartment(department);
        }
        String author = mprDTO.getAuthor();
        if (author != null) {
            mpr.setAuthor(author);
        }
        String position = mprDTO.getPosition();
        if (position != null) {
            mpr.setPosition(position);
        }
        XMLGregorianCalendar creationReportDate = mprDTO.getCreationReportDate();
        if (creationReportDate != null) {
            mpr.setCreationReportDate(convertCalendarToLocalDate(creationReportDate));
        }
        XMLGregorianCalendar monitoringTerm = mprDTO.getMonitoringTerm();
        if (monitoringTerm != null) {
            mpr.setMonitoringTerm(convertCalendarToLocalDate(monitoringTerm));
        }
        String productName = mprDTO.getProductName();
        if (productName != null) {
            mpr.setProductName(productName);
        }
        String biName = mprDTO.getBiName();
        if (biName != null) {
            mpr.setBiName(biName);
        }
        JAXBElement<String> profitabilityCalc = mprDTO.getProfitabilityCalc();
        if (profitabilityCalc != null) {
            mpr.setProfitabilityCalc(profitabilityCalc.getValue());
        }
        String paybackTerm = mprDTO.getPaybackTerm();
        if (paybackTerm != null) {
            mpr.setPaybackTerm(paybackTerm);
        }
        String productMonitoringReport = mprDTO.getProductMonitoringReport();
        if (productMonitoringReport != null) {
            mpr.setProductMonitoringReport(productMonitoringReport);
        }
        JAXBElement<XMLGregorianCalendar> nextMonitoringDate = mprDTO.getNextMonitoringDate();
        if (nextMonitoringDate != null) {
            mpr.setNextMonitoringDate(convertCalendarToLocalDate(nextMonitoringDate.getValue()));
        }
        String decision = mprDTO.getDesicion();
        if (decision != null) {
            mpr.setDecision(decision);
        }
        JAXBElement<XMLGregorianCalendar> biImplDate = mprDTO.getBiImplDate();
        if (biImplDate != null) {
            mpr.setBiImplDate(convertCalendarToLocalDate(biImplDate.getValue()));
        }
        setOnDevelopments(mprDTO, mpr);
    }

    public static void setOnDevelopments(TMonitorProductReport mprDTO, MonitorProductReport mpr) {
        List<DevelopmentMPR> onDevelopments = new ArrayList<>();
        addOnFamiliarizes(mprDTO, mpr, onDevelopments);
        List<DevelopmentMPR> existingOnDevelopments = mpr.getOnDevelopments();
        existingOnDevelopments.clear();
        existingOnDevelopments.addAll(onDevelopments);
    }

    private static void addOnFamiliarizes(TMonitorProductReport mprDTO, MonitorProductReport mpr, List<DevelopmentMPR> onDevelopments) {
        TBIOnDevelopmentRec onFamiliarize = mprDTO.getOnFamiliarizeMPR();
        if (onFamiliarize != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onFamiliarize.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(FAMILIARIZE_PHASE);
                    DevelopmentMPR onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setMonitorProductReport(mpr);
                    if (onDevelopment.getDlgEmpName() != null || onDevelopment.getEmpName() != null) {
                        onDevelopments.add(onDevelopment);
                    }
                }
            }
        }
    }

    private static DevelopmentMPR getOnDevelopment(TBIOnDevelopment onDevelopmentDTO) {
        return DevelopmentMPRConversionUtil.convertDTOToDatabaseObject(onDevelopmentDTO);
    }

}
