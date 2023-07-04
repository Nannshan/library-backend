package com.example.library.Controller.TokenController;

import com.example.library.utils.JwtUtils;
import com.example.library.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TokenController {
    @GetMapping("/checkToken")
    public Result checkToken(String token) {
        boolean flag = JwtUtils.checkToken(token);
        if (flag) {
            return Result.ok();
        }
        return Result.tokenError().data("info", "token已失效");
    }
}
