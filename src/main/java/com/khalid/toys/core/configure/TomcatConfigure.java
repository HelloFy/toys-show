package com.khalid.toys.core.configure;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 费玥 on 2017/1/17.
 */
@Configuration
public class TomcatConfigure {

    AprLifecycleListener arpLifecycle = null;

    @Value("${environment}")
    private String environment;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        if (environment.equalsIgnoreCase("production")) {
            tomcat.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
            arpLifecycle = new AprLifecycleListener();//不初始化会报错
            tomcat.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
        }
        return tomcat;
    }

    class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer
    {
        public void customize(Connector connector)
        {
            Http11AprProtocol protocol = (Http11AprProtocol) connector.getProtocolHandler();
            //设置最大连接数
            protocol.setMaxConnections(20*1024);
        }
    }
}
