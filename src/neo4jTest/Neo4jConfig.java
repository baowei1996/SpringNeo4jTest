package neo4jTest;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableNeo4jRepositories(basePackages = "neo4jTest.repository")
@EnableTransactionManagement
public class Neo4jConfig {
    private String url = "http://localhost:7687";
    private String username = "neo4j";
    private String password = "123456";

    @Bean
    public SessionFactory sessionFactory(){
        return new SessionFactory(configuration(),"neo4jTest.entity");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration(){
        ConfigurationSource properties = new ClasspathConfigurationSource("neo4jTest/ogm.properties");
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties).build();
//        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder().uri(url).credentials(username,password).build();
        return configuration;
    }

    @Bean(name = "transactionManager")
    public Neo4jTransactionManager transactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }

    @Bean(name = "neo4jTransactionTemplate")
    public TransactionTemplate neo4jTransactionTemplate(@Qualifier("transactionManager")Neo4jTransactionManager neo4jTransactionManager){
        return new TransactionTemplate(neo4jTransactionManager);
    }
}
