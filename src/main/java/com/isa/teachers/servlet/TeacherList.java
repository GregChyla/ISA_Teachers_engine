package com.isa.teachers.servlet;

import com.isa.teachers.config.TemplateProvider;
import com.isa.teachers.service.TeacherService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/")
public class TeacherList extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private TeacherService teacherService;

    @EJB
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "TeacherList.ftlh");
        Map<String, Object> model = new HashMap<>();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("Content-Type = text/html");

        model.put("allTeachers", teacherService.findAllTeachers());

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error("Template error: {}", e.getMessage());
        }
    }
}
