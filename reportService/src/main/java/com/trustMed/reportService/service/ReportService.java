package com.trustMed.reportService.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustMed.reportService.entity.FamilyDoctorQuestionnaire;
import com.trustMed.reportService.entity.InsuredQuestionnaire;
import com.trustMed.reportService.entity.TreatingDoctor;
import com.trustMed.reportService.repository.FamilyDoctorRepository;
import com.trustMed.reportService.repository.InsuredQuestionnaireRepository;
import com.trustMed.reportService.repository.TreatingDoctorRepository;

@Service
public class ReportService {

    @Autowired
    private InsuredQuestionnaireRepository insuredQuestionnaireRepository;

    @Autowired
    private TreatingDoctorRepository treatingDoctorRepository;

    @Autowired
    private FamilyDoctorRepository familyDoctorRepository;

    public ByteArrayInputStream generateReport() throws IOException {
        List<InsuredQuestionnaire> insuredData = insuredQuestionnaireRepository.findAll();
        List<TreatingDoctor> doctorsData = treatingDoctorRepository.findAll();
        List<FamilyDoctorQuestionnaire> familyDoctorData = familyDoctorRepository.findAll();

        // Using Apache POI to create Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet insuredSheet = workbook.createSheet("Insured Questionnaire");
        Sheet doctorsSheet = workbook.createSheet("Treating Doctors");
        Sheet familySheet = workbook.createSheet("Family Doctors");

        // Fill sheets with data
        fillSheet(insuredSheet, insuredData);
        fillSheet(doctorsSheet, doctorsData);
        fillSheet(familySheet, familyDoctorData);

        // Write to ByteArrayOutputStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    private <T> void fillSheet(Sheet sheet, List<T> data) {
        int rowNum = 0;
        for (T item : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Field field : item.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    row.createCell(colNum++).setCellValue(String.valueOf(field.get(item)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
