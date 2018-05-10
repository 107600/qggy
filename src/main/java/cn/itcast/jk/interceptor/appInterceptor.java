package cn.itcast.jk.interceptor;

import cn.itcast.jk.domain.Student;
import cn.itcast.jk.domain.SysUser;
import cn.itcast.jk.service.StudentService;
import cn.itcast.jk.service.SysUserService;
import cn.itcast.jk.vo.SysUserVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jy on 2018/5/10.
 */
public class appInterceptor implements HandlerInterceptor {
    @Resource
    StudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userPhone = request.getParameter("userPhone");
        String password = request.getParameter("password");
        HashMap<String, String> paramap = new HashMap<>();
        paramap.put("userPhone", userPhone);
        //TODO
//        paramap.put("password",password);
        List<Student> studentList = studentService.find(paramap);
        HttpSession session = request.getSession();
        if (studentList != null && studentList.size() > 0) {
            session.setAttribute("user", studentList.get(0));
          return true;
        } else {
            response.sendRedirect("/error.html");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
