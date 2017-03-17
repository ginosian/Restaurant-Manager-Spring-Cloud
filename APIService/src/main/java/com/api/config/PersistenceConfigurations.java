package com.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by Martha on 2/27/2017.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PersistenceConfigurations {

    // region C3P0 Datasource Hibernate properties
    @Value("${spring.jpa.properties.org.hibernate.c3p0.min_size}")
    int min_size;
    @Value("${spring.jpa.properties.org.hibernate.c3p0.max_size}")
    int max_size;
    @Value("${spring.jpa.properties.org.c3p0.acquire_increment}")
    int increment;
    @Value("${datasource_driver_class}")
    String driverClass;
    @Value("${datasource_url}")
    String url;
    @Value("${datasource_username}")
    String username_c3p0;
    @Value("${datasource_password}")
    String password_c3p0;
    // endregion

    // region Hibernate properties
    @Value("${spring.jpa.properties.org.hibernate.dialect}")
    String dialect;
    @Value("${spring.jpa.properties.org.hibernate.hbm2ddl.auto}")
    String hbm2ddl_auto;
    @Value("${spring.jpa.properties.org.hibernate.implicit_naming_strategy}")
    String naming_strategy;
    @Value("${spring.jpa.properties.org.hibernate.generate_statistics}")
    boolean statistics;
    @Value("${spring.jpa.properties.org.hibernate.cache.provider_class}")
    String cache_provider_class;
    @Value("${spring.jpa.properties.org.hibernate.cache.region.factory_class}")
    String cache_region_factory_class;
    @Value("${spring.jpa.properties.org.hibernate.cache.use_query_cache}")
    boolean cache_use_query_cache;
    @Value("${spring.jpa.properties.org.hibernate.cache.use_second_level_cache}")
    boolean second_level_cache;
    @Value("${spring.jpa.properties.org.hibernate.cache.internal.StandardQueryCache.maxElementsInMemory}")
    int maxElementsInMemory;
    @Value("${spring.jpa.properties.org.hibernate.cache.internal.StandardQueryCache.eternal}")
    boolean eternal;
    @Value("${spring.jpa.properties.org.hibernate.cache.internal.StandardQueryCache.timeToLiveSeconds}")
    int timeToLiveSeconds;
    @Value("${spring.jpa.properties.org.hibernate.cache.internal.StandardQueryCache.overflowToDisk}")
    boolean overflowToDisk;
    @Value("${spring.jpa.properties.org.hibernate.cache.internal.StandardQueryCache.memoryStoreEvictionPolicy}")
    String memoryStoreEvictionPolicy;
    @Value("${spring.jpa.properties.org.hibernate.format_sql}")
    boolean format_sql;
    @Value("${spring.jpa.properties.org.hibernate.show_sql}")
    boolean show_sql;
    @Value("${spring.jpa.properties.org.hibernate.enable_lazy_load_no_trans}")
    boolean trans_lazy_load;
    // endregion

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username_c3p0);
        dataSource.setPassword(password_c3p0);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.api");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
        properties.put("hibernate.implicit_naming_strategy", naming_strategy);
        properties.put("hibernate.generate_statistics", statistics);
        properties.put("hibernate.cache.provider_class", cache_provider_class);
        properties.put("hibernate.cache.region.factory_class", cache_region_factory_class);
        properties.put("hibernate.cache.use_query_cache", cache_use_query_cache);
        properties.put("hibernate.cache.use_second_level_cache", second_level_cache);
        properties.put("maxElementsInMemory", maxElementsInMemory);
        properties.put("eternal", eternal);
        properties.put("timeToLiveSeconds", timeToLiveSeconds);
        properties.put("overflowToDisk", overflowToDisk);
        properties.put("memoryStoreEvictionPolicy", memoryStoreEvictionPolicy);
        properties.put("hibernate.format_sql", format_sql);
        properties.put("hibernate.show_sql", show_sql);
        properties.put("hibernate.c3p0.min_size", min_size);
        properties.put("hibernate.c3p0.max_size", max_size);
        properties.put("hibernate.c3p0.acquire_increment", increment);
        properties.put("hibernate.enable_lazy_load_no_trans", trans_lazy_load);
        return properties;
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }

}
