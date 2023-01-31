package com.distribuida.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jersey.jsonb.internal.JsonBindingAutoDiscoverable;
import org.jdbi.v3.core.Jdbi;

import javax.sql.DataSource;

@ApplicationScoped
public class Dbconfig {
    @Inject
    @ConfigProperty(name="db.username")
    private String dbUser;

    @Inject
    @ConfigProperty(name="db.password")
    private String dbPassword;

    @Inject
    @ConfigProperty(name="db.url")
    private String dbUrl;

    @Produces
    @ApplicationScoped
    public DataSource dataSource(){
        HikariDataSource ds= new HikariDataSource();

        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);

        //ds.setMinimumIdle(1);
        //ds.setMaximumPoolSize(5);
        return ds;
    }

    @Produces
    @ApplicationScoped
        public Jdbi jdbi(DataSource dataSource){
        Jdbi ret=Jdbi.create(dataSource);
        return ret;
    }
}
