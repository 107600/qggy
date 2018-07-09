package cn.itcast.jk.controller.basicinfo.teacherdomain;

import cn.itcast.jk.domain.TeacherDomain;
import cn.itcast.jk.service.TeacherDomainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TeacherDomainController {
    @Resource//注入Service
    TeacherDomainService teacherDomainService;

    @RequestMapping("/basicinfo/teacherdomain/selectteacherdomain.action")
    @ResponseBody
    public List<TeacherDomain> selectTeacherDomain() {
        List<TeacherDomain> teacherDomains = teacherDomainService.selectTeacherDomain();
        return teacherDomains;
    }

}
