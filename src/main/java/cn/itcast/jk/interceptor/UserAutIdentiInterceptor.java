package cn.itcast.jk.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.jk.domain.Student;
import cn.itcast.jk.service.StudentService;
import cn.itcast.qg.wxpay.CodeUtils;
import cn.itcast.qg.wxpay.MyWxPayConfig;

public class UserAutIdentiInterceptor implements HandlerInterceptor {

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

        HttpSession session = request.getSession();
        Student user = (Student) session.getAttribute("user");
        // 拦截黑名单用户，如果用户状态是4，拦截重定向到error页面
        if (user != null && 4 == user.getState()) {
            response.sendRedirect("/error.html");
            return false;
        }
        System.out.println(request.getRequestURI());
        if (user != null) {
            //用户已经登录，当用户浏览器输入注册页面，自动跳转到个人中心
            if (request.getRequestURL().indexOf("/phone/user/basicinfo/student/tocreate.action") >= 0) {
                request.getRequestDispatcher("/phone/user/main.action").forward(request, response);
                return false;
            }
            //用户已经登录，当用户浏览器输入成为导师，判断当前状态是否已经申请，或者申请通过跳转相关网页
            if (request.getRequestURL().indexOf("/phone/user/basicinfo/teacher/tocreateteacher.action") >= 0) {
                if (user.getState() == 1) {
                    request.getRequestDispatcher("/phone/user/becomedaoshi.action").forward(request, response);
                    return false;
                } else if (user.getState() == 0) {
                    request.getRequestDispatcher("/WEB-INF/pages/basicinfo/teacher/shenqingsucess.jsp").forward(request,
                            response);
                    return false;

                } else {
                    request.getRequestDispatcher("/WEB-INF/pages/basicinfo/teacher/teacherpass.jsp").forward(request,
                            response);
                    return false;

                }
            }
            System.out.println("已经登录");
            return true;
        } else {
            //用户没有登录
            System.out.println("用户没有登录");
            String code = request.getParameter("code");
            System.out.println("code=" + code);
            if (code != null && code.length() > 0) {
                System.out.println("获得code");
                //当前code存在
                Map<String, String> map = CodeUtils.GetOpenidAndAccessTokenFromCode(code);
                if (map.size() > 0) {
                    System.out.println("code换openid正常");
                    // 获取openid正常，如果不加判断map为null报空指针异常
                    String openid = map.get("openid");
                    if (openid != null) {
                        //获取openid正确
                        System.out.println("获得openid正确");
                        Student student = studentService.get(openid);
                        if (student != null) {
                            //当前用户已经注册
                            System.out.println("用户已经注册");
                            if (student.getState() == 4) {
                                response.sendRedirect("/error.html");
                                return false;
                            }
                            System.out.println("自动登录");
                            session.setAttribute("user", student);
                            //用户已经登录，当用户浏览器输入注册页面，自动跳转到个人中心
                            if (request.getRequestURL().indexOf("/phone/user/basicinfo/student/tocreate.action") >= 0) {
                                request.getRequestDispatcher("/phone/user/main.action").forward(request, response);
                                return false;
                            }
                            //用户已经登录，当用户浏览器输入成为导师，判断当前状态是否已经申请，或者申请通过跳转相关网页
                            if (request.getRequestURL()
                                    .indexOf("/phone/user/basicinfo/teacher/tocreateteacher.action") >= 0) {
                                if (student.getState() == 1) {
                                    request.getRequestDispatcher("/phone/user/becomedaoshi.action").forward(request,
                                            response);
                                    return false;
                                } else if (student.getState() == 0) {
                                    request.getRequestDispatcher("/WEB-INF/pages/basicinfo/teacher/shenqingsucess.jsp")
                                            .forward(request, response);
                                    return false;

                                } else {
                                    request.getRequestDispatcher("/WEB-INF/pages/basicinfo/teacher/teacherpass.jsp")
                                            .forward(request, response);
                                    return false;

                                }
                            }
                            return true;
                        } else {
                            System.out.println("当前用户没有注册");
                            //用户浏览器注册导师或学生把openid传过去
                            if (request.getRequestURL().indexOf("/phone/user/basicinfo/student/tocreate.action") >= 0
                                    || request.getRequestURL()
                                    .indexOf("/phone/user/basicinfo/teacher/tocreateteacher.action") >= 0) {
                                request.setAttribute("userOpenid", openid);
                                return true;
                            }
                            System.out.println("去注册");

                            if (request.getParameter("id") != null) {
                                request.setAttribute("id", request.getParameter("id"));
                            }
                            request.getRequestDispatcher("/Userregister.jsp").forward(request, response);
                            return false;
                        }
                    } else {
                        //获取openid失败，先获取code
                        System.out.println("获取openid失败，先获取code");
                        String id = request.getParameter("id");
                        String url = "";
                        if (id != null) {
                            url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                                    + request.getRequestURL() + "?id=" + id
                                    + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                        } else {

                            url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                                    + request.getRequestURL()
                                    + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                        }
                        // request.getRequestDispatcher(url).forward(request,
                        // response);
                        System.out.println(url);
                        response.sendRedirect(url);

                        return false;
                    }
                } else {
                    //map为null，先获取code
                    System.out.println("code 换openid，map为null，获取code");

                    String id = request.getParameter("id");
                    String url = "";
                    if (id != null) {
                        url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                                + request.getRequestURL() + "?id=" + id
                                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                    } else {

                        url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                                + request.getRequestURL()
                                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                    }
                    // request.getRequestDispatcher(url).forward(request,
                    // response);
                    System.out.println(url);
                    response.sendRedirect(url);

                    return false;
                }

            } else {
                System.out.println("code为null，获取code");
                String id = request.getParameter("id");
                String url = "";
                if (id != null) {
                    url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                            + request.getRequestURL() + "?id=" + id
                            + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                } else {

                    url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                            + request.getRequestURL()
                            + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                }
                // request.getRequestDispatcher(url).forward(request, response);
                System.out.println(url);
                response.sendRedirect(url);
                //	System.out.println(url);
                return false;

            }

        }

    }

}