package wromaciej.hvac_sim.core.database.configuration;


import java.util.HashMap;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "wromaciej.hvac_sim.core.database.repository.simulation",
        entityManagerFactoryRef = "simulationEntityManager",
        transactionManagerRef = "simulationTransactionManager"
)
public class SimulationDatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean simulationEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(simulationDataSource());
        em.setPackagesToScan(
                new String[]{"wromaciej.hvac_sim.simulation"});

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource simulationDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("spring.database_simulation.driver"));
        dataSource.setUrl(env.getProperty("spring.database_simulation.url"));
        dataSource.setUsername(env.getProperty("spring.database_simulation.username"));
        dataSource.setPassword(env.getProperty("spring.database_simulation.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager simulationTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                simulationEntityManager().getObject());
        return transactionManager;
    }
}
