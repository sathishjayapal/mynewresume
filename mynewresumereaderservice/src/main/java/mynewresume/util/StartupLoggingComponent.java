package mynewresume.util;

import com.google.common.collect.Lists;
import mynewresume.config.DataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartupLoggingComponent implements InitializingBean {
    private static final String ENV_TARGET_KEY = "envTarget";
    private static final String PERSISTENCE_TARGET_KEY = "persistenceTarget";
    private static final String ACTIVE_SPRING_PROFILE_KEY = "spring.profiles.active";
    private static final String PERSISTENCE_HOST_KEY = "jdbc.url";
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final DataSourceConfig dataSourceConfig;
    private final Environment env;

    public StartupLoggingComponent(Environment env, DataSourceConfig dataSourceConfig) {
        super();
        this.env = env;
        this.dataSourceConfig = dataSourceConfig;
    }

    //

    @Override
    public void afterPropertiesSet() {
        logger.info("============================================================================");
        try {
            logEnvTarget(env);
            logPersistenceTarget(env);
            logPersistenceData(dataSourceConfig.getUrl());
        } catch (final Exception ex) {
            logger.warn("There was a problem logging data on startup", ex);
        }

        logger.info("============================================================================");
    }

    // UTIL

    private void logEnvTarget(final Environment environment) {
        final String envTarget = getValueOfProperty(environment, ENV_TARGET_KEY, "dev", Lists.newArrayList("dev"));
        logger.info("{} = {}", ENV_TARGET_KEY, envTarget);
    }

    private void logPersistenceTarget(final Environment environment) {
        final String envTarget = getValueOfProperty(environment, PERSISTENCE_TARGET_KEY, "h2", Lists.newArrayList("h2", "mysql"));
        logger.info("{} = {}", PERSISTENCE_TARGET_KEY, envTarget);
    }

    private void logPersistenceData(final String str) {
        logger.info("{} = {}", PERSISTENCE_HOST_KEY, str);
    }

    //

    private final String getValueOfProperty(final Environment environment, final String propertyKey, final String propertyDefaultValue, final List<String> acceptablePropertyValues) {
        String propValue = environment.getProperty(propertyKey);
        if (propValue == null) {
            propValue = propertyDefaultValue;
            logger.info("The {} doesn't have an explicit value; default value is = {}", propertyKey, propertyDefaultValue);
        }

        if (acceptablePropertyValues != null) {
            if (!acceptablePropertyValues.contains(propValue)) {
                logger.warn("The property = {} has an invalid value = {}", propertyKey, propValue);
            }
        }

        if (propValue == null) {
            logger.warn("The property = {} is null", propertyKey);
        }

        return propValue;
    }
}
