package me.sathish.resumemaker.controller;

import me.sathish.resumemaker.dto.ResumeUserProfileDto;
import me.sathish.resumemaker.service.WordResumeMakerService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@RestController
public class ResumeMakerController {
    final
    WordResumeMakerService wordResumeMakerService;
    RestTemplate restTemplate;

    public ResumeMakerController(WordResumeMakerService wordResumeMakerService, RestTemplate restTemplate) {
        this.wordResumeMakerService = wordResumeMakerService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String rootHello() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
        HttpEntity httpEntity = new HttpEntity(null, headers);
        ResponseEntity<ResumeUserProfileDto> responseEntity = restTemplate.exchange("http://myresumereader-service/view/foo", HttpMethod.GET, httpEntity, ResumeUserProfileDto.class);
        ResumeUserProfileDto output = responseEntity.getBody();
        wordResumeMakerService.makeResume(output);
        return output.toString();
    }
}
