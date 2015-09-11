package com.pineone.server.controller;

import com.pineone.server.dao.UserDAO;
import com.pineone.server.model.User;
import com.pineone.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller(value = "viewController")
public class ViewController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dispBbsList(Model model) {
        if(userService != null){
            List<User> list = this.userService.getUsers();
            if(list != null && list.size() != 0){
                model.addAttribute("list", list);
            }
        }
        return "bbs.list";
    }

    @RequestMapping("/{id}")
    public String dispBbsView(@PathVariable String id, Model model) {
        User object = this.userService.getUser(id);
        model.addAttribute("object", object);
        return "bbs.view";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String dispBbsWrite(@RequestParam(value="id", defaultValue="0") String id, Model model) {

        if (Integer.parseInt(id) > 0) {
            User object = this.userService.getUser(id);
            model.addAttribute("object", object);
        }

        return "bbs.write";
    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String procBbsWrite(@ModelAttribute("User") User user, RedirectAttributes redirectAttributes) {
        String id = user.getId();

        if (id == null || id.equals("")) {
            this.userService.addUser(user);
            redirectAttributes.addFlashAttribute("message", "add User.");
        } else {
            userService.updateUser(user);
            redirectAttributes.addFlashAttribute("message", "update User.");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String procBbsDelete(@RequestParam(value = "id", required = false) String id) {
        this.userService.deleteUser(id);
        return "redirect:/";
    }

}