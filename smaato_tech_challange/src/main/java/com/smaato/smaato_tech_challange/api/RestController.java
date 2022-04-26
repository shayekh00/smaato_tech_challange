package com.smaato.smaato_tech_challange.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/api/smaato/accept")
@org.springframework.web.bind.annotation.RestController
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)


public class RestController {

    private int id;

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @GetMapping("/{id}")
    public String getID(@PathVariable(value = "id") int id  ) throws JsonProcessingException {

        try {
            String uri = "http://localhost:8080/actuator/metrics/http.server.requests";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);

            result= result.substring(116,119);
            logger.info("COUNT OF REQUESTS", result );
            logger.info("Response Status", HttpStatus.OK);
            return "ok";

        } catch (Exception ex) {
            logger.info("Response Status", HttpStatus.BAD_REQUEST);
            return "failed";
        }


    }


}
