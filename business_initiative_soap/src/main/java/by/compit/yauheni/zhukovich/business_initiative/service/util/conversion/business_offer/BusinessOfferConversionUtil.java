package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.example.TBIBusinessGoals;
import org.example.TBIBusinessGoalsRec;
import org.example.TBIImplementationRisk;
import org.example.TBIImplementationRisksRec;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
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

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BOBusinessGoal;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BOWork;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.CommitteeMaterial;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.DevelopmentBusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.MarketAnalysis;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.Product;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.ProfitabilityCalculation;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.RelevanceRisk;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.Term;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.APPROVE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_CURATOR_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_PRODUCT_TEAM_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.OPINION_PHASE;

public class BusinessOfferConversionUtil {

    public static BusinessOffer convertDTOToDatabaseObject(TBusinessOffer boDTO) {
        BusinessOffer bo = new BusinessOffer();
        setDatabaseObjectByDTO(boDTO, bo);
        return bo;
    }

    public static TBusinessOffer convertDatabaseObjectToDTO(BusinessOffer bo) {
        TBusinessOffer boDTO = new TBusinessOffer();
        if (bo.getProductManager() != null) {
            boDTO.setProductManager(bo.getProductManager());
        }
        if (bo.getProductManagerDept() != null) {
            boDTO.setProductManagerDept(bo.getProductManagerDept());
        }
        if (bo.getProductManagerPhone() != null) {
            boDTO.setProductManagerPhone(bo.getProductManagerPhone());
        }
        if (bo.getProductManagerPosition() != null) {
            boDTO.setProductManagerPosition(bo.getProductManagerPosition());
        }
        if (bo.getProductManagerSupervisor() != null) {
            boDTO.setProductManagerSupervisor(bo.getProductManagerSupervisor());
        }
        if (bo.getProductManagerSupervisorPhone() != null) {
            boDTO.setProductManagerSupervisorPhone(bo.getProductManagerSupervisorPhone());
        }
        if (bo.getProductManagerSupervisorPos() != null) {
            boDTO.setProductManagerSupervisorPos(bo.getProductManagerSupervisorPos());
        }
        if (bo.getProduct() != null) {
            boDTO.setProduct(ProductConversionUtil.convertDatabaseObjectToDTO(bo.getProduct()));
        }
        CommitteeMaterial committeeMaterial = bo.getCommitteeMaterial();
        if (committeeMaterial != null) {
            TBOCommiteeMaterials committeeMaterials = CommitteeMaterialConversionUtil.convertDatabaseObjectToDTO(committeeMaterial);
            JAXBElement<TBOCommiteeMaterials> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "committeeMaterials"), TBOCommiteeMaterials.class, committeeMaterials
            );
            boDTO.setCommiteeMaterials(jaxbElement);
        }
        if (bo.getProfitabilityCalculation() != null) {
            boDTO.setProfitabilityCalculationBlock(ProfitabilityCalculationConversionUtil.convertDatabaseObjectToDTO(bo.getProfitabilityCalculation()));
        }
        if (bo.getTerm() != null) {
            boDTO.setTerms(TermConversionUtil.convertDatabaseObjectToDTO(bo.getTerm()));
        }
        setCommon(bo, boDTO);
        setBusinessGoals(bo, boDTO);
        setWorks(bo, boDTO);
        setRelevance(bo, boDTO);
        setMarketAnalysis(bo, boDTO);
        setOnDevelopments(bo, boDTO);
        return boDTO;
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
        setOnDevelopments(boDTO, bo);
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

    public static void setCommon(BusinessOffer bo, TBusinessOffer boDTO) {
        TBOCommon commonDTO = new TBOCommon();
        Long id = bo.getId();
        commonDTO.setBoID(String.valueOf(id));
        if (bo.getName() != null) {
            commonDTO.setBoName(bo.getName());
        }
        String status = bo.getStatus();
        if (status != null) {
            commonDTO.setBoStatus(status);
        }
        boDTO.setCommon(commonDTO);
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
        List<RelevanceRisk> relevanceRisks = bo.getRelevanceRisks();
        if (relevanceRisks != null) {
            List<TBIImplementationRisk> implementationRisksDTO = relevanceRisks.stream()
                    .map(RelevanceRiskConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIImplementationRisksRec implementationRiskRec = new TBIImplementationRisksRec();
            implementationRiskRec.getImplementationRisk().addAll(implementationRisksDTO);
            boDTO.setRelevance(implementationRiskRec);
        }
    }

    private static void setMarketAnalysis(BusinessOffer bo, TBusinessOffer boDTO) {
        List<MarketAnalysis> marketAnalyses = bo.getMarketAnalysises();
        if (marketAnalyses != null) {
            List<TBOMarketAnalisys> marketAnalysesDTO = marketAnalyses.stream()
                    .map(MarketAnalysisConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBOMarketAnalisysRec marketAnalisysRec = new TBOMarketAnalisysRec();
            marketAnalisysRec.getRecords().addAll(marketAnalysesDTO);
            boDTO.setMarketAnalisysBlock(marketAnalisysRec);
        }
    }

    private static void setBusinessGoals(BusinessOffer bo, TBusinessOffer boDTO) {
        List<BOBusinessGoal> businessGoals = bo.getBusinessGoals();
        List<TBIBusinessGoals> businessGoalsDTO = businessGoals.stream()
                .map(BusinessGoalConversionUtil::convertDatabaseObjectToDTO)
                .collect(Collectors.toList());
        TBIBusinessGoalsRec businessGoalsRec = new TBIBusinessGoalsRec();
        businessGoalsRec.getBusinessGoals().addAll(businessGoalsDTO);
        boDTO.setBusinessGoalsBlock(businessGoalsRec);
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
            if (committeeMaterialDTO != null) {
                CommitteeMaterial committeeMaterial = CommitteeMaterialConversionUtil.convertDTOToDatabaseObject(committeeMaterialDTO);
                committeeMaterial.setBusinessOffer(bo);
                bo.setCommitteeMaterial(committeeMaterial);
            }
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

    private static void setOnDevelopments(TBusinessOffer boDTO, BusinessOffer bo) {
        List<DevelopmentBusinessOffer> onDevelopments = new ArrayList<>();
        addOnApproves(boDTO, bo, onDevelopments);
        addOnConfirms(boDTO, bo, onDevelopments);
        addOnCuratorConfirms(boDTO, bo, onDevelopments);
        addOnProductTeamConfirms(boDTO, bo, onDevelopments);
        addOnOpinions(boDTO, bo, onDevelopments);
        List<DevelopmentBusinessOffer> existingOnDevelopments = bo.getOnDevelopments();
        existingOnDevelopments.clear();
        existingOnDevelopments.addAll(onDevelopments);
    }

    private static void addOnApproves(
            TBusinessOffer boDTO,
            BusinessOffer bo,
            List<DevelopmentBusinessOffer> onDevelopments
    ) {
        TBIOnDevelopmentRec onApprove = boDTO.getOnApprove();
        if (onApprove != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onApprove.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(APPROVE_PHASE);
                    DevelopmentBusinessOffer onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessOffer(bo);
                    onDevelopments.add(onDevelopment);
                }
            }
        }
    }

    private static void addOnProductTeamConfirms(
            TBusinessOffer boDTO,
            BusinessOffer bo,
            List<DevelopmentBusinessOffer> onDevelopments
    ) {
        TBIOnDevelopmentRec onProductTeamConfirm = boDTO.getOnConfirmProductTeam();
        if (onProductTeamConfirm != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onProductTeamConfirm.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(CONFIRM_PRODUCT_TEAM_PHASE);
                    DevelopmentBusinessOffer onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessOffer(bo);
                    onDevelopments.add(onDevelopment);
                }
            }
        }
    }

    private static void addOnOpinions(
            TBusinessOffer boDTO,
            BusinessOffer bo,
            List<DevelopmentBusinessOffer> onDevelopments
    ) {
        TBIOnDevelopmentRec onOpinion = boDTO.getOnOpinion();
        if (onOpinion != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onOpinion.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(OPINION_PHASE);
                    DevelopmentBusinessOffer onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessOffer(bo);
                    onDevelopments.add(onDevelopment);
                }
            }
        }
    }

    private static void addOnConfirms(
            TBusinessOffer boDTO,
            BusinessOffer bo,
            List<DevelopmentBusinessOffer> onDevelopments) {
        TBIOnDevelopmentRec onConfirm = boDTO.getOnConfirm();
        if (onConfirm != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onConfirm.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(CONFIRM_PHASE);
                    DevelopmentBusinessOffer onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessOffer(bo);
                    onDevelopments.add(onDevelopment);
                }
            }
        }
    }

    private static void addOnCuratorConfirms(
            TBusinessOffer boDTO,
            BusinessOffer bo,
            List<DevelopmentBusinessOffer> onDevelopments) {
        TBIOnDevelopmentRec onConfirmCurator = boDTO.getOnConfirmCurator();
        if (onConfirmCurator != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onConfirmCurator.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(CONFIRM_CURATOR_PHASE);
                    DevelopmentBusinessOffer onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessOffer(bo);
                    onDevelopments.add(onDevelopment);
                }
            }
        }
    }

    private static DevelopmentBusinessOffer getOnDevelopment(TBIOnDevelopment onDevelopmentDTO) {
        return DevelopmentBusinessOfferConversionUtil.convertDTOToDatabaseObject(onDevelopmentDTO);
    }

    private static void setOnDevelopments(BusinessOffer bo, TBusinessOffer boDTO) {
        if (bo.getOnDevelopments() != null) {
            List<DevelopmentBusinessOffer> onDevelopments = bo.getOnDevelopments();
            List<TBIOnDevelopment> onDevelopmentsDTO = onDevelopments.stream()
                    .map(DevelopmentBusinessOfferConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());

            TBIOnDevelopmentRec onApproveRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> approves = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), APPROVE_PHASE))
                    .collect(Collectors.toList());
            if (!approves.isEmpty()) {
                onApproveRec.getRecord().addAll(approves);
            }

            TBIOnDevelopmentRec onConfirmRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> confirms = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), CONFIRM_PHASE))
                    .collect(Collectors.toList());
            if (!confirms.isEmpty()) {
                onConfirmRec.getRecord().addAll(confirms);
            }

            TBIOnDevelopmentRec onConfirmCuratorRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> confirmsCurator = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), CONFIRM_CURATOR_PHASE))
                    .collect(Collectors.toList());
            if (!confirmsCurator.isEmpty()) {
                onConfirmCuratorRec.getRecord().addAll(confirmsCurator);
            }

            TBIOnDevelopmentRec onConfirmProductTeamRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> confirmsProductTeam = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), CONFIRM_PRODUCT_TEAM_PHASE))
                    .collect(Collectors.toList());
            if (!confirmsProductTeam.isEmpty()) {
                onConfirmProductTeamRec.getRecord().addAll(confirmsProductTeam);
            }

            TBIOnDevelopmentRec onOpinionRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> opinions = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), OPINION_PHASE))
                    .collect(Collectors.toList());
            if (!opinions.isEmpty()) {
                onOpinionRec.getRecord().addAll(opinions);
            }
            boDTO.setOnApprove(onApproveRec);
            boDTO.setOnConfirm(onConfirmRec);
            boDTO.setOnConfirmCurator(onConfirmCuratorRec);
            boDTO.setOnConfirmProductTeam(onConfirmProductTeamRec);
            boDTO.setOnOpinion(onOpinionRec);
        }
    }

}
