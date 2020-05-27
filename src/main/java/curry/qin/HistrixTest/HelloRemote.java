package curry.qin.HistrixTest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import curry.qin.HistrixTest.CounsumerHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//调用远程的服务名称
@FeignClient(name = "eurekaProvider",fallback = CounsumerHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
