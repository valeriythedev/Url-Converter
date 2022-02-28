package by.liashuk.urlconverter.dto.converter;

import by.liashuk.urlconverter.dto.WebSiteUrlDTO;
import by.liashuk.urlconverter.model.WebSiteUrl;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public WebSiteUrl toWebSiteUrl(WebSiteUrlDTO webSiteUrlDTO) {
        WebSiteUrl webSiteUrl = new WebSiteUrl();
        webSiteUrl.setSiteUrl(webSiteUrlDTO.getUrl());
        return webSiteUrl;
    }
}
