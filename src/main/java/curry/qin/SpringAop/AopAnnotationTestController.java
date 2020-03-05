package curry.qin.SpringAop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin
 * @date 2020/3/5 9:19
 * @Copyright © 2019-2020 yamibuy
 */
@RestController
public class AopAnnotationTestController {

    @RequestMapping("/aop")
    @TestAnnotation(name = "aop",isLog = true)
    public String testAop(){
        return "aop";
    }
}
