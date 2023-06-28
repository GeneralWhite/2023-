package com.cqupt.Controller;

import com.cqupt.Entity.User;
import com.cqupt.Service.Impl.UserServiceImpl;
import com.cqupt.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/LoginCheck")
public class LoginServlet extends HttpServlet
{
    private static final long serialLVersionUID = 1L;
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

//        UserHandler userHandler = new UserHandler();
//        // userHandler用来检查user是否是一个合法登录用户
//        boolean result = userHandler.loginCheck(user);
//        userHandler.close();
        userService = new UserServiceImpl();
        boolean result = userService.loginCheck(user);

        if(result)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            // response.sendRedirect("ok.jsp"); // 客户端跳转，相当于发起新的请求。URL改变
            // 服务器跳转: 未发起请求，只是移交控制权。URL不变
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/ok.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            // response.sendRedirect("error.html");  // 客户端跳转：相当于发起新的请求，URL不变
            // 服务器端跳转：未发起请求，只是移交控制权。URL不变
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/error.html");
            dispatcher.forward(request, response);
        }
    }
}
