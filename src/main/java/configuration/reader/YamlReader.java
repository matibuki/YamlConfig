package configuration.reader;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.models.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class YamlReader {

    private static Logger logger = LoggerFactory.getLogger("YamlReader.class");

    public static Config config;

    public Config getConfig() {
        return config;
    }

    public YamlReader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.config = mapper.readValue(new File("src/main/resources/config.yaml"), Config.class);
            logger.info("YAML properties file loaded");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
