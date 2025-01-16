package com.atapia.main;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbPoolDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MariaDbConfig {

    @Bean
    DataSource dataSource() {
        MariaDbPoolDataSource dataSource = new MariaDbPoolDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/gym_management");
            dataSource.setUser("root");
            dataSource.setPassword("1512");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}