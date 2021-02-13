package grouv.config;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement//informs the Spring container to take into account annotations about @Transactional.
public class DatabaseConfig {
    
    //defines a datasource (a factory of connections to the database).
    private DataSource getDatasource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/individual_part_b?serverTimezone=Europe/Athens");
        datasource.setUsername("user");
        datasource.setPassword("");
        return datasource;
    }
    
    //adds hibernate properties.
    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
    //creates a SessionFactory (a factory for Session objects).
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        DataSource datasource = getDatasource();
        sessionFactory.setDataSource(datasource);
        Properties properties = getHibernateProperties();
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan("grouv.entity");
        return sessionFactory;
    }
    //method to take care of transactions.
    @Bean//makes HibernateTransactionManager a bean in order to go into Spring Container.
    @Autowired//injects SessionFactory into the following method.
    public HibernateTransactionManager transactionManager(SessionFactory s){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
