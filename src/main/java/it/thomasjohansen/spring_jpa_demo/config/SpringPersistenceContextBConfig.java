package it.thomasjohansen.spring_jpa_demo.config;

import it.thomasjohansen.spring_jpa_demo.domain_b.repository.EntityBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author thomas@thomasjohansen.it
 */
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = EntityBRepository.class,
        entityManagerFactoryRef = "entityManagerFactoryB"
)
@Configuration
public class SpringPersistenceContextBConfig implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryB() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(
                "it.thomasjohansen.spring_jpa_demo.domain_a.model",
                "it.thomasjohansen.spring_jpa_demo.domain_b.model"
        );
        factory.setDataSource(dataSource);
        Map<String, String> properties = new HashMap<>();
        factory.setJpaPropertyMap(properties);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManagerB() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactoryB().getObject());
        return tm;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManagerB();
    }
}
