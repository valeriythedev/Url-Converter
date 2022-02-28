package by.liashuk.urlconverter.rest;

import by.liashuk.urlconverter.dto.WebSiteUrlDTO;
import by.liashuk.urlconverter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping(value = "/api/converter/",
produces = MediaType.APPLICATION_JSON_VALUE,
consumes = MediaType.APPLICATION_JSON_VALUE)
public class ConverterController {

    private final ConverterService converterService;

    @Autowired
    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public File convertUrl(@RequestBody WebSiteUrlDTO body) {
        return converterService.getPdfFromUrl(body);
    }
}
