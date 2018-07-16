package cn.itcast.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/*
 * 实现自定义日期格式转换，格式为：yyyy-MM-dd
 * 
 * 	
 * 为何在springmvc-servlet.xml中配置不起作用，直接controller中声明起作用
	<!-- 拦截器 -->
	<bean id="annotationMethodHandlerAdapter" class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
		<!-- 日期格式转换 -->
        <property name="webBindingInitializer">
         <bean class="cn.itcast.jk.util.DateConverter"/>
        </property>
	</bean>
	
	
 */
public class DateConverter implements WebBindingInitializer {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
    private static final String shortDateFormat2 = "yyyy/MM/dd";

    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(df, true));
    }

    /**
     * 字符串转换为日期
     */
    public static java.util.Date StringToDate(String timeStr) {

        if (timeStr.isEmpty()) {
            return null;
        }
        timeStr = timeStr.trim();
        try {
            SimpleDateFormat formatter;
            if (timeStr.contains("-")) {
                if (timeStr.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                java.util.Date dtDate = formatter.parse(timeStr);
                return dtDate;
            } else if (timeStr.contains("/")) {
                if (timeStr.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat2);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat2);
                }
                java.util.Date dtDate = formatter.parse(timeStr);
                return dtDate;
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", timeStr));
        }

        throw new RuntimeException(String.format("parser %s to Date fail", timeStr));

    }


    /**
     * String 转timestamp
     */
    public static Timestamp stringToTimestamp(String timeStr){
        return Timestamp.valueOf(timeStr);
    }
}
