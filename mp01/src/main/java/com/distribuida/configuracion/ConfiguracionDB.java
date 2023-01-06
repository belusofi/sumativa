package com.distribuida.configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jdbi.v3.core.Jdbi;

@ApplicationScoped
public class ConfiguracionDB {

    public static Jdbi init(){

        System.out.println("********post construct");

        Config c = ConfigProvider.getConfig();

        String url = c.getValue("db.url", String.class);
        String username = c.getValue("db.username", String.class);
        String password = c.getValue("db.password", String.class);
        String driver = c.getValue("db.driver",String.class);

        HikariConfig hc= new HikariConfig();
        hc.setMaximumPoolSize(6);
        hc.setJdbcUrl(url);
        hc.setUsername(username);
        hc.setPassword(password);
        hc.setDriverClassName(driver);

        Jdbi jdbi = Jdbi.create(new HikariDataSource(hc));

        return jdbi;

    }
}
