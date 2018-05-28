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

public class MainInterceptor implements HandlerInterceptor {

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

    /*
     * 拦截手机微信端课程首页
     * 微信端首页自动登录，实现个性化推荐
     * 当用户注册，推荐用户区域课程；当用户未注册推荐，推荐全国精华课程；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        HttpSession session = request.getSession();
        Student user = (Student) session.getAttribute("user");
        System.out.println(request.getRequestURI());

        if (user != null) {
            //1.从session判断用户是否已经登录；如果登录放行
            System.out.println("1.从session判断用户是否已经登录；如果登录放行");
            return true;
        } else {
            //2.session未登录，判断当前域中是否存在code
            System.out.println("2.session未登录，判断当前域中是否存在code");
            String code = request.getParameter("code");
            System.out.println("code=" + code);
            if (code != null && code.length() > 0) {
                //2.1存在code，通过code换openid
                System.out.println("存在code，通过code换openid");
                Map<String, String> map = CodeUtils.GetOpenidAndAccessTokenFromCode(code);

                if (map.size() > 0) {
                    System.out.println("2.1.1换取openid没有异常,map不为null");
                    //2.1.1换取opemid没有异常

                    String openid = map.get("openid");
                    if (openid != null) {
                        //2.1.1.1正确获得openid
                        System.out.println("2.1.1.1正确获得openid");

                        Student student = studentService.get(openid);
                        if (student != null) {
                            //2.1.1.1.1用户注册过，推荐所属区域课程

                            System.out.println("2.1.1.1.1用户注册过，推荐所属区域课程，自动登录");
                            session.setAttribute("user", student);
                            return true;
                        } else {
                            //2.1.1.1.2用户没有注册过，推荐全国课程
                            System.out.println("2.1.1.1.2用户没有注册过，推荐全国课程");
                            return true;
                        }
                    } else {
                        //2.1.1.2没有获得openid，重新获得code
                        System.out.println("2.1.1.2没有获得openid，重新获得code");
                        String url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID
                                + "&redirect_uri=" + request.getRequestURL()
                                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                        // request.getRequestDispatcher(url).forward(request,
                        // response);
                        System.out.println(url);
                        response.sendRedirect(url);

                        return false;
                    }
                } else {
                    //2.1.2获取openid异常，重新获取code
                    System.out.println("2.1.2获取openid异常，map为null,重新获取code");

                    String url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                            + request.getRequestURL()
                            + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                    // request.getRequestDispatcher(url).forward(request,
                    // response);
                    System.out.println(url);
                    response.sendRedirect(url);

                    return false;
                }

            } else {
                //2.2不存在code，通过跳转获得code
                System.out.println("2.2不存在code，通过跳转获得code");
                String url = MyWxPayConfig.OAUTH_AUTHORIZE_URL + "appid=" + MyWxPayConfig.APPID + "&redirect_uri="
                        + request.getRequestURL() + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
                // request.getRequestDispatcher(url).forward(request, response);
                System.out.println(url);
                response.sendRedirect(url);

                return false;

            }

        }

    }

}