package me.sathish.resumemaker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties("myresumemaker-service")
@Getter
@Setter
public class DataSourceConfig {
    final Environment environment;
    private String url;
    private String info;
    private String inf;

    public DataSourceConfig(Environment environment) {
        this.environment = environment;
    }
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(info);
        dataSourceBuilder.password(inf);
        return dataSourceBuilder.build();
    }

}
