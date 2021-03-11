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
import org.example.TPaybackAssessmentReport;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.DevelopmentPAR;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.PaybackAssessmentReport;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.FAMILIARIZE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class PaybackAssessmentReportConversionUtil {

    public static PaybackAssessmentReport convertDTOToDatabaseObject(TPaybackAssessmentReport parDTO) {
        PaybackAssessmentReport par = new PaybackAssessmentReport();
        setDatabaseObjectByDTO(parDTO, par);
        return par;
    }

    public static TPaybackAssessmentReport convertDatabaseObjectToDTO(PaybackAssessmentReport par) {
        TPaybackAssessmentReport parDTO = new TPaybackAssessmentReport();
        String author = par.getAuthor();
        if (author != null) {
            parDTO.setAuthor(author);
        }
        String department = par.getDepartment();
        if (department != null) {
            parDTO.setDepartment(department);
        }
        String position = par.getPosition();
        if (position != null) {
            parDTO.setPosition(position);
        }
        LocalDate creationReportDate = par.getCreationReportDate();
        if (creationReportDate != null) {
            parDTO.setCreationReportDate(convertLocalDateToCalendar(creationReportDate));
        }
        LocalDate monitoringTerm = par.getMonitoringTerm();
        if (monitoringTerm != null) {
            parDTO.setMonitoringTerm(convertLocalDateToCalendar(monitoringTerm));
        }
        String productName = par.getProductName();
        if (productName != null) {
            parDTO.setProductName(productName);
        }
        String profitabilityCalc = par.getProfitabilityCalc();
        if (profitabilityCalc != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "profitabilityCalc"),
                    String.class,
                    profitabilityCalc
            );
            parDTO.setProfitabilityCalc(jaxbElement);
        }
        String biName = par.getBiName();
        if (biName != null) {
            parDTO.setBiName(biName);
        }
        String paybackPlanTerm = par.getPaybackPlanTerm();
        if (paybackPlanTerm != null) {
            parDTO.setPaybackPlanTerm(paybackPlanTerm);
        }
        String paybackFactTerm = par.getPaybackFactTerm();
        if (paybackFactTerm != null) {
            parDTO.setPaybackFactTerm(paybackFactTerm);
        }
        LocalDate nextAssessmentDate = par.getNextAssessmentDate();
        if (nextAssessmentDate != null) {
            XMLGregorianCalendar calendarDate = convertLocalDateToCalendar(nextAssessmentDate);
            JAXBElement<XMLGregorianCalendar> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "nextAssessmentDate"),
                    XMLGregorianCalendar.class,
                    calendarDate
            );
            parDTO.setNextAssessmentDate(jaxbElement);
        }
        String decision = par.getDecision();
        if (decision != null) {
            parDTO.setDesicion(decision);
        }
        LocalDate biImplDate = par.getBiImplDate();
        if (biImplDate != null) {
            XMLGregorianCalendar calendarDate = convertLocalDateToCalendar(biImplDate);
            JAXBElement<XMLGregorianCalendar> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "biImplDate"),
                    XMLGregorianCalendar.class,
                    calendarDate
            );
            parDTO.setBiImplDate(jaxbElement);
        }
        if (par.getOnDevelopments() != null) {
            List<DevelopmentPAR> onDevelopments = par.getOnDevelopments();
            List<TBIOnDevelopment> onDevelopmentsDTO = onDevelopments.stream()
                    .map(DevelopmentPARConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());

            TBIOnDevelopmentRec onFamiliarizeRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> familiarizes = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), FAMILIARIZE_PHASE))
                    .collect(Collectors.toList());
            if (!familiarizes.isEmpty()) {
                onFamiliarizeRec.getRecord().addAll(familiarizes);
            }
            parDTO.setOnFamiliarizePAR(onFamiliarizeRec);
        }
        return parDTO;
    }

    public static void setDatabaseObjectByDTO(TPaybackAssessmentReport parDTO, PaybackAssessmentReport par) {
        String author = parDTO.getAuthor();
        if (author != null) {
            par.setAuthor(author);
        }
        String department = parDTO.getDepartment();
        if (department != null) {
            par.setDepartment(department);
        }
        String position = parDTO.getPosition();
        if (position != null) {
            par.setPosition(position);
        }
        XMLGregorianCalendar creationReportDate = parDTO.getCreationReportDate();
        if (creationReportDate != null) {
            par.setCreationReportDate(convertCalendarToLocalDate(creationReportDate));
        }
        XMLGregorianCalendar monitoringTerm = parDTO.getMonitoringTerm();
        if (monitoringTerm != null) {
            par.setMonitoringTerm(convertCalendarToLocalDate(monitoringTerm));
        }
        String productName = parDTO.getProductName();
        if (productName != null) {
            par.setProductName(productName);
        }
        JAXBElement<String> profitabilityCalc = parDTO.getProfitabilityCalc();
        if (profitabilityCalc != null) {
            par.setProfitabilityCalc(profitabilityCalc.getValue());
        }
        String biName = parDTO.getBiName();
        if (biName != null) {
            par.setBiName(biName);
        }
        String paybackPlanTerm = parDTO.getPaybackPlanTerm();
        if (paybackPlanTerm != null) {
            par.setPaybackPlanTerm(paybackPlanTerm);
        }
        String paybackFactTerm = parDTO.getPaybackFactTerm();
        if (paybackFactTerm != null) {
            par.setPaybackFactTerm(paybackFactTerm);
        }
        JAXBElement<XMLGregorianCalendar> nextAssessmentDate = parDTO.getNextAssessmentDate();
        if (nextAssessmentDate != null) {
            par.setNextAssessmentDate(convertCalendarToLocalDate(nextAssessmentDate.getValue()));
        }
        String decision = parDTO.getDesicion();
        if (decision != null) {
            par.setDecision(decision);
        }
        JAXBElement<XMLGregorianCalendar> biImplDate = parDTO.getBiImplDate();
        if (biImplDate != null) {
            par.setBiImplDate(convertCalendarToLocalDate(biImplDate.getValue()));
        }
        setOnDevelopments(parDTO, par);
    }

    public static void setOnDevelopments(TPaybackAssessmentReport parDTO, PaybackAssessmentReport par) {
        List<DevelopmentPAR> onDevelopments = new ArrayList<>();
        addOnFamiliarizes(parDTO, par, onDevelopments);
        List<DevelopmentPAR> existingOnDevelopments = par.getOnDevelopments();
        existingOnDevelopments.clear();
        existingOnDevelopments.addAll(onDevelopments);
    }

    private static void addOnFamiliarizes(TPaybackAssessmentReport parDTO, PaybackAssessmentReport par, List<DevelopmentPAR> onDevelopments) {
        TBIOnDevelopmentRec onFamiliarize = parDTO.getOnFamiliarizePAR();
        if (onFamiliarize != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onFamiliarize.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(FAMILIARIZE_PHASE);
                    DevelopmentPAR onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setPaybackAssessmentReport(par);
                    if (onDevelopment.getDlgEmpName() != null || onDevelopment.getEmpName() != null) {
                        onDevelopments.add(onDevelopment);
                    }
                }
            }
        }
    }

    private static DevelopmentPAR getOnDevelopment(TBIOnDevelopment onDevelopmentDTO) {
        return DevelopmentPARConversionUtil.convertDTOToDatabaseObject(onDevelopmentDTO);
    }

}
