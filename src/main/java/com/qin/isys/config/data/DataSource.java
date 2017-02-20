package com.qin.isys.config.data;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Q on 2017/2/20.
 */
@Component
public class DataSource extends DriverManagerDataSource{
    @PostConstruct
    public void init(){
        this.setDriverClassName("com.mysql.jdbc.Driver");
        this.setUrl("jdbc:mysql://localhost/isys");
        this.setUsername("dev");
        this.setPassword("devMysql");
    }
}
