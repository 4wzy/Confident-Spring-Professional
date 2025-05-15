package com.justingrosu.mybank;

import com.justingrosu.mybank.web.MyBankServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {
        final String portProp = System.getProperty("PORT");
        final int port = portProp != null ? Integer.parseInt(portProp) : 8080;

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myBankServlet", new MyBankServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

}
