package by.liashuk.urlconverter.service;

import by.liashuk.urlconverter.dto.WebSiteUrlDTO;
import by.liashuk.urlconverter.model.WebSiteUrl;

import java.io.File;

public interface ConverterService {

    File getPdfFromUrl(WebSiteUrlDTO webSiteUrl);
}
