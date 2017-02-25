package com.restaurant.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

/**
 * Created by Martha on 2/25/2017.
 */
@Configuration
public class DBConfig {

    // region Datasource properties
    @Value("${hikari.url}")
    String url;
    @Value("${hikari.user}")
    String user;
    @Value("${hikari.password}")
    String password;
    @Value("${hikari.prepStmtCacheSize}")
    int cacheSize;
    @Value("${hikari.prepStmtCacheSqlLimit}")
    int cacheSizeLimit;
    @Value("${hikari.cachePrepStmts}")
    boolean prepStmtIsCached;
    @Value("${hikari.useServerPrepStmts}")
    boolean serverPrepStmtIsUsed;
    // endregion

    // region DataSource configuration properties
    @Value("${hikari.dataSourceClassName}")
    String dsClassName;
    @Value("${hikari.poolName}")
    String poolName;
    @Value("${hikari.maximumPoolSize}")
    int maxPoolSize;
    @Value("${hikari.minimumIdle}")
    int minIdlePoolSize;
    @Value("${hikari.connectionTimeout}")
    int connTimeout;
    @Value("${hikari.idleTimeout}")
    int idleTimeout;
    // endregion

    // region Hibernate properties
    @Value("${hibernate.dialect}")
    String dialect;
    @Value("${hibernate.hbm2ddl.auto}")
    String hbm2ddl;
    @Value("${hibernate.implicit_naming_strategy}")
    String namingStrategy;
    // endregion

    // Hibernate cache properties
    @Value("${hibernate.cache.provider_class}")
    String cacheProviderClass;
    @Value("${hibernate.cache.region.factory_class}")
    String cacheRegionFactory;
    @Value("${hibernate.cache.use_structured_entries}")
    boolean structuredEntriesIsUsed;
    @Value("${hibernate.cache.use_query_cache}")
    boolean queryIsCahced;
    @Value("${hibernate.cache.use_second_level_cache}")
    boolean secondLevelCacheIsUsed;
    // endregion

    // region Other hibernate properties
    @Value("${hibernate.format_sql}")
    boolean sqlIsFormatted;
    @Value("${hibernate.show_sql}")
    boolean sqlIsShown;
    // endregion

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig(dataSourceConfigProperties());
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.restaurant");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }

    private Properties dataSourceConfigProperties(){
        Properties configProperties = new Properties();
        configProperties.put("dataSourceClassName", dsClassName);
        configProperties.put("poolName", poolName);
        configProperties.put("maximumPoolSize", maxPoolSize);
        configProperties.put("minimumIdle", minIdlePoolSize);
        configProperties.put("connectionTimeout", connTimeout);
        configProperties.put("idleTimeout", idleTimeout);
        configProperties.put("dataSourceProperties", dataSourceProperties());
        return configProperties;
    }

    private Properties dataSourceProperties(){
        Properties dataSourceProperties = new Properties();
        dataSourceProperties.put("url", url);
        dataSourceProperties.put("user", user);
        dataSourceProperties.put("password", password);
        dataSourceProperties.put("prepStmtCacheSize", cacheSize);
        dataSourceProperties.put("prepStmtCacheSqlLimit", cacheSizeLimit);
        dataSourceProperties.put("cachePrepStmts", prepStmtIsCached);
        dataSourceProperties.put("useServerPrepStmts", serverPrepStmtIsUsed);
        return dataSourceProperties;
    }

    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.put("hibernate.implicit_naming_strategy", namingStrategy);

        properties.put("hibernate.cache.provider_class", cacheProviderClass);
        properties.put("hibernate.cache.region.factory_class", cacheRegionFactory);
        properties.put("hibernate.cache.use_structured_entries", structuredEntriesIsUsed);
        properties.put("hibernate.cache.use_query_cache", queryIsCahced);
        properties.put("hibernate.cache.use_second_level_cache", secondLevelCacheIsUsed);

        properties.put("hibernate.format_sql", sqlIsFormatted);
        properties.put("hibernate.show_sql", sqlIsShown);
        return properties;
    }

}

