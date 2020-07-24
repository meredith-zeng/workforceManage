package control.filter;


import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {
//    public static final String login_page = "/workforceManage_war_exploded/index.jsp";
//    public static final String logout_page = "/workforceManage_war_exploded/views/login/logout.jsp";
//

    public void  doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        //System.out.println("doFilter执行了");

        //            req.getSession().setAttribute("userId",userId);
        if(session.getAttribute("userId")!=null){
            filterChain.doFilter(request, response);

        }else{
            response.sendRedirect("/workforceManage_war_exploded/index.jsp");//未登录，重定向到登录页面
        }



    }


    public void init(FilterConfig filterConfig)throws ServletException{

    }

    public void destroy(){

    }
}