package by.liashuk.urlconverter.service;

import by.liashuk.urlconverter.model.WebSiteUrl;

import java.io.File;

public interface ConverterService {

    File getPdfFromUrl(WebSiteUrl webSiteUrl);
}
