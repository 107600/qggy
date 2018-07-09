package cn.itcast.jk.controller.basicinfo.craftsmandomain;

import cn.itcast.jk.domain.CraftsmanDomain;
import cn.itcast.jk.service.CraftsmanDomainSerivice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CraftsmanDomainController {
    @Resource//注入Service
    CraftsmanDomainSerivice craftsmanDomainService;

    @RequestMapping("/basicinfo/craftsmandomain/selectcraftsmandomain.action")
    @ResponseBody
    public List<CraftsmanDomain> selectCraftsmanDomain() {
        List<CraftsmanDomain> craftsmanDomains = craftsmanDomainService.selectCraftsmanDomain();
        return craftsmanDomains;
    }

}
