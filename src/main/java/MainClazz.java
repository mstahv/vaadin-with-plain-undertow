
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ListenerInfo;
import io.undertow.servlet.api.ServletInfo;
import javax.servlet.ServletException;

/**
 *
 * @author Matti Tahvonen
 */
public class MainClazz {

    public static void main(String... args) throws ServletException {

        DeploymentManager dm = Servlets.defaultContainer().
                addDeployment(
                        Servlets.deployment()
                                .setClassLoader(Thread.currentThread().getContextClassLoader())
                                .setContextPath("/")
                                .setDeploymentName("vaadin")
                                .addServlets(new ServletInfo("vaadin", MyServlet.class)
                                        .addMapping("/*")
                                .addInitParam("Resources", "http://virit.in/dawn/11"))
                                .addListeners(new ListenerInfo(in.virit.WidgetSet.class))
                                )
                ;
        dm.deploy();

        Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(dm.start())
                .build().start();

    }

    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyServlet extends VaadinServlet {

    }

    @Theme("valo")
    public static class MyUI extends UI {

        @Override
        protected void init(VaadinRequest request) {
            setContent(new Label("HelloWorld!"));
        }

    }

}
