package co.freeride.core.controllers;

/**
 * Created by Greg on 12/20/16.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "pong";
    }
}
