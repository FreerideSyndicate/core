package freeride.co;

/**
 * Created by Greg on 12/20/16.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
}
