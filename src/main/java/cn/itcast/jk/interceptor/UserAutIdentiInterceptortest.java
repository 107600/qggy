package cn.itcast.jk.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.jk.domain.Student;
import cn.itcast.jk.service.StudentService;

public class UserAutIdentiInterceptortest implements HandlerInterceptor {

    @Resource
    StudentService studentService;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {


    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {


        Student student = studentService.get("ovrWG1VMq4dJkswjCYfJ4qHBix4B");
        System.out.println(student);
        if (student != null) {
            System.out.println("自动登录");
            request.getSession().setAttribute("user", student);
            return true;

        }else {
            System.out.println("转向其他页面");
            request.setAttribute("userOpenid","ovrWG1VMq4dJkswjCYfJ4qHBix4B");
            request.getRequestDispatcher("/Userregister.jsp").forward(request,response);
//            response.sendRedirect("/Userregister.jsp");
            return false;
        }

//        return true;
    }

}
