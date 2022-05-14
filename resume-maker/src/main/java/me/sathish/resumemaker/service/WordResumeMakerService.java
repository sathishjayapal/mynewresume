package me.sathish.resumemaker.service;

import me.sathish.resumemaker.dto.ResumeUserProfileDto;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class WordResumeMakerService {
    public static String resumeFileName = "sathish-resume.docx";

    public void makeResume(ResumeUserProfileDto output) throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = paragraph.createRun();
        titleRun.setText("Sathish K Jayapal");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);
        FileOutputStream out = new FileOutputStream(WordResumeMakerService.resumeFileName);
        document.write(out);
        out.close();
        document.close();
    }
}
