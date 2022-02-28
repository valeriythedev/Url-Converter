package by.liashuk.urlconverter.repository;

import by.liashuk.urlconverter.model.WebSiteUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConverterRepository extends JpaRepository<WebSiteUrl, Integer> {

    Optional<WebSiteUrl> findBySiteUrl(String url);
}
