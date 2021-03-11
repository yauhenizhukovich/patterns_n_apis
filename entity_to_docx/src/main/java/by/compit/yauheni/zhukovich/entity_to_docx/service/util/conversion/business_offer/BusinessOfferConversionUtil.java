package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;

import org.example.TBIBusinessGoals;
import org.example.TBIBusinessGoalsRec;
import org.example.TBIImplementationRisk;
import org.example.TBIImplementationRisksRec;
import org.example.TBIPlanGraphic;
import org.example.TBIWork;
import org.example.TBIWorksRec;
import org.example.TBOCommiteeMaterials;
import org.example.TBOCommon;
import org.example.TBOMarketAnalisys;
import org.example.TBOMarketAnalisysRec;
import org.example.TBOProduct;
import org.example.TBOProfitabilityCalculation;
import org.example.TBOTerms;
import org.example.TBusinessOffer;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BOBusinessGoal;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BOWork;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.CommitteeMaterial;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.MarketAnalysis;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.Product;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.ProfitabilityCalculation;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.RelevanceRisk;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.Term;
import by.compit.yauheni.zhukovich.entity_to_docx.service.model.BusinessOfferDTO;

import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.AVAILABILITIES;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.BO_NAME;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.BUSINESS_GOALS;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.DECISION_PROJECT;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.EXPLANATORY_NOTE;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.ID;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.MARKET_ANALYSIS_FILES;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.OCCURRENCE_PROBABILITIES;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRELIMINARY_MONITORING_TERM;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PROCESS_MODEL;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_DESC;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_DEPT;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_PHONE;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_POSITION;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_SUPERVISOR;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_SUPERVISOR_PHONE;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_SUPERVISOR_POS;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PROFITABILITY_CALCULATION;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PROFITABILITY_TERM;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PROPOSED_DEADLINE_ACHIEVE_EFFECT;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PROPOSED_PRODUCT_IMPL_DATE;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.RISK_NAMES;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.STOP_FACTORS;

public class BusinessOfferConversionUtil {

    public static BusinessOfferDTO convertDatabaseObjectToDTO(BusinessOffer bo) {
        Map<String, String> businessOfferFields = new HashMap<>();
        Map<String, List<String>> businessOfferCollections = new HashMap<>();
        String boName = bo.getName();
        if (boName != null) {
            businessOfferFields.put(BO_NAME, boName);
        }
        Long id = bo.getId();
        if (boName != null) {
            businessOfferFields.put(ID, id.toString());
        }
        String productManager = bo.getProductManager();
        if (productManager != null) {
            businessOfferFields.put(PRODUCT_MANAGER, productManager);
        }
        String productManagerDept = bo.getProductManagerDept();
        if (productManagerDept != null) {
            businessOfferFields.put(PRODUCT_MANAGER_DEPT, productManagerDept);
        }
        String productManagerPhone = bo.getProductManagerPhone();
        if (productManagerPhone != null) {
            businessOfferFields.put(PRODUCT_MANAGER_PHONE, productManagerPhone);
        }
        String productManagerPosition = bo.getProductManagerPosition();
        if (productManagerPosition != null) {
            businessOfferFields.put(PRODUCT_MANAGER_POSITION, productManagerPosition);
        }
        String productManagerSupervisor = bo.getProductManagerSupervisor();
        if (productManagerSupervisor != null) {
            businessOfferFields.put(PRODUCT_MANAGER_SUPERVISOR, productManagerSupervisor);
        }
        String productManagerSupervisorPhone = bo.getProductManagerSupervisorPhone();
        if (productManagerSupervisorPhone != null) {
            businessOfferFields.put(PRODUCT_MANAGER_SUPERVISOR_PHONE, productManagerSupervisorPhone);
        }
        String productManagerSupervisorPos = bo.getProductManagerSupervisorPos();
        if (productManagerSupervisorPos != null) {
            businessOfferFields.put(PRODUCT_MANAGER_SUPERVISOR_POS, productManagerSupervisorPos);
        }
        Product product = bo.getProduct();
        if (product != null) {
            String productDesc = product.getProductDesc();
            if (productDesc != null) {
                businessOfferFields.put(PRODUCT_DESC, productDesc);
            }
            String processModel = product.getProcessModel();
            if (processModel != null) {
                businessOfferFields.put(PROCESS_MODEL, processModel);
            }
        }
        CommitteeMaterial committeeMaterial = bo.getCommitteeMaterial();
        if (committeeMaterial != null) {
            String decisionProject = committeeMaterial.getDecisionProject();
            if (decisionProject != null) {
                businessOfferFields.put(DECISION_PROJECT, decisionProject);
            }
            String explanatoryNote = committeeMaterial.getExplanatoryNote();
            if (explanatoryNote != null) {
                businessOfferFields.put(EXPLANATORY_NOTE, explanatoryNote);
            }
        }
        ProfitabilityCalculation profitabilityCalculation = bo.getProfitabilityCalculation();
        if (profitabilityCalculation != null) {
            Month profitabilityTerm = profitabilityCalculation.getProfitabilityTerm();
            if (profitabilityTerm != null) {
                businessOfferFields.put(PROFITABILITY_TERM, String.valueOf(profitabilityTerm.getValue()));
            }
            String profitabilityCalculationText = profitabilityCalculation.getProfitabilityCalculation();
            if (profitabilityCalculationText != null) {
                businessOfferFields.put(PROFITABILITY_CALCULATION, profitabilityCalculationText);
            }
            LocalDate preliminaryMonitoringTerm = profitabilityCalculation.getPreliminaryMonitoringTerm();
            if (preliminaryMonitoringTerm != null) {
                businessOfferFields.put(PRELIMINARY_MONITORING_TERM, preliminaryMonitoringTerm.toString());
            }
        }
        Term term = bo.getTerm();
        if (term != null) {
            LocalDate proposedProductImplDate = term.getProposedProductImplDate();
            if (proposedProductImplDate != null) {
                businessOfferFields.put(PROPOSED_PRODUCT_IMPL_DATE, proposedProductImplDate.toString());
            }
            LocalDate proposedDeadlineAchieveEffect = term.getProposedDeadlineAchieveEffect();
            if (proposedDeadlineAchieveEffect != null) {
                businessOfferFields.put(PROPOSED_DEADLINE_ACHIEVE_EFFECT, proposedDeadlineAchieveEffect.toString());
            }
        }
        List<BOBusinessGoal> businessGoals = bo.getBusinessGoals();
        if (businessGoals != null) {
            List<String> stringBusinessGoals = businessGoals.stream()
                    .map(BOBusinessGoal::getGoalsName)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            businessOfferCollections.put(BUSINESS_GOALS, stringBusinessGoals);
        }
        List<MarketAnalysis> marketAnalysises = bo.getMarketAnalysises();
        if (marketAnalysises != null) {
            List<String> marketAnalysisFiles = marketAnalysises.stream()
                    .map(MarketAnalysis::getMarketAnalysisFile)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            businessOfferCollections.put(MARKET_ANALYSIS_FILES, marketAnalysisFiles);
        }
        List<RelevanceRisk> relevanceRisks = bo.getRelevanceRisks();
        if (relevanceRisks != null) {
            List<String> availabilities = relevanceRisks.stream()
                    .map(RelevanceRisk::getAvailability)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            businessOfferCollections.put(AVAILABILITIES, availabilities);
            List<String> occurenceProbabilities = relevanceRisks.stream()
                    .map(RelevanceRisk::getOccurrenceProbability)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            businessOfferCollections.put(OCCURRENCE_PROBABILITIES, occurenceProbabilities);
            List<String> riskNames = relevanceRisks.stream()
                    .map(RelevanceRisk::getProductRiskDesc)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            businessOfferCollections.put(RISK_NAMES, riskNames);
            List<String> stopFactors = relevanceRisks.stream()
                    .map(RelevanceRisk::getRiskMinimProposal)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            businessOfferCollections.put(STOP_FACTORS, stopFactors);
        }
        BusinessOfferDTO businessOfferDTO = new BusinessOfferDTO();
        businessOfferDTO.setCollections(businessOfferCollections);
        businessOfferDTO.setSimpleFields(businessOfferFields);
        return businessOfferDTO;
    }

    public static BusinessOffer convertDTOToDatabaseObject(TBusinessOffer boDTO) {
        BusinessOffer bo = new BusinessOffer();
        setDatabaseObjectByDTO(boDTO, bo);
        return bo;
    }

    public static void setDatabaseObjectByDTO(TBusinessOffer boDTO, BusinessOffer bo) {
        setSimpleFields(boDTO, bo);
        setCommon(boDTO, bo);
        setBusinessGoals(boDTO, bo);
        setProduct(boDTO, bo);
        setProfitabilityCalculation(boDTO, bo);
        setMarketAnalysis(boDTO, bo);
        setRelevance(boDTO, bo);
        setTerm(boDTO, bo);
        setWorks(boDTO, bo);
        setCommitteeMaterial(boDTO, bo);
    }

    private static void setMarketAnalysis(TBusinessOffer boDTO, BusinessOffer bo) {
        TBOMarketAnalisysRec marketAnalisysRec = boDTO.getMarketAnalisysBlock();
        if (marketAnalisysRec != null) {
            List<TBOMarketAnalisys> marketAnalisysDTO = marketAnalisysRec.getRecords();
            if (marketAnalisysDTO != null) {
                List<MarketAnalysis> marketAnalyses = marketAnalisysDTO.stream()
                        .map(MarketAnalysisConversionUtil::convertDTOToDatabaseObject)
                        .peek(businessGoal -> businessGoal.setBusinessOffer(bo))
                        .collect(Collectors.toList());
                List<MarketAnalysis> existingMarketAnalyses = bo.getMarketAnalysises();
                existingMarketAnalyses.clear();
                existingMarketAnalyses.addAll(marketAnalyses);
            }
        }
    }

    public static void setSimpleFields(TBusinessOffer boDTO, BusinessOffer bo) {
        String productManager = boDTO.getProductManager();
        if (productManager != null) {
            bo.setProductManager(productManager);
        }
        String productManagerPosition = boDTO.getProductManagerPosition();
        if (productManagerPosition != null) {
            bo.setProductManagerPosition(productManagerPosition);
        }
        String productManagerPhone = boDTO.getProductManagerPhone();
        if (productManagerPhone != null) {
            bo.setProductManagerPhone(productManagerPhone);
        }
        String productManagerDept = boDTO.getProductManagerDept();
        if (productManagerDept != null) {
            bo.setProductManagerDept(productManagerDept);
        }
        String productManagerSupervisor = boDTO.getProductManagerSupervisor();
        if (productManagerSupervisor != null) {
            bo.setProductManagerSupervisor(productManagerSupervisor);
        }
        String productManagerSupervisorPos = boDTO.getProductManagerSupervisorPos();
        if (productManagerSupervisorPos != null) {
            bo.setProductManagerSupervisorPos(productManagerSupervisorPos);
        }
        String productManagerSupervisorPhone = boDTO.getProductManagerSupervisorPhone();
        if (productManagerSupervisorPhone != null) {
            bo.setProductManagerSupervisorPhone(productManagerSupervisorPhone);
        }
    }

    private static void setCommon(TBusinessOffer boDTO, BusinessOffer bo) {
        if (boDTO.getCommon() != null) {
            TBOCommon commonDTO = boDTO.getCommon();
            if (commonDTO.getBoName() != null) {
                bo.setName(commonDTO.getBoName());
            }
            if (commonDTO.getBoStatus() != null) {
                bo.setStatus(commonDTO.getBoStatus());
            }
        }
    }

    private static void setRelevance(BusinessOffer bo, TBusinessOffer boDTO) {

    }

    private static void setBusinessGoals(BusinessOffer bo, TBusinessOffer boDTO) {
    }

    private static void setWorks(BusinessOffer bo, TBusinessOffer boDTO) {
        List<BOWork> works = bo.getWorks();
        if (works != null) {
            List<TBIWork> worksDTO = works.stream()
                    .map(WorkConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIPlanGraphic planGraphic = new TBIPlanGraphic();
            TBIWorksRec worksRec = new TBIWorksRec();
            worksRec.getWorks().addAll(worksDTO);
            planGraphic.setWorksBlock(worksRec);
            boDTO.setPlanGraphic(planGraphic);
        }
    }

    private static void setCommitteeMaterial(TBusinessOffer boDTO, BusinessOffer bo) {
        JAXBElement<TBOCommiteeMaterials> committeeMaterials = boDTO.getCommiteeMaterials();
        if (committeeMaterials != null) {
            TBOCommiteeMaterials committeeMaterialDTO = committeeMaterials.getValue();
            CommitteeMaterial committeeMaterial = CommitteeMaterialConversionUtil.convertDTOToDatabaseObject(committeeMaterialDTO);
            committeeMaterial.setBusinessOffer(bo);
            bo.setCommitteeMaterial(committeeMaterial);
        }
    }

    private static void setWorks(TBusinessOffer boDTO, BusinessOffer bo) {
        TBIPlanGraphic planGraphic = boDTO.getPlanGraphic();
        if (planGraphic != null) {
            TBIWorksRec worksRec = planGraphic.getWorksBlock();
            if (worksRec != null) {
                List<TBIWork> worksDTO = worksRec.getWorks();
                List<BOWork> works = worksDTO.stream()
                        .map(WorkConversionUtil::convertDTOToDatabaseObject)
                        .peek(work -> work.setBusinessOffer(bo))
                        .collect(Collectors.toList());
                List<BOWork> existingWorks = bo.getWorks();
                existingWorks.clear();
                existingWorks.addAll(works);
            }
        }
    }

    private static void setTerm(TBusinessOffer boDTO, BusinessOffer bo) {
        TBOTerms termDTO = boDTO.getTerms();
        if (termDTO != null) {
            Term term = TermConversionUtil.convertDTOToDatabaseObject(termDTO);
            term.setBusinessOffer(bo);
            bo.setTerm(term);
        }
    }

    private static void setRelevance(TBusinessOffer boDTO, BusinessOffer bo) {
        TBIImplementationRisksRec implementationRisksRec = boDTO.getRelevance();
        if (implementationRisksRec != null) {
            List<TBIImplementationRisk> implementationRisksDTO = implementationRisksRec.getImplementationRisk();
            if (implementationRisksDTO != null) {
                List<RelevanceRisk> implementationRisks = implementationRisksDTO.stream()
                        .map(RelevanceRiskConversionUtil::convertDTOToDatabaseObject)
                        .peek(implementationRisk -> implementationRisk.setBusinessOffer(bo))
                        .collect(Collectors.toList());
                List<RelevanceRisk> existingImplementationRisks = bo.getRelevanceRisks();
                existingImplementationRisks.clear();
                existingImplementationRisks.addAll(implementationRisks);
            }
        }
    }

    private static void setProfitabilityCalculation(TBusinessOffer boDTO, BusinessOffer bo) {
        TBOProfitabilityCalculation profitabilityCalculationDTO = boDTO.getProfitabilityCalculationBlock();
        if (profitabilityCalculationDTO != null) {
            ProfitabilityCalculation profitabilityCalculation =
                    ProfitabilityCalculationConversionUtil.convertDTOToDatabaseObject(profitabilityCalculationDTO);
            profitabilityCalculation.setBusinessOffer(bo);
            bo.setProfitabilityCalculation(profitabilityCalculation);
        }
    }

    private static void setProduct(TBusinessOffer boDTO, BusinessOffer bo) {
        TBOProduct productDTO = boDTO.getProduct();
        if (productDTO != null) {
            Product product = ProductConversionUtil.convertDTOToDatabaseObject(productDTO);
            product.setBusinessOffer(bo);
            bo.setProduct(product);
        }
    }

    private static void setBusinessGoals(TBusinessOffer boDTO, BusinessOffer bo) {
        TBIBusinessGoalsRec businessGoalsRec = boDTO.getBusinessGoalsBlock();
        if (businessGoalsRec != null) {
            List<TBIBusinessGoals> businessGoalsDTO = businessGoalsRec.getBusinessGoals();
            if (businessGoalsDTO != null) {
                List<BOBusinessGoal> businessGoals = businessGoalsDTO.stream()
                        .map(BusinessGoalConversionUtil::convertDTOToDatabaseObject)
                        .peek(businessGoal -> businessGoal.setBusinessOffer(bo))
                        .collect(Collectors.toList());
                List<BOBusinessGoal> existingBusinessGoals = bo.getBusinessGoals();
                existingBusinessGoals.clear();
                existingBusinessGoals.addAll(businessGoals);
            }
        }
    }

}
