import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@Slf4j
@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
public class MServlet implements Servlet {

    private transient ServletConfig config;

    // Метод вызывается контейнером после того как был создан класс сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        // Сохраняем полученную от сервера конфигурацию
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    // Метод вызывается для каждого нового HTTP запроса к данному сервлету
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("New request");

        // получаем объект типа BufferedWriter и пишем в него ответ на пришедший запрос
        res.getWriter().println("<h1>Servlet content</h1>");
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    // При завершении работы веб приложения, контейнер вызывает этот метод для всех сервлетов из этого приложения
    @Override
    public void destroy() {
        log.info("Servlet {} destroyed", getServletInfo());
    }
}

