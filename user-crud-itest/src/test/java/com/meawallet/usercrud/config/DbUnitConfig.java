package com.meawallet.usercrud.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbUnitConfig {
    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        var databaseConfigBean = new DatabaseConfigBean();
        databaseConfigBean.setDatatypeFactory(new ExtendedH2DataTypeFactory());
        databaseConfigBean.setAllowEmptyFields(true);
        databaseConfigBean.setCaseSensitiveTableNames(false);
        databaseConfigBean.setQualifiedTableNames(true);
        return databaseConfigBean;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(DataSource dataSource, DatabaseConfigBean databaseConfigBean) {
        var factoryBean = new DatabaseDataSourceConnectionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setDatabaseConfig(databaseConfigBean);
        return factoryBean;
    }

    @Bean
    public DataSource dbUnitDataSource(@Value("${dbunit.datasource.url}") String url,
                                       @Value("${dbunit.datasource.username}") String username,
                                       @Value("${dbunit.datasource.password}") String password,
                                       @Value("${dbunit.datasource.driver}") String driver) {
        return DataSourceBuilder.create()
                                .driverClassName(driver)
                                .url(url)
                                .username(username)
                                .password(password)
                                .build();
    }


    public class ExtendedH2DataTypeFactory extends H2DataTypeFactory {
        @Override
        public DataType createDataType(int sqlType, String sqlTypeName, String tableName, String columnName) throws DataTypeException {
            if (sqlTypeName.equalsIgnoreCase("TIMESTAMP WITH TIME ZONE")) {
                return DataType.TIMESTAMP;
            }
            return super.createDataType(sqlType, sqlTypeName, tableName, columnName);
        }
    }
}