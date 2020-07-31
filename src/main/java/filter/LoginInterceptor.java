package filter;

import control.controller.UserController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mysql.cj.conf.PropertyKey.logger;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        logger.info("请求URI为"+requestURI);
        Object userId = request.getSession().getAttribute("userId");
        if(requestURI.contains("Employee")&&userId!=null&&userId!=""){
            return true;
        }else{
            response.sendRedirect("/user/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
