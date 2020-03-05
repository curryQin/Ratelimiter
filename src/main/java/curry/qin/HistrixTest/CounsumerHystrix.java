package curry.qin.HistrixTest;

import org.springframework.stereotype.Component;

//定义一个熔断器，当发生熔断默认返回值
@Component
public class CounsumerHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "调用hello熔断";
    }
}
