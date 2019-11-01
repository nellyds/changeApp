package com.nerdery.coinApp.Controller;

import com.nerdery.coinApp.Service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    CoinService coinService;

    @GetMapping("/app")
    public String showup() {
        return "index";
    }
}
