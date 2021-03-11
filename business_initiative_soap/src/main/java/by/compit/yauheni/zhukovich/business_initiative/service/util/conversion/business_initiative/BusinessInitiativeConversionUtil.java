package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBIBusinessDirection;
import org.example.TBIBusinessDirectionRec;
import org.example.TBIBusinessGoals;
import org.example.TBIBusinessGoalsRec;
import org.example.TBICommonBlock;
import org.example.TBIImplementationRisk;
import org.example.TBIImplementationRisksRec;
import org.example.TBIInfoSystemInfluence;
import org.example.TBIInfoSystemInfluencesRec;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.example.TBIPlanGraphic;
import org.example.TBIProductTeam;
import org.example.TBIProductTeamsRec;
import org.example.TBIProjectedExpenses;
import org.example.TBIProjectedExpensesRec;
import org.example.TBISalesChannels;
import org.example.TBISalesChannelsRec;
import org.example.TBusinessInitiative;
import org.example.TBusinessInitiativePart1;
import org.example.TBusinessInitiativePart2;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BIBusinessGoal;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BIProductTeam;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessDirection;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.DevelopmentBusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.ImplementationRisk;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.InfoSystemInfluence;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.PlanGraphic;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.ProjectedExpenses;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.SalesChannel;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.APPROVE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_CURATOR_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.FAMILIARIZE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class BusinessInitiativeConversionUtil {

    public static BusinessInitiative convertDTOToDatabaseObject(TBusinessInitiative biDTO) {
        BusinessInitiative bi = new BusinessInitiative();
        setDatabaseObjectByDTO(biDTO, bi);
        return bi;
    }

    public static TBusinessInitiative convertDatabaseObjectToDTO(BusinessInitiative bi) {
        TBusinessInitiative biDTO = new TBusinessInitiative();
        setBiPart1(bi, biDTO);
        setBiPart2(bi, biDTO);
        setOnDevelopments(bi, biDTO);
        return biDTO;
    }

    public static void setDatabaseObjectByDTO(TBusinessInitiative biDTO, BusinessInitiative bi) {
        setSimpleFields(biDTO, bi);
        setCommonBlock(biDTO, bi);
        setBusinessGoals(biDTO, bi);
        setBusinessDirections(biDTO, bi);
        setSalesChannels(biDTO, bi);
        setInfoSystemInfluences(biDTO, bi);
        setImplementationRisks(biDTO, bi);
        setProjectedExpenses(biDTO, bi);
        setProductTeams(biDTO, bi);
        setPlanGraphic(biDTO, bi);
        setOnDevelopments(biDTO, bi);
    }

    private static void setBiPart2(BusinessInitiative bi, TBusinessInitiative biDTO) {
        TBusinessInitiativePart2 biPart2DTO = new TBusinessInitiativePart2();
        if (bi.getMarketAnalysis() != null) {
            biPart2DTO.setMarketAnalisys(bi.getMarketAnalysis());
        }
        if (bi.getMarketAnalysisFile() != null) {
            biPart2DTO.setMarketAnalisysFile(bi.getMarketAnalysisFile());
        }
        if (bi.getBusinessAppImplDate() != null) {
            biPart2DTO.setBusinessAppImplDate(convertLocalDateToCalendar(bi.getBusinessAppImplDate()));
        }
        if (bi.getPlanGraphicDate() != null) {
            biPart2DTO.setPlanGraphicDate(convertLocalDateToCalendar(bi.getPlanGraphicDate()));
        }
        setPlanGraphic(bi, biPart2DTO);
        setImplementationRisks(bi, biPart2DTO);
        setInfoSystemInfluences(bi, biPart2DTO);
        setProductTeams(bi, biPart2DTO);
        setProjectedExpenses(bi, biPart2DTO);
        biDTO.setBiPart2(biPart2DTO);
    }

    private static void setBiPart1(BusinessInitiative bi, TBusinessInitiative biDTO) {
        TBusinessInitiativePart1 biPart1DTO = new TBusinessInitiativePart1();
        if (bi.getName() != null) {
            biPart1DTO.setBiName(bi.getName());
        }
        if (bi.getAddInfo() != null) {
            biPart1DTO.setAddInfo(bi.getAddInfo());
        }
        if (bi.getNonRealizeEffects() != null) {
            biPart1DTO.setNonrealizeEffects(bi.getNonRealizeEffects());
        }
        if (bi.getPoint() != null) {
            biPart1DTO.setBiPoint(bi.getPoint());
        }
        if (bi.getProduct() != null) {
            biPart1DTO.setProduct(bi.getProduct());
        }
        if (bi.getRealizeProspective() != null) {
            biPart1DTO.setRealizeProspective(bi.getRealizeProspective());
        }
        if (bi.getImplPlanningDate() != null) {
            biPart1DTO.setImplPlanningDate(convertLocalDateToCalendar(bi.getImplPlanningDate()));
        }
        if (bi.getJobType() != null) {
            biPart1DTO.setJobTypes(bi.getJobType());
        }
        setCommonBlock(bi, biPart1DTO);
        setBusinessGoals(bi, biPart1DTO);
        setBusinessDirections(bi, biPart1DTO);
        setSalesChannels(bi, biPart1DTO);
        biDTO.setBiPart1(biPart1DTO);
    }

    public static void setSimpleFields(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart1 biPart1DTO = biDTO.getBiPart1();
        if (biPart1DTO != null) {
            String addInfo = biPart1DTO.getAddInfo();
            if (addInfo != null) {
                bi.setAddInfo(addInfo);
            }
            String biName = biPart1DTO.getBiName();
            if (biName != null) {
                bi.setName(biName);
            }
            String nonrealizeEffects = biPart1DTO.getNonrealizeEffects();
            if (nonrealizeEffects != null) {
                bi.setNonRealizeEffects(nonrealizeEffects);
            }
            String biPoint = biPart1DTO.getBiPoint();
            if (biPoint != null) {
                bi.setPoint(biPoint);
            }
            String realizeProspective = biPart1DTO.getRealizeProspective();
            if (realizeProspective != null) {
                bi.setRealizeProspective(realizeProspective);
            }
            String product = biPart1DTO.getProduct();
            if (product != null) {
                bi.setProduct(product);
            }
            XMLGregorianCalendar implPlanningDate = biPart1DTO.getImplPlanningDate();
            if (implPlanningDate != null) {
                bi.setImplPlanningDate(convertCalendarToLocalDate(implPlanningDate));
            }
            String jobTypes = biPart1DTO.getJobTypes();
            if (jobTypes != null) {
                bi.setJobType(jobTypes);
            }
        }
        TBusinessInitiativePart2 biPart2DTO = biDTO.getBiPart2();
        if (biDTO.getBiPart2() != null) {
            String marketAnalisys = biPart2DTO.getMarketAnalisys();
            if (marketAnalisys != null) {
                bi.setMarketAnalysis(marketAnalisys);
            }
            String marketAnalisysFile = biPart2DTO.getMarketAnalisysFile();
            if (marketAnalisysFile != null) {
                bi.setMarketAnalysisFile(marketAnalisysFile);
            }
            XMLGregorianCalendar businessAppImplDate = biPart2DTO.getBusinessAppImplDate();
            if (businessAppImplDate != null) {
                bi.setBusinessAppImplDate(convertCalendarToLocalDate(businessAppImplDate));
            }
            XMLGregorianCalendar planGraphicDate = biPart2DTO.getPlanGraphicDate();
            if (planGraphicDate != null) {
                bi.setPlanGraphicDate(convertCalendarToLocalDate(planGraphicDate));
            }
        }
    }

    public static void setCommonBlock(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart1 biPart1 = biDTO.getBiPart1();
        if (biPart1 != null) {
            TBICommonBlock commonBlockDTO = biPart1.getCommonBlock();
            if (commonBlockDTO != null) {
                CommonBlockConversionUtil.setDatabaseObjectByDTO(commonBlockDTO, bi);
            }
        }
    }

    public static void setBusinessGoals(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart1 biPart1 = biDTO.getBiPart1();
        if (biPart1 != null) {
            TBIBusinessGoalsRec businessGoalsRec = biPart1.getBusinessGoalsBlock();
            if (businessGoalsRec != null) {
                List<TBIBusinessGoals> businessGoalsDTO = businessGoalsRec.getBusinessGoals();
                if (!businessGoalsDTO.isEmpty()) {
                    List<BIBusinessGoal> businessGoals = businessGoalsDTO.stream()
                            .map(BusinessGoalConversionUtil::convertDTOToDatabaseObject)
                            .peek(businessGoal -> businessGoal.setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<BIBusinessGoal> existingBusinessGoals = bi.getBusinessGoals();
                    existingBusinessGoals.clear();
                    existingBusinessGoals.addAll(businessGoals);
                }
            }
        }
    }

    public static void setBusinessDirections(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart1 biPart1 = biDTO.getBiPart1();
        if (biPart1 != null) {
            TBIBusinessDirectionRec businessDirectionRec = biPart1.getBusinessDirectionBlock();
            if (businessDirectionRec != null) {
                List<TBIBusinessDirection> businessDirectionsDTO = businessDirectionRec.getBusinessDirection();
                if (!businessDirectionsDTO.isEmpty()) {
                    List<BusinessDirection> businessDirections = businessDirectionsDTO.stream()
                            .map(BusinessDirectionConversionUtil::convertDTOToDatabaseObject)
                            .peek(businessDirection -> businessDirection.setBusinessInitiative(bi))
                            .peek(businessDirection -> businessDirection.getTargetAudience().setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<BusinessDirection> existingBusinessDirections = bi.getBusinessDirections();
                    existingBusinessDirections.clear();
                    existingBusinessDirections.addAll(businessDirections);
                }
            }
        }
    }

    public static void setSalesChannels(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart1 biPart1 = biDTO.getBiPart1();
        if (biPart1 != null) {
            TBISalesChannelsRec salesChannelsRec = biPart1.getSalesChannelsBlock();
            if (salesChannelsRec != null) {
                List<TBISalesChannels> salesChannelsDTO = salesChannelsRec.getSalesChannelsRecs();
                if (!salesChannelsDTO.isEmpty()) {
                    List<SalesChannel> salesChannels = salesChannelsDTO.stream()
                            .map(SalesChannelConversionUtil::convertDTOToDatabaseObject)
                            .peek(salesChannel -> salesChannel.setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<SalesChannel> existingSalesChannels = bi.getSalesChannels();
                    existingSalesChannels.clear();
                    existingSalesChannels.addAll(salesChannels);
                }
            }
        }
    }

    public static void setInfoSystemInfluences(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart2 biPart2 = biDTO.getBiPart2();
        if (biPart2 != null) {
            TBIInfoSystemInfluencesRec infoSystemInfluencesRec = biPart2.getInfoSystemInfluenceBlock();
            if (infoSystemInfluencesRec != null) {
                List<TBIInfoSystemInfluence> infoSystemInfluencesDTO = infoSystemInfluencesRec.getInfoSystemInfluence();
                if (infoSystemInfluencesDTO != null) {
                    List<InfoSystemInfluence> infoSystemInfluences = infoSystemInfluencesDTO.stream()
                            .map(InfoSystemInfluenceConversionUtil::convertDTOToDatabaseObject)
                            .peek(infoSystemInfluence -> infoSystemInfluence.setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<InfoSystemInfluence> existingInfoSystemInfluences = bi.getInfoSystemInfluences();
                    existingInfoSystemInfluences.clear();
                    existingInfoSystemInfluences.addAll(infoSystemInfluences);
                }
            }
        }
    }

    public static void setImplementationRisks(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart2 biPart2 = biDTO.getBiPart2();
        if (biPart2 != null) {
            TBIImplementationRisksRec implementationRisksRec = biPart2.getImplementationRisksBlock();
            if (implementationRisksRec != null) {
                List<TBIImplementationRisk> implementationRisksDTO = implementationRisksRec.getImplementationRisk();
                if (implementationRisksDTO != null) {
                    List<ImplementationRisk> implementationRisks = implementationRisksDTO.stream()
                            .map(ImplementationRiskConversionUtil::convertDTOToDatabaseObject)
                            .peek(implementationRisk -> implementationRisk.setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<ImplementationRisk> existingImplementationRisks = bi.getImplementationRisks();
                    existingImplementationRisks.clear();
                    existingImplementationRisks.addAll(implementationRisks);
                }
            }
        }
    }

    public static void setProjectedExpenses(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart2 biPart2 = biDTO.getBiPart2();
        if (biPart2 != null) {
            TBIProjectedExpensesRec projectedExpensesRec = biPart2.getProjectedExpencesBlock();
            if (projectedExpensesRec != null) {
                List<TBIProjectedExpenses> projectedExpensessDTO = projectedExpensesRec.getProjectedExpenses();
                if (projectedExpensessDTO != null) {
                    List<ProjectedExpenses> projectedExpensess = projectedExpensessDTO.stream()
                            .map(ProjectedExpensesConversionUtil::convertDTOToDatabaseObject)
                            .peek(projectedExpenses -> projectedExpenses.setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<ProjectedExpenses> existingProjectedExpensess = bi.getProjectedExpensess();
                    existingProjectedExpensess.clear();
                    existingProjectedExpensess.addAll(projectedExpensess);
                }
            }
        }
    }

    public static void setProductTeams(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart2 biPart2 = biDTO.getBiPart2();
        if (biPart2 != null) {
            TBIProductTeamsRec productTeamsRec = biPart2.getProductTeamBlock();
            if (productTeamsRec != null) {
                List<TBIProductTeam> productTeamsDTO = productTeamsRec.getProductTeams();
                if (productTeamsDTO != null) {
                    List<BIProductTeam> productTeams = productTeamsDTO.stream()
                            .map(ProductTeamConversionUtil::convertDTOToDatabaseObject)
                            .peek(productTeam -> productTeam.setBusinessInitiative(bi))
                            .collect(Collectors.toList());
                    List<BIProductTeam> existingProductTeams = bi.getProductTeams();
                    existingProductTeams.clear();
                    existingProductTeams.addAll(productTeams);
                }
            }
        }
    }

    public static void setPlanGraphic(TBusinessInitiative biDTO, BusinessInitiative bi) {
        TBusinessInitiativePart2 biPart2 = biDTO.getBiPart2();
        if (biPart2 != null) {
            TBIPlanGraphic planGraphicDTO = biPart2.getPlanGraphic();
            if (planGraphicDTO != null) {
                PlanGraphic planGraphic = PlanGraphicConversionUtil.convertDTOToDatabaseObject(planGraphicDTO, bi);
                planGraphic.setBusinessInitiative(bi);
                bi.setPlanGraphic(planGraphic);
            }
        }
    }

    public static void setOnDevelopments(TBusinessInitiative biDTO, BusinessInitiative bi) {
        List<DevelopmentBusinessInitiative> onDevelopments = new ArrayList<>();
        addOnApproves(biDTO, bi, onDevelopments);
        addOnConfirms(biDTO, bi, onDevelopments);
        addOnCuratorConfirms(biDTO, bi, onDevelopments);
        addOnFamiliarizes(biDTO, bi, onDevelopments);
        List<DevelopmentBusinessInitiative> existingOnDevelopments = bi.getOnDevelopments();
        existingOnDevelopments.clear();
        existingOnDevelopments.addAll(onDevelopments);
    }

    private static void addOnApproves(TBusinessInitiative biDTO, BusinessInitiative bi, List<DevelopmentBusinessInitiative> onDevelopments) {
        TBIOnDevelopmentRec onApprove = biDTO.getOnApprove();
        if (onApprove != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onApprove.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(APPROVE_PHASE);
                    DevelopmentBusinessInitiative onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessInitiative(bi);
                    if (onDevelopment.getDlgEmpName() != null || onDevelopment.getEmpName() != null) {
                        onDevelopments.add(onDevelopment);
                    }
                }
            }
        }
    }

    private static void addOnConfirms(TBusinessInitiative biDTO, BusinessInitiative bi, List<DevelopmentBusinessInitiative> onDevelopments) {
        TBIOnDevelopmentRec onConfirm = biDTO.getOnConfirm();
        if (onConfirm != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onConfirm.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(CONFIRM_PHASE);
                    DevelopmentBusinessInitiative onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessInitiative(bi);
                    if (onDevelopment.getDlgEmpName() != null || onDevelopment.getEmpName() != null) {
                        onDevelopments.add(onDevelopment);
                    }
                }
            }
        }
    }

    private static void addOnCuratorConfirms(TBusinessInitiative biDTO, BusinessInitiative bi, List<DevelopmentBusinessInitiative> onDevelopments) {
        TBIOnDevelopmentRec onConfirmCurator = biDTO.getOnConfirmCurator();
        if (onConfirmCurator != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onConfirmCurator.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(CONFIRM_CURATOR_PHASE);
                    DevelopmentBusinessInitiative onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessInitiative(bi);
                    if (onDevelopment.getDlgEmpName() != null || onDevelopment.getEmpName() != null) {
                        onDevelopments.add(onDevelopment);
                    }
                }
            }
        }
    }

    private static void addOnFamiliarizes(TBusinessInitiative biDTO, BusinessInitiative bi, List<DevelopmentBusinessInitiative> onDevelopments) {
        TBIOnDevelopmentRec onFamiliarize = biDTO.getOnFamiliarize();
        if (onFamiliarize != null) {
            List<TBIOnDevelopment> onDevelopmentsDTO = onFamiliarize.getRecord();
            if (!onDevelopmentsDTO.isEmpty()) {
                for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
                    onDevelopmentDTO.setDevPhase(FAMILIARIZE_PHASE);
                    DevelopmentBusinessInitiative onDevelopment = getOnDevelopment(onDevelopmentDTO);
                    onDevelopment.setBusinessInitiative(bi);
                    if (onDevelopment.getDlgEmpName() != null || onDevelopment.getEmpName() != null) {
                        onDevelopments.add(onDevelopment);
                    }
                }
            }
        }
    }

    private static DevelopmentBusinessInitiative getOnDevelopment(TBIOnDevelopment onDevelopmentDTO) {
        return DevelopmentBusinessInitiativeConversionUtil.convertDTOToDatabaseObject(onDevelopmentDTO);
    }

    private static void setCommonBlock(BusinessInitiative bi, TBusinessInitiativePart1 biPart1DTO) {
        TBICommonBlock commonBlockDTO = CommonBlockConversionUtil.convertDatabaseObjectToDTO(bi);
        biPart1DTO.setCommonBlock(commonBlockDTO);
    }

    private static void setPlanGraphic(BusinessInitiative bi, TBusinessInitiativePart2 biPart2DTO) {
        PlanGraphic planGraphic = bi.getPlanGraphic();
        if (planGraphic != null) {
            TBIPlanGraphic planGraphicDTO = PlanGraphicConversionUtil.convertDatabaseObjectToDTO(planGraphic);
            biPart2DTO.setPlanGraphic(planGraphicDTO);
        }
    }

    private static void setBusinessGoals(BusinessInitiative bi, TBusinessInitiativePart1 biPart2DTO) {
        List<BIBusinessGoal> businessGoals = bi.getBusinessGoals();
        if (businessGoals != null) {
            List<TBIBusinessGoals> businessGoalsDTO = businessGoals.stream()
                    .map(BusinessGoalConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIBusinessGoalsRec businessGoalsRec = new TBIBusinessGoalsRec();
            businessGoalsRec.getBusinessGoals().addAll(businessGoalsDTO);
            biPart2DTO.setBusinessGoalsBlock(businessGoalsRec);
        }
    }

    private static void setImplementationRisks(BusinessInitiative bi, TBusinessInitiativePart2 biPart2DTO) {
        List<ImplementationRisk> implementationRisks = bi.getImplementationRisks();
        if (implementationRisks != null) {
            List<TBIImplementationRisk> implementationRisksDTO = implementationRisks.stream()
                    .map(ImplementationRiskConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIImplementationRisksRec implementationRiskRec = new TBIImplementationRisksRec();
            implementationRiskRec.getImplementationRisk().addAll(implementationRisksDTO);
            biPart2DTO.setImplementationRisksBlock(implementationRiskRec);
        }
    }

    private static void setInfoSystemInfluences(BusinessInitiative bi, TBusinessInitiativePart2 biPart2DTO) {
        List<InfoSystemInfluence> infoSystemInfluences = bi.getInfoSystemInfluences();
        if (infoSystemInfluences != null) {
            List<TBIInfoSystemInfluence> infoSystemInfluencesDTO = infoSystemInfluences.stream()
                    .map(InfoSystemInfluenceConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIInfoSystemInfluencesRec infoSystemInfluencesRec = new TBIInfoSystemInfluencesRec();
            infoSystemInfluencesRec.getInfoSystemInfluence().addAll(infoSystemInfluencesDTO);
            biPart2DTO.setInfoSystemInfluenceBlock(infoSystemInfluencesRec);
        }
    }

    private static void setSalesChannels(BusinessInitiative bi, TBusinessInitiativePart1 biPart1DTO) {
        List<SalesChannel> salesChannels = bi.getSalesChannels();
        if (salesChannels != null) {
            List<TBISalesChannels> salesChannelsDTO = salesChannels.stream()
                    .map(SalesChannelConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBISalesChannelsRec salesChannelsRec = new TBISalesChannelsRec();
            salesChannelsRec.getSalesChannelsRecs().addAll(salesChannelsDTO);
            biPart1DTO.setSalesChannelsBlock(salesChannelsRec);
        }
    }

    private static void setProductTeams(BusinessInitiative bi, TBusinessInitiativePart2 biPart2DTO) {
        List<BIProductTeam> productTeams = bi.getProductTeams();
        if (productTeams != null) {
            List<TBIProductTeam> productTeamsDTO = productTeams.stream()
                    .map(ProductTeamConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIProductTeamsRec productTeamsRec = new TBIProductTeamsRec();
            productTeamsRec.getProductTeams().addAll(productTeamsDTO);
            biPart2DTO.setProductTeamBlock(productTeamsRec);
        }
    }

    private static void setProjectedExpenses(BusinessInitiative bi, TBusinessInitiativePart2 biPart2DTO) {
        List<ProjectedExpenses> projectedExpensess = bi.getProjectedExpensess();
        if (projectedExpensess != null) {
            List<TBIProjectedExpenses> projectedExpensessDTO = projectedExpensess.stream()
                    .map(ProjectedExpensesConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIProjectedExpensesRec projectedExpensesRec = new TBIProjectedExpensesRec();
            projectedExpensesRec.getProjectedExpenses().addAll(projectedExpensessDTO);
            biPart2DTO.setProjectedExpencesBlock(projectedExpensesRec);
        }
    }

    private static void setBusinessDirections(BusinessInitiative bi, TBusinessInitiativePart1 biPart1DTO) {
        List<BusinessDirection> businessDirections = bi.getBusinessDirections();
        if (businessDirections != null) {
            List<TBIBusinessDirection> businessDirectionsDTO = businessDirections.stream()
                    .map(BusinessDirectionConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIBusinessDirectionRec businessDirectionRec = new TBIBusinessDirectionRec();
            businessDirectionRec.getBusinessDirection().addAll(businessDirectionsDTO);
            biPart1DTO.setBusinessDirectionBlock(businessDirectionRec);
        }
    }

    private static void setOnDevelopments(BusinessInitiative bi, TBusinessInitiative biDTO) {
        if (bi.getOnDevelopments() != null) {
            List<DevelopmentBusinessInitiative> onDevelopments = bi.getOnDevelopments();
            List<TBIOnDevelopment> onDevelopmentsDTO = onDevelopments.stream()
                    .map(DevelopmentBusinessInitiativeConversionUtil::convertDatabaseObjectToDTO)
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

            TBIOnDevelopmentRec onFamiliarizeRec = new TBIOnDevelopmentRec();
            List<TBIOnDevelopment> familiarizes = onDevelopmentsDTO.stream()
                    .filter(onDevelopment -> Objects.equals(onDevelopment.getDevPhase(), FAMILIARIZE_PHASE))
                    .collect(Collectors.toList());
            if (!familiarizes.isEmpty()) {
                onFamiliarizeRec.getRecord().addAll(familiarizes);
            }
            biDTO.setOnApprove(onApproveRec);
            biDTO.setOnConfirm(onConfirmRec);
            biDTO.setOnConfirmCurator(onConfirmCuratorRec);
            biDTO.setOnFamiliarize(onFamiliarizeRec);
        }
    }

}
