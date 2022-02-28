package by.liashuk.urlconverter.service.impl;

import by.liashuk.urlconverter.model.WebSiteUrl;
import by.liashuk.urlconverter.repository.ConverterRepository;
import by.liashuk.urlconverter.service.ConverterService;
import com.ruiyun.jvppeteer.core.Puppeteer;
import com.ruiyun.jvppeteer.core.browser.Browser;
import com.ruiyun.jvppeteer.core.page.Page;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.LaunchOptionsBuilder;
import com.ruiyun.jvppeteer.options.PDFOptions;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ConverterServiceImpl implements ConverterService {

    private final ConverterRepository repository;

    @Autowired
    public ConverterServiceImpl(ConverterRepository repository) {
        this.repository = repository;
    }

    @SneakyThrows
    @Override
    public File getPdfFromUrl(WebSiteUrl body) {
        Optional<WebSiteUrl> siteUrlOptional = repository.findBySiteUrl(body.getSiteUrl());
        if (siteUrlOptional.isPresent()) {
            log.info("In ConverterServiceImpl getPdfFromUrl() url already exists : {}", siteUrlOptional.get());
            return new File(siteUrlOptional.get().getPdfUrl());
        } else {
            List<String> stringList = new ArrayList<>();
            stringList.add("--no-sandbox");
            stringList.add("--disable-setuid-sandbox");
            LaunchOptions options = new LaunchOptionsBuilder().withArgs(stringList).withHeadless(true).build();
            options.setExecutablePath("F:/chrome-win/chrome.exe");
            Browser browser = Puppeteer.launch(options);
            Page page = browser.newPage();
            page.goTo(body.getSiteUrl());
            String path = repository.findAll().size()+1+".pdf";
            PDFOptions pdfOptions = new PDFOptions();
            pdfOptions.setPath(path);
            page.pdf(pdfOptions);
            page.close();
            browser.close();
            body.setPdfUrl(path);
            repository.save(body);
            log.info("IN ConverterServiceImpl getPDFFromUrl() url: {}, pdf: {}", body.getSiteUrl(), path);
            return new File(path);
        }
    }
}
