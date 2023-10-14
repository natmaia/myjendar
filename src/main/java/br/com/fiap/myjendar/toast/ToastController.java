package br.com.fiap.myjendar.toast;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/toast")
public class ToastController{


    @GetMapping
    public String index(){
        return "toast/index";
    }

}