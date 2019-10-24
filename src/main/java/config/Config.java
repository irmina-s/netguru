package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Properties properties;

    public Config()
    {
        properties = getProperties();
    }

    private Properties getProperties()
    {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            assert inputStream != null;
            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load properties file: " + e);
        }
        return prop;
    }

    public String getApplicationUrl()
    {
        return properties.getProperty("application.url");
    }

    public String getApplicationUser()
    {
        return properties.getProperty("application.user");
    }

    public String getApplicationIncorrectPassword()
    {
        return properties.getProperty("application.incorrect.password");
    }

    public String getApplicationEmail()
    {
        return properties.getProperty("application.email");
    }
}