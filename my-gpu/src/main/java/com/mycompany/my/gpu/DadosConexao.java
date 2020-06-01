
package com.mycompany.my.gpu;

import org.apache.commons.dbcp2.BasicDataSource;

public class DadosConexao {
     private BasicDataSource dataSource;
    
    public DadosConexao() {
        dataSource​ = new​ BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/monitorme");
        dataSource.setUsername("root");
        dataSource.setPassword("");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
