package bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weblogic.jaxrs.internal.common.GeneralUtil;
/**
 * Demonstrates issues with using class.forname
 */
public class PropertyLoaderServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            Class clasz = Class.forName("weblogic.jaxrs.internal.common.GeneralUtil");
            GeneralUtil generalUtil = (GeneralUtil) clasz.getDeclaredConstructor().newInstance();
            generalUtil.loadProperties("application.properties");
            out.println("<h4>Class Dynamically loaded</h4>");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
