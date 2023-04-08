package com.shoom.ordersystem.controller;

import com.shoom.ordersystem.config.Consts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * @date 2023/4/7 16:26
 */
@RestController
public class SystemController {


    @PostMapping("/login")
    public ResponseEntity login(){
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return null;
    }

    @GetMapping("getAllProducts")
    public  ResponseEntity getAllProducts(){
        return ResponseEntity.ok(Consts.products);
    }


}
