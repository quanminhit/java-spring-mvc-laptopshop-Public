package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getMethodName() {
        return "Hello World Quan mn";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Hello World User";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Hello World Admin";
    }
}
