package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.banking_product_card;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.example.TBEmployeeType;
import org.example.TBPCommon;
import org.example.TBankingProductCard;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.BankingProductCard;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.ConsultDept;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.Dept;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.ProductCardDistribution;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class BankingProductCardConversionUtil {

    public static BankingProductCard convertDTOToDatabaseObject(TBankingProductCard bpcDTO) {
        BankingProductCard bpc = new BankingProductCard();
        setDatabaseObjectByDTO(bpcDTO, bpc);
        return bpc;
    }

    public static TBankingProductCard convertDatabaseObjectToDTO(BankingProductCard bpc) {
        TBankingProductCard bpcDTO = new TBankingProductCard();
        TBPCommon common = new TBPCommon();
        setCommon(bpc, bpcDTO, common);
        List<ProductCardDistribution> productCardDistributions = bpc.getProductCardDistributions();
        List<TBEmployeeType> productCardDistributionsDTO = productCardDistributions.stream()
                .map(ProductCardDistributionConversionUtil::convertDatabaseObjectToDTO)
                .collect(Collectors.toList());
        bpcDTO.getProductCardDistribution().addAll(productCardDistributionsDTO);
        return bpcDTO;
    }

    public static void setDatabaseObjectByDTO(TBankingProductCard bpcDTO, BankingProductCard bpc) {
        TBPCommon common = bpcDTO.getCommon();
        if (common != null) {
            setCommon(bpc, common);
        }
        List<TBEmployeeType> productCardDistributionsDTO = bpcDTO.getProductCardDistribution();
        if (productCardDistributionsDTO != null) {
            List<ProductCardDistribution> productCardDistributions = productCardDistributionsDTO.stream()
                    .map(ProductCardDistributionConversionUtil::convertDTOToDatabaseObject)
                    .peek(productCardDistribution -> productCardDistribution.setBankingProductCard(bpc))
                    .collect(Collectors.toList());
            List<ProductCardDistribution> existingProductCardDistributions = bpc.getProductCardDistributions();
            existingProductCardDistributions.clear();
            existingProductCardDistributions.addAll(productCardDistributions);
        }
    }

    private static void setCommon(BankingProductCard bpc, TBankingProductCard bpcDTO, TBPCommon common) {
        common.setBpID(String.valueOf(bpc.getId()));
        if (bpc.getProductName() != null) {
            common.setProductName(bpc.getProductName());
        }
        if (bpc.getCommonProduct() != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "commonProductChard"), String.class, bpc.getCommonProduct()
            );
            common.setCommonProductChars(jaxbElement);
        }
        String productStatus = bpc.getProductStatus();
        if (productStatus != null) {
            common.setProductStatus(productStatus);
        }
        LocalDate changeStatusDate = bpc.getChangeStatusDate();
        if (changeStatusDate != null) {
            common.setChangeStatusDate(convertLocalDateToCalendar(changeStatusDate));
        }
        String productAdvantage = bpc.getProductAdvantage();
        if (productAdvantage != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "productAdvantages"), String.class, productAdvantage
            );
            common.setProductAdvantages(jaxbElement);
        }
        String mainProductParam = bpc.getMainProductParam();
        if (mainProductParam != null) {
            common.setMainProductParams(mainProductParam);
        }

        List<Dept> depts = bpc.getDepts();
        List<String> deptNames = depts.stream()
                .map(Dept::getDeptName)
                .collect(Collectors.toList());
        common.getDeptName().addAll(deptNames);
        if (bpc.getDocsForm() != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "docsForms"), String.class, bpc.getDocsForm()
            );
            common.setDocsForms(jaxbElement);
        }
        if (bpc.getLpaBank() != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "lpaBanks"), String.class, bpc.getLpaBank()
            );
            common.setLpaBanks(jaxbElement);
        }
        if (bpc.getAddMaterial() != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "addMaterials"), String.class, bpc.getAddMaterial()
            );
            common.setAddMaterials(jaxbElement);
        }

        List<ConsultDept> consultDepts = bpc.getConsultDepts();
        List<String> consultDeptNames = consultDepts.stream()
                .map(ConsultDept::getConsultDeptName)
                .collect(Collectors.toList());
        common.getConsaltDeptName().

                addAll(consultDeptNames);
        bpcDTO.setCommon(common);
    }

    private static void setCommon(BankingProductCard bpc, TBPCommon common) {
        String productName = common.getProductName();
        if (productName != null) {
            bpc.setProductName(productName);
        }
        JAXBElement<String> commonProductChars = common.getCommonProductChars();
        if (commonProductChars != null) {
            bpc.setCommonProduct(commonProductChars.getValue());
        }
        String productStatus = common.getProductStatus();
        if (productStatus != null) {
            bpc.setProductStatus(productStatus);
        }
        XMLGregorianCalendar changeStatusDate = common.getChangeStatusDate();
        if (changeStatusDate != null) {
            bpc.setChangeStatusDate(convertCalendarToLocalDate(changeStatusDate));
        }
        JAXBElement<String> productAdvantages = common.getProductAdvantages();
        if (productAdvantages != null) {
            bpc.setProductAdvantage(productAdvantages.getValue());
        }
        String mainProductParams = common.getMainProductParams();
        if (mainProductParams != null) {
            bpc.setMainProductParam(mainProductParams);
        }
        JAXBElement<String> docsForms = common.getDocsForms();
        if (docsForms != null) {
            bpc.setDocsForm(docsForms.getValue());
        }
        JAXBElement<String> lpaBanks = common.getLpaBanks();
        if (lpaBanks != null) {
            bpc.setLpaBank(lpaBanks.getValue());
        }
        JAXBElement<String> addMaterials = common.getAddMaterials();
        if (addMaterials != null) {
            bpc.setAddMaterial(addMaterials.getValue());
        }
        if (common.getDeptName() != null) {
            List<String> deptNames = common.getConsaltDeptName();
            List<Dept> depts = deptNames.stream()
                    .map(BankingProductCardConversionUtil::convertDept)
                    .peek(dept -> dept.setBankingProductCard(bpc))
                    .collect(Collectors.toList());
            List<Dept> existingDepts = bpc.getDepts();
            existingDepts.clear();
            existingDepts.addAll(depts);
        }
        if (common.getConsaltDeptName() != null) {
            List<String> consultDeptNames = common.getConsaltDeptName();
            List<ConsultDept> consultDepts = consultDeptNames.stream()
                    .map(BankingProductCardConversionUtil::convertConsultDept)
                    .peek(consultDept -> consultDept.setBankingProductCard(bpc))
                    .collect(Collectors.toList());
            List<ConsultDept> existingConsultDepts = bpc.getConsultDepts();
            existingConsultDepts.clear();
            existingConsultDepts.addAll(consultDepts);
        }
    }

    private static Dept convertDept(String deptName) {
        Dept dept = new Dept();
        dept.setDeptName(deptName);
        return dept;
    }

    private static ConsultDept convertConsultDept(String consultDeptName) {
        ConsultDept consultDept = new ConsultDept();
        consultDept.setConsultDeptName(consultDeptName);
        return consultDept;
    }

}