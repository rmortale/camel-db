package org.example;

import org.apache.camel.BindToRegistry;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    @PropertyInject("omsdoc.datasource.url")
    String url;
    @PropertyInject("omsdoc.datasource.user")
    String user;
    @PropertyInject("omsdoc.datasource.password")
    String password;
    @PropertyInject("omsdoc.datasource.driverclass")
    String driver;

    @Override
    public void configure() throws Exception {

        from("timer:tick")
                .log("Hello Camel K ninoooo!")
                .to("sql:select session_user()")
                .log("${body}");

    }

    @BindToRegistry
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }

}
