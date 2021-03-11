package by.belinvest.panel.admin.catalog.service;

import by.belinvest.panel.admin.catalog.db.CatalogRepository;
import by.belinvest.panel.admin.entity.catalog.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Element;
import ws1.*;
import ws2.CTLGBPSUPPNModificatePortType;
import ws2.CTLGBPSUPPNModificateService;
import ws3.CTLGBPSUPPNUpgradePortType;
import ws3.CTLGBPSUPPNUpgradeService;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.BindingProvider;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CatalogService {

    private final static QName _TBPCommonLpaBanks_QNAME = new QName("http://www.example.org", "lpaBanks");
    private final static QName _TBPCommonDocsForms_QNAME = new QName("http://www.example.org", "docsForms");
    private final static QName _TBPCommonCommonProductChars_QNAME = new QName("http://www.example.org", "commonProductChars");
    private final static QName _TBPCommonProductAdvantages_QNAME = new QName("http://www.example.org", "productAdvantages");
    private final static QName _TBPCommonAddMaterials_QNAME = new QName("http://www.example.org", "addMaterials");

    private static String CLIENT_CONFIG = "wf_client_config.xml";

    @Autowired
    private CatalogRepository catalogRepository;

    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public ReestrDirectory get() {
        return catalogRepository.get();
    }

    public BusinessInitiativeDirectory getBusinessInitiativeById(int id) {
        return catalogRepository.getBusinessInitiativeById(id);
    }

    public BusinessOfferDirectory getBusinessOfferById(int id) {
        return catalogRepository.getBusinessOfferById(id);
    }

    @Transactional(readOnly = true,isolation = Isolation.SERIALIZABLE)
    public BPCardDirectory getBPCardById(int id) {
        return catalogRepository.getBPCardById(id);
    }

    public String getProductByBpcard(int id) {
        return catalogRepository.getProductByBpcard(id);
    }

    public void moderProduct(Integer bPCId,Integer boId){
        if (bPCId!=null&&boId!=null) {
            BPCard bpCard = getBPCardById(bPCId).getBpCards().get(0);

            CTLGBPSUPPNUpgradeService ctlgbpsuppnUpgradeService = new CTLGBPSUPPNUpgradeService();
            CTLGBPSUPPNUpgradePortType service = ctlgbpsuppnUpgradeService.getCTLGBPSUPPNUpgradePort();

            ws3.TBankingProductCard tBankingProductCard = new ws3.TBankingProductCard();
            tBankingProductCard.setBusinessOfferId(String.valueOf(boId));

            ws3.TUserInfo tUserInfo = new ws3.TUserInfo();
            tUserInfo.setUsername("testuser5");
            tUserInfo.setComment("ddd");
            tBankingProductCard.setUserInfo(tUserInfo);

            ws3.TBEmployeeType employeeType = new ws3.TBEmployeeType();
            employeeType.setEmployeeName("testuser5");
            employeeType.setDeptName("Unit4Employee");
            employeeType.setEmployeePosition("Employee");
            tBankingProductCard.getProductCardDistribution().addAll(Collections.singletonList(employeeType));

            try {

                ws3.TBPCommon tbpCommon = new ws3.TBPCommon();
                tbpCommon.setBpID(bpCard.getbPId());
                tbpCommon.setProductName(bpCard.getProductName());
                JAXBElement<String> commonProductChars = new JAXBElement<>(_TBPCommonCommonProductChars_QNAME,String.class,bpCard.getCommonProductChars());
                tbpCommon.setCommonProductChars(commonProductChars);
                tbpCommon.setProductStatus(bpCard.getProductStatus());

                if (!bpCard.getChangeStatusDate().isEmpty()) {
                    Date date = format.parse(bpCard.getChangeStatusDate());
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(date);
                    tbpCommon.setChangeStatusDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
                }

                JAXBElement<String> prodAdvantages = new JAXBElement<>(_TBPCommonProductAdvantages_QNAME,String.class,bpCard.getCommonProductChars());
                tbpCommon.setProductAdvantages(prodAdvantages);

                tbpCommon.setMainProductParams(bpCard.getMainProductParams());

                JAXBElement<String> docsForms = new JAXBElement<>(_TBPCommonDocsForms_QNAME,String.class,bpCard.getDocsForms());
                tbpCommon.setDocsForms(docsForms);

                JAXBElement<String> lpabanks = new JAXBElement<>(_TBPCommonLpaBanks_QNAME,String.class,bpCard.getLbaBanks());
                tbpCommon.setLpaBanks(lpabanks);

                JAXBElement<String> addmaterials = new JAXBElement<>(_TBPCommonAddMaterials_QNAME,String.class,bpCard.getLbaBanks());
                tbpCommon.setAddMaterials(addmaterials);



                tBankingProductCard.setCommon(tbpCommon);

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }

            BindingProvider prov = (BindingProvider)service;

            prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "testuser1");
            prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "12345678");


            service.upgrade(tBankingProductCard);
            System.out.println("modern product");
        }

    }

    public void modifyProduct(Integer bPCId,Integer boId){
        if (bPCId!=null) {

            BPCard bpCard = getBPCardById(bPCId).getBpCards().get(0);

            CTLGBPSUPPNModificateService ctlgbpsuppnModificateService = new CTLGBPSUPPNModificateService();
            CTLGBPSUPPNModificatePortType service = ctlgbpsuppnModificateService.getCTLGBPSUPPNModificatePort();

            ws2.TBankingProductCard tBankingProductCard = new ws2.TBankingProductCard();
            tBankingProductCard.setBusinessOfferId(String.valueOf(boId));

            ws2.TUserInfo tUserInfo = new ws2.TUserInfo();
            tUserInfo.setUsername("testuser5");
            tUserInfo.setComment("ddd");
            tBankingProductCard.setUserInfo(tUserInfo);

            ws2.TBEmployeeType employeeType = new ws2.TBEmployeeType();
            employeeType.setEmployeeName("testuser5");
            employeeType.setDeptName("Unit4Employee");
            employeeType.setEmployeePosition("Employee");
            tBankingProductCard.getProductCardDistribution().addAll(Collections.singletonList(employeeType));



            try {

                ws2.TBPCommon tbpCommon = new ws2.TBPCommon();
                tbpCommon.setBpID(bpCard.getbPId());
                tbpCommon.setProductName(bpCard.getProductName());
                JAXBElement<String> commonProductChars = new JAXBElement<>(_TBPCommonCommonProductChars_QNAME,String.class,bpCard.getCommonProductChars());
                tbpCommon.setCommonProductChars(commonProductChars);
                tbpCommon.setProductStatus(bpCard.getProductStatus());

                if (!bpCard.getChangeStatusDate().isEmpty()) {
                    Date date = format.parse(bpCard.getChangeStatusDate());
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(date);
                    tbpCommon.setChangeStatusDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
                }

                JAXBElement<String> prodAdvantages = new JAXBElement<>(_TBPCommonProductAdvantages_QNAME,String.class,bpCard.getCommonProductChars());
                tbpCommon.setProductAdvantages(prodAdvantages);

                tbpCommon.setMainProductParams(bpCard.getMainProductParams());

                JAXBElement<String> docsForms = new JAXBElement<>(_TBPCommonDocsForms_QNAME,String.class,bpCard.getDocsForms());
                tbpCommon.setDocsForms(docsForms);

                JAXBElement<String> lpabanks = new JAXBElement<>(_TBPCommonLpaBanks_QNAME,String.class,bpCard.getLbaBanks());
                tbpCommon.setLpaBanks(lpabanks);

                JAXBElement<String> addmaterials = new JAXBElement<>(_TBPCommonAddMaterials_QNAME,String.class,bpCard.getLbaBanks());
                tbpCommon.setAddMaterials(addmaterials);

                tBankingProductCard.setCommon(tbpCommon);



            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }



            service.modificate(tBankingProductCard);
        }

    }

    public void liquidProduct(Integer bPCId,Integer boId) throws SOAPException {
        BPCard bpCard = null;
        if (bPCId!=null) {

            bpCard = getBPCardById(bPCId).getBpCards().get(0);
            CTLGBPSUPPNLiquidationService ctlgbpsuppnLiquidationService = new CTLGBPSUPPNLiquidationService();
            CTLGBPSUPPNLiquidationPortType service = ctlgbpsuppnLiquidationService.getCTLGBPSUPPNLiquidationPort();

            TBankingProductCard tBankingProductCard = new TBankingProductCard();
            tBankingProductCard.setBusinessOfferId(String.valueOf(boId));

            TUserInfo tUserInfo = new TUserInfo();
            tUserInfo.setUsername("testuser5");
            tUserInfo.setComment("ddd");
            tBankingProductCard.setUserInfo(tUserInfo);

            TBEmployeeType employeeType = new TBEmployeeType();
            employeeType.setEmployeeName("testuser5");
            employeeType.setDeptName("Unit4Employee");
            employeeType.setEmployeePosition("Employee");
            tBankingProductCard.getProductCardDistribution().addAll(Collections.singletonList(employeeType));
            try {
                TBPCommon tbpCommon = new TBPCommon();
                tbpCommon.setBpID(bpCard.getbPId());
                tbpCommon.setProductName(bpCard.getProductName());
                JAXBElement<String> commonProductChars = new JAXBElement<>(_TBPCommonCommonProductChars_QNAME,String.class,bpCard.getCommonProductChars());
                tbpCommon.setCommonProductChars(commonProductChars);
                tbpCommon.setProductStatus(bpCard.getProductStatus());

                if (bpCard.getChangeStatusDate()!=null) {
                    Date date = format.parse(bpCard.getChangeStatusDate());
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(date);
                    tbpCommon.setChangeStatusDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
                }
                JAXBElement<String> prodAdvantages = new JAXBElement<>(_TBPCommonProductAdvantages_QNAME,String.class,bpCard.getCommonProductChars());
                tbpCommon.setProductAdvantages(prodAdvantages);

                tbpCommon.setMainProductParams(bpCard.getMainProductParams());

                JAXBElement<String> docsForms = new JAXBElement<>(_TBPCommonDocsForms_QNAME,String.class,bpCard.getDocsForms());
                tbpCommon.setDocsForms(docsForms);

                JAXBElement<String> lpabanks = new JAXBElement<>(_TBPCommonLpaBanks_QNAME,String.class,bpCard.getLbaBanks());
                tbpCommon.setLpaBanks(lpabanks);

                JAXBElement<String> addmaterials = new JAXBElement<>(_TBPCommonAddMaterials_QNAME,String.class,bpCard.getLbaBanks());
                tbpCommon.setAddMaterials(addmaterials);

                tBankingProductCard.setCommon(tbpCommon);

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            service.liquidation(tBankingProductCard);

        }

    }

    private TBankingProductCard gettBankingProductCard(BPCard bpCard, QName qName){

        TBankingProductCard tBankingProductCard = new TBankingProductCard();
        try {

        TBPCommon tbpCommon = new TBPCommon();
        tbpCommon.setBpID(bpCard.getbPId());
        tbpCommon.setProductName(bpCard.getProductName());
        JAXBElement<String> commonProductChars = new JAXBElement<>(qName,String.class,bpCard.getCommonProductChars());
        tbpCommon.setCommonProductChars(commonProductChars);
        tbpCommon.setProductStatus(bpCard.getProductStatus());

        Date date = format.parse(bpCard.getChangeStatusDate());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        tbpCommon.setChangeStatusDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));

        JAXBElement<String> prodAdvantages = new JAXBElement<>(qName,String.class,bpCard.getCommonProductChars());
        tbpCommon.setProductAdvantages(prodAdvantages);

        tbpCommon.setMainProductParams(bpCard.getMainProductParams());

        JAXBElement<String> docsForms = new JAXBElement<>(qName,String.class,bpCard.getDocsForms());
        tbpCommon.setDocsForms(docsForms);

        JAXBElement<String> lpabanks = new JAXBElement<>(qName,String.class,bpCard.getLbaBanks());
        tbpCommon.setLpaBanks(lpabanks);

        JAXBElement<String> addmaterials = new JAXBElement<>(qName,String.class,bpCard.getLbaBanks());
        tbpCommon.setAddMaterials(addmaterials);



        tBankingProductCard.setCommon(tbpCommon);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return tBankingProductCard;
    }


   /* private static class CreateInstance {
        private static String CLIENT_CONFIG = "D:\\16.12.2020\\kkk\\Catalog\\AdminConsole\\by.belinvest.panel.admin\\src\\main\\java\\by\\belinvest\\panel\\admin\\catalog\\service\\wf_client_config.xml";
        private static BPMServiceClientFactory bpmFactory_;
        private static IBPMServiceClient bpmClient_;
        private static IWorkflowServiceClient wfClient_;
        private static IBPMContext bpmCtx_;
        private static ITaskService taskService_;

        public static void main () {
            try {
                // get a BPM factory
                bpmFactory_ = getServiceClientFactory(CLIENT_CONFIG);

                // get a BPM client
                bpmClient_ = bpmFactory_.getBPMServiceClient();

                if (bpmClient_ != null) {
                    System.out.println("Got a BPM client.");
                }

                // TODO: Change credentials for your environment. You must also change your wf_client_config to point to your domain
                bpmCtx_ = getContext("testuser1", "12345678", null);

                if (bpmCtx_ != null) {
                    System.out.println("Got a BPM context.");
                }

                // Get a handle on a BPM WorkflowServiceClient so we can get more information about the task we create later.
                wfClient_ = bpmFactory_.getWorkflowServiceClient();

                // Get a handle on a BPM Task Service so we can use it to update the task.
                taskService_ = wfClient_.getTaskService();


                List<ProcessMetadataSummary> procMetaSummary = getInitiatableProcessList(bpmCtx_);
                System.out.println("Got a list of initiable processes.");

                for (ProcessMetadataSummary pms : procMetaSummary) {
                    String compositeDN, processName;
                    compositeDN = pms.getCompositeDN();
                    processName = pms.getProcessName();
                    String processDN = pms.getCompositeDN() + "/" +  pms.getProcessName();

                    if (processName.equalsIgnoreCase("process")) {
                        //TODO: Change this value to the number of requests you wish to create
                        int numOfInstancesToCreate = 1;
                        for (int i=0; i < numOfInstancesToCreate; i++){
                            Task initdTask = initiateProcess(bpmCtx_, processDN);//null;

                            // get the task number from the new task so we can use it to the get URL of the human workflow to display later.
                            int taskNum = initdTask.getSystemAttributes().getTaskNumber();

                            initdTask = wfClient_.getTaskQueryService().getTaskDetailsByNumber(bpmCtx_, taskNum);

                            Element rootElement = initdTask.getPayloadAsElement();

                            // Manipulate payload values as necessary
                            String ticketNum = "";
                            Date dt = new Date();
                            SimpleDateFormat dateFormatMonthYear = new SimpleDateFormat("MMyy");
                            String ticketNumberMMyy = dateFormatMonthYear.format(dt);
                            ticketNum = ticketNumberMMyy + "-" + initdTask.getProcessInfo().getInstanceId();
                            rootElement.getElementsByTagName("ticketNumber").item(0).setTextContent(ticketNum);
                            initdTask.setPayloadAsElement(rootElement);

                            try {
                                initdTask = taskService_.updateTask(bpmCtx_, initdTask);
                            } catch (StaleObjectException e) {
                                e.printStackTrace();
                            }

                            // Create a map to pass params to the WorklistUtil object. This is used to get the URL of the Human Workflow Task to display
                            Map params = new HashMap();
                            params.put(Constants.BPM_WORKLIST_TASK_ID, initdTask.getSystemAttributes().getTaskId());
                            params.put(Constants.BPM_WORKLIST_CONTEXT, bpmCtx_.getToken());
                            String url = "";
                            try {
                                url = WorklistUtil.getTaskDisplayURL(wfClient_, bpmCtx_, initdTask, null, "worklist", params);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Task URL: " + url);
                        }
                    }
                }
            } catch (WorkflowException e) {
                e.printStackTrace();
            } catch (ProcessMetadataServiceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bpmCtx_ != null) {
                    try {
                        bpmFactory_.getBPMUserAuthenticationService().destroyBPMContext(bpmCtx_);
                        System.out.println("Garbage collected the bpm context.");
                    } catch (BPMException e) {
                        System.out.println("Unable to dispose of BPM Context for user: " + bpmCtx_.getUser());
                    }
                }
            }
        }



        public static BPMServiceClientFactory getServiceClientFactory(String fileName) {
            WorkflowServicesClientConfigurationType cfg = new WorkflowServicesClientConfigurationType();
           *//* if(cfg == null) {
                throw new RuntimeException("workflow client configuration file not found:"+fileName);
            }*//*
            ServerType serverType = new ServerType();
            RemoteClientType remoteClientType = new RemoteClientType();
            cfg.getServer().add(serverType);

            cfg.setClientType("REMOTE");
            cfg.getServer().get(0).setRemoteClient(new RemoteClientType());
            cfg.getServer().get(0).getRemoteClient().setUserName("weblogic");

            RemoteClientType.Password password = new RemoteClientType.Password();

            remoteClientType.setPassword(password);
            password.setValue("welcome1");
            cfg.getServer().get(0).getRemoteClient().setPassword(password);

            cfg.getServer().get(0).getRemoteClient().setServerURL("t3://soabpm-server:7004/soa-infra");

            cfg.getServer().get(0).setName("default");
            cfg.getServer().get(0).setDefault(true);
            cfg.getServer().get(0).getRemoteClient().setInitialContextFactory("weblogic.jndi.WLInitialContextFactory");

            cfg.getServer().get(0).getRemoteClient().setParticipateInClientTransaction(true);

            cfg.getServer().get(0).setSoapClient(new SoapClientType());

            cfg.getServer().get(0).getSoapClient().setRootEndPointURL("http://soabpm-server:7004/");
            cfg.getServer().get(0).getSoapClient().setIdentityPropagation(new IdentityPropagationType());

            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().setMode("dynamic");

            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().setType("saml");

            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().setPolicyReferences(new PolicyReferencesType());


            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().getPolicyReferences().getPolicyReference().add(new PolicyReferenceType());

            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().getPolicyReferences().getPolicyReference().get(0).setEnabled(true);

            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().getPolicyReferences().getPolicyReference().get(0).setCategory("security");

            cfg.getServer().get(0).getSoapClient().getIdentityPropagation().getPolicyReferences().getPolicyReference().get(0).setUri("oracle/wss10_saml_token_client_policy");




            return BPMServiceClientFactory.getInstance(cfg, null);
        }



        public static IBPMContext getContext(String userName, String password, String authenticationContext) throws WorkflowException {
            IWorkflowServiceClient client = bpmFactory_.getWorkflowServiceClient();
            char[] passwordCharArray = null;
            if(password != null) {
                passwordCharArray = password.toCharArray();
            }
            IBPMContext ctx = null;
            try {
                ctx =
                        (IBPMContext) bpmFactory_.getBPMUserAuthenticationService().authenticate(userName, passwordCharArray, authenticationContext);
            } catch (BPMException e) {
                e.printStackTrace();
            }
            return ctx;
        }

        public static List<ProcessMetadataSummary> getInitiatableProcessList(IBPMContext context) throws Exception {
            IProcessMetadataService service = bpmClient_.getProcessMetadataService();
            return service.getInitiatableProcesses(context);
        }

        public static Task initiateProcess(IBPMContext context, String processDn) throws Exception {
            return bpmClient_.getInstanceManagementService().createProcessInstanceTask(context, processDn );
        }

    }*/
}


