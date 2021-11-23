package ch.sjost.jsobra.matliste.utils;

import ch.sjost.jsobra.matliste.model.Material;
import ch.sjost.jsobra.matliste.repositories.MaterialRepository;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MaterialRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Material("6er Spatz", "Zelte", 5, "Im Estrich", "Spatzzelt ohne Vorzelt")));
        };
    }
}
