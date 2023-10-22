package br.com.fiap.myjendar.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService service;

    // @GetMapping
    // public String index(Model model, @AuthenticationPrincipal OAuth2User user) {
    // model.addAttribute("picture", user.getAttribute("picture"));

    // System.out.println(user);
    // model.addAttribute("tasks", service.findAll());
    // return "task/index";
    // }

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user) {
        String avatar;
        if (user.getAttributes().containsKey("picture")) {
            avatar = user.getAttribute("picture");
        } else if (user.getAttributes().containsKey("avatar_url")) {
            avatar = user.getAttribute("avatar_url");
        } else {
            avatar = "https://github.com/natmaia/arquivosFotosReadme/blob/main/FOTOS-PERFIL-ARREDONDADO.png";
        }

        model.addAttribute("avatar", avatar);
        System.out.println(user);
        model.addAttribute("tasks", service.findAll());
        return "task/index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/task";
    }

    @GetMapping("new")
    public String form(Task task) {
        return "task/form";
    }

    // outra forma de corrigir o erro de Templante Objeto não localizado
    // @GetMapping("new")
    // public String form( Model model) {
    // model.addAttribute("task", new Task());
    // return "task/form";
    // }

    @PostMapping
    public String save(@Valid Task task, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors())
            return "/task/form";

            System.out.println(task);
        service.save(task);
        // redirect.addFlashAttribute("sucess", "Tarefa cadastrada!");
        return "redirect:/task";
    }

}
