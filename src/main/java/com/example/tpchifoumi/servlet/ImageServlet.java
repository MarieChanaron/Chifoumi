package com.example.tpchifoumi.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "ImageServlet", urlPatterns = "/images")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/png");
        ServletOutputStream out;
        out = response.getOutputStream();
        String realPath = getServletContext().getRealPath("/WEB-INF/images/" + request.getParameter("file"));
        FileInputStream fin = new FileInputStream(realPath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch =0; ;
        while((ch=bin.read())!=-1) {
            bout.write(ch);
        }

        bin.close();
        fin.close();
        bout.close();
        out.close();
    }
}
