package Util;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        App.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // You can close the SessionFactory here if needed

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println(String.format("Deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                System.out.println(String.format("Error deregistering driver %s", driver));
                e.printStackTrace();
            }
        }

        // Manually stop the cleanup thread
        try {
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            System.out.println("Error stopping MySQL cleanup thread");
            e.printStackTrace();
        }
    }
}