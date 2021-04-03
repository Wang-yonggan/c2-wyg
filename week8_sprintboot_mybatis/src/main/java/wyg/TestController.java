package wyg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller+rest
//@RequestMapping("/wyg")
public class TestController {
    @GetMapping({"/me"})//http://localhost:8080/wyg/me
    public String firstController() {
        return "第一个";
    }

    @GetMapping({"/req"})//http://localhost:8080/wyg/req?n=2
    public String requestparam(@RequestParam Integer n) {
        return "param:" + n;
    }

    @GetMapping({"/para/{n}"})//不用问号传参  http://localhost:8080/wyg/para/3
    public String pathparam(@PathVariable Integer n) {
        return "paran from path:" + n;
    }

    //一个函数的多地址
    @GetMapping({"/w1", "/w2"})
    public String Ws(@PathVariable Integer n) {
        return "param:" + n;
    }

    //默认参数
    @GetMapping({"/default"})//http://localhost:8080/default
    public String Default(@RequestParam(required = false, defaultValue = "404") Integer n) {
        return "param:" + n;
    }

}
