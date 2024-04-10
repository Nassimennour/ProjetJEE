import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DatabaseServlet extends HttpServlet {
    private DatabaseConnector databaseConnector;
    private DatabaseQuery databaseQuery;

    public void init() {
        databaseConnector = new DatabaseConnector();
        databaseQuery = new DatabaseQuery(databaseConnector);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        databaseQuery.executeQuery();
    }
}