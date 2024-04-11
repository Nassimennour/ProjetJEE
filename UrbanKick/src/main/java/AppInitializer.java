import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        App.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // You can close the SessionFactory here if needed
    }
}