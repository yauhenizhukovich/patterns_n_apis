package by.compit.yauheni.zhukovich.entity_to_docx.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.entity_to_docx.service.WordService;
import by.compit.yauheni.zhukovich.entity_to_docx.service.model.BusinessOfferDTO;

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
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.WordConstant.RGB_COLOR_SILVER;
import static by.compit.yauheni.zhukovich.entity_to_docx.constant.WordConstant.TIMES_NEW_ROMAN_FONT;

@Service
public class WordServiceImpl implements WordService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void generateMainFile(BusinessOfferDTO businessOffer) throws IOException {
        Map<String, List<String>> businessOfferCollections = businessOffer.getCollections();
        Map<String, String> businessOfferFields = businessOffer.getSimpleFields();
        try (XWPFDocument document = new XWPFDocument()) {
            writeFirstPage(businessOfferFields, document);
            writeSecondPageBeforeTable(document);
            writeTableBO(businessOfferCollections, businessOfferFields, document);
            XWPFParagraph p = document.createParagraph();
            p.setPageBreak(true);
            writeTableTerms(businessOfferFields, document);
            writeTextAfterTermsTable(businessOfferFields, businessOfferCollections, document);
            String id = businessOfferFields.get(ID);
            try (FileOutputStream out = new FileOutputStream("test" + File.separator + "business_offer_#" + id + ".docx")) {
                document.write(out);
            }
        }
    }

    @Override
    public void generateMarketAnalysisFile(BusinessOfferDTO businessOffer) throws IOException {
        Map<String, List<String>> businessOfferCollections = businessOffer.getCollections();
        Map<String, String> businessOfferFields = businessOffer.getSimpleFields();
        List<String> marketAnalysisFiles = businessOfferCollections.get(MARKET_ANALYSIS_FILES);
        for (String marketAnalysisFile : marketAnalysisFiles) {
            try (XWPFDocument document = new XWPFDocument()) {
                logger.info("try (XWPFDocument document = new XWPFDocument()) {");
                XWPFParagraph p = document.createParagraph();
                logger.info("XWPFParagraph p = document.createParagraph();");
                XWPFRun r = p.createRun();
                logger.info("XWPFRun r = p.createRun();");
                r.setFontSize(16);
                r.setFontFamily(TIMES_NEW_ROMAN_FONT);
                String id = businessOfferFields.get(ID);
                logger.info(id);
                r.setText("Файл для анализа рынка. Бизнес-предложение №" + id);
                r.addBreak();
                r = p.createRun();
                r.setFontSize(14);
                r.setFontFamily(TIMES_NEW_ROMAN_FONT);
                r.setText(marketAnalysisFile);
                try (FileOutputStream out = new FileOutputStream("market_analysis_BO_#" + id + ".docx")) {
                    document.write(out);
                }
            }
        }
    }

    @Override
    public void generateProfitabilityCalculationFile(BusinessOfferDTO businessOffer) throws IOException {
        Map<String, String> businessOfferFields = businessOffer.getSimpleFields();
        String profitabilityCalculation = businessOfferFields.get(PROFITABILITY_CALCULATION);
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph p = document.createParagraph();
            XWPFRun r = p.createRun();
            r.setFontSize(16);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            String id = businessOfferFields.get(ID);
            r.setText("Расчет доходности. Бизнес-предложение №" + id);
            r.addBreak();
            r = p.createRun();
            r.setFontSize(14);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setText(profitabilityCalculation);
            try (FileOutputStream out = new FileOutputStream("profitability_calculation_BO_#" + id + ".docx")) {
                document.write(out);
            }
        }
    }

    @Override
    public void generateProcessModelFile(BusinessOfferDTO businessOffer) throws IOException {
        Map<String, String> businessOfferFields = businessOffer.getSimpleFields();
        String processModel = businessOfferFields.get(PROCESS_MODEL);
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph p = document.createParagraph();
            XWPFRun r = p.createRun();
            r.setFontSize(16);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            String id = businessOfferFields.get(ID);
            r.setText("Модель процесса. Бизнес-предложение №" + id);
            r.addBreak();
            r = p.createRun();
            r.setFontSize(14);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setText(processModel);
            try (FileOutputStream out = new FileOutputStream("process_model_BO_#" + id + ".docx")) {
                document.write(out);
            }
        }
    }

    @Override
    public void generateProjectDecisionFile(BusinessOfferDTO businessOffer) throws IOException {
        Map<String, String> businessOfferFields = businessOffer.getSimpleFields();
        String decisionProject = businessOfferFields.get(DECISION_PROJECT);
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph p = document.createParagraph();
            XWPFRun r = p.createRun();
            r.setFontSize(16);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            String id = businessOfferFields.get(ID);
            r.setText("Проект решения. Бизнес-предложение №" + id);
            r.addBreak();
            r = p.createRun();
            r.setFontSize(14);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setText(decisionProject);
            try (FileOutputStream out = new FileOutputStream("decision_project_BO_#" + id + ".docx")) {
                document.write(out);
            }
        }
    }

    @Override
    public void generateExplanatoryNoteFile(BusinessOfferDTO businessOffer) throws IOException {
        Map<String, String> businessOfferFields = businessOffer.getSimpleFields();
        String explanatoryNote = businessOfferFields.get(EXPLANATORY_NOTE);
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph p = document.createParagraph();
            XWPFRun r = p.createRun();
            r.setFontSize(16);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            String id = businessOfferFields.get(ID);
            r.setText("Пояснительная записка. Бизнес-предложение №" + id);
            r.addBreak();
            r = p.createRun();
            r.setFontSize(14);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setText(explanatoryNote);
            try (FileOutputStream out = new FileOutputStream("explanatory_note_BO_#" + id + ".docx")) {
                document.write(out);
            }
        }
    }

    private void writeTableTerms(
            Map<String, String> businessOfferFields,
            XWPFDocument document
    ) {
        XWPFTable table = document.createTable();
        setTableProperties(table);
        setTermsTableHeader(table);
        setRow("Предлагаемая дата внедрения Продукта", businessOfferFields.get(PROPOSED_PRODUCT_IMPL_DATE), table);
        setRow("Предлагаемый срок достижения экономического эффекта/получения выгоды для бизнеса от внедрения Продукта",
                businessOfferFields.get(PROPOSED_DEADLINE_ACHIEVE_EFFECT), table);
    }

    private void writeTableRisks(
            Map<String, List<String>> businessOfferCollections,
            XWPFDocument document
    ) {
        XWPFTable table = document.createTable();
        setTableProperties(table);
        List<String> risks = businessOfferCollections.get(RISK_NAMES);
        List<String> occurrenceProbabilities = businessOfferCollections.get(OCCURRENCE_PROBABILITIES);
        List<String> stopFactors = businessOfferCollections.get(STOP_FACTORS);
        XWPFTableRow row = table.getRow(0);

        XWPFTableCell c = row.getCell(0);
        c.setColor(RGB_COLOR_SILVER);
        c.removeParagraph(0);
        XWPFParagraph p = c.addParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = p.createRun();
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setFontSize(14);
        r.setText("Описание риска продукта");

        c = row.addNewTableCell();
        c.setColor(RGB_COLOR_SILVER);
        c.removeParagraph(0);
        p = c.addParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        r = p.createRun();
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setFontSize(14);
        r.setText("Вероятность возникновения");

        c = row.addNewTableCell();
        c.setColor(RGB_COLOR_SILVER);
        c.removeParagraph(0);
        p = c.addParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        r = p.createRun();
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setFontSize(14);
        r.setText("Предложение по минимизации рисков");
        for (int i = 0; i < risks.size(); i++) {
            row = table.createRow();
            c = row.getCell(0);
            c.removeParagraph(0);
            p = c.addParagraph();
            p.setAlignment(ParagraphAlignment.CENTER);
            r = p.createRun();
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setFontSize(14);
            r.setText(risks.get(i));

            c = row.getCell(1);
            c.removeParagraph(0);
            p = c.addParagraph();
            p.setAlignment(ParagraphAlignment.CENTER);
            r = p.createRun();
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setFontSize(14);
            r.setText(occurrenceProbabilities.get(i));

            c = row.getCell(2);
            c.removeParagraph(0);
            p = c.addParagraph();
            p.setAlignment(ParagraphAlignment.CENTER);
            r = p.createRun();
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setFontSize(14);
            r.setText(stopFactors.get(i));
        }
    }

    private void setTermsTableHeader(XWPFTable table) {
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell c = row.getCell(0);
        c.setColor(RGB_COLOR_SILVER);
        c.getCTTc().addNewTcPr();
        c.getCTTc().getTcPr().addNewGridSpan();
        c.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
        XWPFParagraph p = c.addParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText("СРОКИ");
    }

    private void writeTableBO(
            Map<String, List<String>> businessOfferCollections,
            Map<String, String> businessOfferFields,
            XWPFDocument document
    ) {
        XWPFTable table = document.createTable();
        setTableProperties(table);
        setBOTableHeader(businessOfferFields, table);
        setBusinessGoals(businessOfferCollections, table);
        String productManagerDept = businessOfferFields.get(PRODUCT_MANAGER_DEPT);
        setRow("Подразделение-разработчик Продукта", productManagerDept, table);
        setProductManager(businessOfferFields, table);
        setProductManagerSupervisor(
                businessOfferFields, table);
    }

    private void setRow(String leftColumn, String rightColumn, XWPFTable table) {
        XWPFTableRow row = table.createRow();
        XWPFTableCell c = row.getCell(0);
        c.removeParagraph(0);
        XWPFParagraph p = c.addParagraph();
        XWPFRun r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText(leftColumn);
        c = row.createCell();
        c.removeParagraph(0);
        p = c.addParagraph();
        r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText(rightColumn);
    }

    private void setProductManager(Map<String, String> businessOfferFields, XWPFTable table) {
        XWPFTableRow row = table.createRow();
        XWPFTableCell c = row.getCell(0);
        c.removeParagraph(0);
        XWPFParagraph p = c.addParagraph();
        XWPFRun r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText("Менеджер Продукта (должность, ФИО, номер телефона)");
        c = row.createCell();
        c.removeParagraph(0);
        p = c.addParagraph();
        r = p.createRun();
        r.setFontSize(14);
        String productManagerPosition = businessOfferFields.get(PRODUCT_MANAGER_POSITION);
        String productManager = businessOfferFields.get(PRODUCT_MANAGER);
        String productManagerPhone = businessOfferFields.get(PRODUCT_MANAGER_PHONE);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText(productManagerPosition + ",");
        r.addBreak();
        r.setText(productManager + ",");
        r.addBreak();
        r.setText(productManagerPhone + ",");
        r.addBreak();
    }

    private void setProductManagerSupervisor(Map<String, String> businessOfferFields, XWPFTable table) {
        XWPFTableRow row = table.createRow();
        XWPFTableCell c = row.getCell(0);
        c.removeParagraph(0);
        XWPFParagraph p = c.addParagraph();
        XWPFRun r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText("Руководитель структурного подразделения – разработчика Продукта (должность, ФИО, номер телефона)");
        c = row.createCell();
        c.removeParagraph(0);
        p = c.addParagraph();
        r = p.createRun();
        r.setFontSize(14);
        String productManagerSupervisorPosition = businessOfferFields.get(PRODUCT_MANAGER_SUPERVISOR_POS);
        String productManagerSupervisor = businessOfferFields.get(PRODUCT_MANAGER_SUPERVISOR);
        String productManagerSupervisorPhone = businessOfferFields.get(PRODUCT_MANAGER_SUPERVISOR_PHONE);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText(productManagerSupervisorPosition + ",");
        r.addBreak();
        r.setText(productManagerSupervisor + ",");
        r.addBreak();
        r.setText(productManagerSupervisorPhone + ",");
        r.addBreak();
    }

    private void setBusinessGoals(Map<String, List<String>> businessOfferCollections, XWPFTable table) {
        List<String> businessGoals = businessOfferCollections.get(BUSINESS_GOALS);
        for (int i = 0; i < businessGoals.size(); i++) {
            XWPFTableRow row = table.createRow();
            XWPFTableCell c = row.getCell(0);
            c.removeParagraph(0);
            XWPFParagraph p = c.addParagraph();
            if (i == 0) {
                XWPFRun r = p.createRun();
                r.setFontSize(14);
                r.setFontFamily(TIMES_NEW_ROMAN_FONT);
                r.setText("Бизнес – цели");
            }
            c = row.addNewTableCell();
            c.removeParagraph(0);
            p = c.addParagraph();
            XWPFRun r = p.createRun();
            r.setFontSize(14);
            r.setFontFamily(TIMES_NEW_ROMAN_FONT);
            r.setText(businessGoals.get(i));
        }
        CTVMerge vmergeRestart = CTVMerge.Factory.newInstance();
        vmergeRestart.setVal(STMerge.RESTART);
        CTVMerge vmergeContinue = CTVMerge.Factory.newInstance();
        vmergeContinue.setVal(STMerge.CONTINUE);
        for (int i = 1; i < businessGoals.size() + 1; i++) {
            table.getRow(i).getCell(0).getCTTc().addNewTcPr();
            if (i == 1) {
                table.getRow(i).getCell(0).getCTTc().getTcPr().setVMerge(vmergeRestart);
            } else {
                table.getRow(i).getCell(0).getCTTc().getTcPr().setVMerge(vmergeContinue);
            }
        }
    }

    private void setBOTableHeader(Map<String, String> businessOfferFields, XWPFTable table) {
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell c = row.getCell(0);
        c.setColor(RGB_COLOR_SILVER);
        c.getCTTc().addNewTcPr();
        c.getCTTc().getTcPr().addNewGridSpan();
        c.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
        XWPFParagraph p = c.addParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText("БИЗНЕС-ПРЕДЛОЖЕНИЕ");
        r.addBreak();
        r.setText(businessOfferFields.get(BO_NAME));
    }

    private void setTableProperties(XWPFTable table) {
        table.setWidth(8000);
        table.setCellMargins(100, 100, 100, 100);
        table.setLeftBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 0, RGB_COLOR_SILVER);
        table.setRightBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 0, RGB_COLOR_SILVER);
        table.setBottomBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 0, RGB_COLOR_SILVER);
        table.setTopBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 0, RGB_COLOR_SILVER);
        table.setInsideHBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 0, RGB_COLOR_SILVER);
        table.setInsideVBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 0, RGB_COLOR_SILVER);
    }

    private void writeSecondPageBeforeTable(XWPFDocument document) {
        XWPFParagraph p = document.createParagraph();
        p.setPageBreak(true);
        p.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r = p.createRun();
        r.setFontSize(16);
        r.setBold(true);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText("Содержание");
        addBreaksByCount(r, 2);
        r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText("1. Общая информация;");
        r.addBreak();
        r.setText("2. Описание бизнес-предложения;");
        r.addBreak();
        r.setText("2.1. Описание продукта;");
        r.addBreak();
        r.setText("2.2. Описание рисков продукта;");
        r.addBreak();
        r.setText("2.3. Анализ рынка;");
        r.addBreak();
        r.setText("2.4. Описание процесса (модель бизнес-процесса)/технологии бизнес-предложения;");
        r.addBreak();
        r.setText("2.5. Расчет доходности продукта и ожидания от внедрения бизнес-предложения.");
        addBreaksByCount(r, 2);
        r = p.createRun();
        r.setFontSize(16);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setBold(true);
        r.setText("1. ОБЩАЯ ИНФОРМАЦИЯ");
    }

    private void writeTextAfterTermsTable(Map<String, String> businessOfferFields, Map<String, List<String>> businessOfferCollections, XWPFDocument document) {
        XWPFParagraph p = document.createParagraph();
        p.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r = p.createRun();
        addBreaksByCount(r, 3);

        setRun(p, "2. ОПИСАНИЕ БИЗНЕС-ПРЕДЛОЖЕНИЯ", 16);
        setRun(p, "2.1. Описание продукта", 14);

        r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.addTab();
        r.setText(businessOfferFields.get(PRODUCT_DESC));
        r.addBreak();

        r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setBold(true);
        r.setText("2.2. Описание рисков продукта");
        writeTableRisks(businessOfferCollections, document);
        p = document.createParagraph();
        setRun(p, "2.3. Анализ рынка", 14);
        String id = businessOfferFields.get(ID);
        setHyperlinkRun(p, "market_analysis_BO_#" + id + ".docx", "market_analysis_BO_#" + id);

        setRun(p, "2.4. Описание процесса (модель бизнес-процесса)/технологии бизнес-предложения", 14);
        setHyperlinkRun(p, "process_model_BO_#" + id + ".docx", "process_model_BO_#" + id);

        setRun(p, "2.5. Расчет доходности продукта и ожидания от внедрения бизнес-предложения", 14);
        setHyperlinkRun(p, "profitability_calculation_BO_#" + id + ".docx", "profitability_calculation_BO_#" + id);

        r = p.createRun();
        r.setFontSize(14);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.addTab();
        r.setText("Срок окупаемости, месяц: " + businessOfferFields.get(PROFITABILITY_TERM));
        r.addBreak();
        r.addTab();
        r.setText("Срок предварительного мониторинга: " + businessOfferFields.get(PRELIMINARY_MONITORING_TERM));
        r.addBreak();

        setRun(p, "Материалы для комитета", 14);
        setHyperlinkRun(p, "decision_project_BO_#" + id + ".docx", "decision_project_BO_#" + id);
        setHyperlinkRun(p, "explanatory_note_BO_#" + id + ".docx", "explanatory_note_BO_#" + id);
    }

    private void setHyperlinkRun(XWPFParagraph p, String url, String text) {
        XWPFHyperlinkRun hr;
        hr = p.createHyperlinkRun(url);
        hr.addTab();
        hr.setFontFamily(TIMES_NEW_ROMAN_FONT);
        hr.setFontSize(14);
        hr.setColor("0000CD");
        hr.setText(text);
        hr.addBreak();
    }

    private void setRun(XWPFParagraph p, String text, int fontSize) {
        XWPFRun r = p.createRun();
        r.setFontSize(fontSize);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setBold(true);
        r.setText(text);
        r.addBreak();
    }

    private void writeFirstPage(Map<String, String> businessOfferFields, XWPFDocument document) {
        XWPFParagraph p = document.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = p.createRun();
        r.setFontSize(22);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        addBreaksByCount(r, 6);
        r.setText("БИЗНЕС-ПРЕДЛОЖЕНИЕ");
        r = p.createRun();
        r.setFontSize(22);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        addBreaksByCount(r, 2);
        r.setText(businessOfferFields.get(BO_NAME));
        addBreaksByCount(r, 13);
        p = document.createParagraph();
        p.setAlignment(ParagraphAlignment.RIGHT);
        r = p.createRun();
        r.setFontSize(18);
        r.setFontFamily(TIMES_NEW_ROMAN_FONT);
        r.setText(businessOfferFields.get(PRODUCT_MANAGER));
    }

    private void addBreaksByCount(XWPFRun r, int count) {
        for (int i = 0; i < count; i++) {
            r.addBreak();
        }
    }

}
