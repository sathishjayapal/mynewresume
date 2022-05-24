package me.sathish.resumemaker.controller;

import me.sathish.resumemaker.dto.ResumeUserProfileDto;
import me.sathish.resumemaker.service.WordResumeMakerService;
import me.sathish.resumemaker.util.ResumeFakeDataMaker;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.NotNull;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResumeMakerController implements me.sathish.resumemaker.util.ResumeFakeDataMaker {
    RestTemplate restTemplate;

    @GetMapping("/")
    public String rootHello() throws IOException {
        makeResumeDoc(ResumeFakeDataMaker.createSathishResume());
        return "OK";
    }

    @GetMapping("/makeResume")
    public String makeResume() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
        HttpEntity httpEntity = new HttpEntity(null, headers);
        ResponseEntity<ResumeUserProfileDto> responseEntity = restTemplate.exchange("http://myresumereader-service/view/foo", HttpMethod.GET, httpEntity, ResumeUserProfileDto.class);
        ResumeUserProfileDto output = responseEntity.getBody();
        return output.toString();
    }

    public void makeResumeDoc(ResumeUserProfileDto output) throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph[] headerParagraph = getXwpfParagraph(output, document);
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, headerParagraph);
        createSummarySection(document);
        createSummaryAccomplishmentSection(output, document);
        FileOutputStream out = new FileOutputStream(WordResumeMakerService.resumeFileName);
        document.write(out);
        out.close();
        document.close();
//        uploadDocument(out);
    }

    private void createSummarySection(XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun titleRun = paragraph.createRun();
        titleRun.addCarriageReturn();
        titleRun.setText("Experience Summary- ");
        titleRun.setBold(true);
        titleRun.setFontFamily("Times New Roman");
        titleRun.setFontSize(18);
    }

    private void createSummaryAccomplishmentSection(ResumeUserProfileDto output, XWPFDocument document) {
        List<String> skills = output.getSummarySkills();
        skills.stream().forEach(data -> {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun titleRun = paragraph.createRun();
            titleRun.addCarriageReturn();
            titleRun.setText(data);
            titleRun.setFontFamily("Times New Roman");
            titleRun.setFontSize(12);
        });
    }

    /*
    Header contains Name, Phone and Email ID.
    Three sections of the Paragraph to generate the data
     */
    @NotNull
    private XWPFParagraph[] getXwpfParagraph(ResumeUserProfileDto output, XWPFDocument document) {

        List<XWPFParagraph> paragraphList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CTP ctpNameHeader = CTP.Factory.newInstance();
            CTR ctrNameHeader = ctpNameHeader.addNewR();
            CTText ctNameHeader = ctrNameHeader.addNewT();
            switch (i) {
                case 0:
                    ctNameHeader.setStringValue(output.getName());
                    break;
                case 1:
                    ctNameHeader.setStringValue(output.getPhone());
                    break;
                case 2:
                    ctNameHeader.setStringValue(output.getEmail());
                    break;
            }
            XWPFParagraph headerNameParagraph = new XWPFParagraph(ctpNameHeader, document);
            headerNameParagraph.setAlignment(ParagraphAlignment.CENTER);
            paragraphList.add(headerNameParagraph);
        }

        return paragraphList.toArray(new XWPFParagraph[0]);
    }

}
