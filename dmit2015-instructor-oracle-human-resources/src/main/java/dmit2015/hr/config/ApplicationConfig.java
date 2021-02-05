package dmit2015.hr.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
        name = "java:app/datasources/oracleHrDs",
        className = "oracle.jdbc.pool.OracleDataSource",
        url = "jdbc:oracle:thin:@localhost:11521/XEPDB1",
        user = "HR",
        password = "Password2015"
)

@ApplicationScoped  // This is an application-scoped CDI managed bean
public class ApplicationConfig {
}
