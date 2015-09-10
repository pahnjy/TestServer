package com.pineone.server.controller;

import com.pineone.server.dao.UserDAO;
import com.pineone.server.model.User;
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
    private UserDAO userDAO;

    // �Խ��� ���
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dispBbsList(Model model) {
        if(userDAO != null){
            List<User> list = this.userDAO.getUsers();
            if(list != null && list.size() != 0){
                model.addAttribute("list", list);
            }
        }
        return "bbs.list";
    }

    // �Խ��� �󼼺�
    // PathVariable ������̼��� �̿��Ͽ� RESTful ��� ����
    // bbs/1 -> id = 1; id = �Խù� ��ȣ�� �ν���.
    // �Ϲ� ������ (@ReuqstParam(value = "bbsVo", required = false, defaultValue = "0"), int id, Model model)
    @RequestMapping("/{id}")
    public String dispBbsView(@PathVariable String id, Model model) {
        User object = this.userDAO.getUser(id);
        model.addAttribute("object", object);
        return "bbs.view";
    }

    // �Խ��� ����
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String dispBbsWrite(@RequestParam(value="id", defaultValue="0") String id, Model model) {

        if (Integer.parseInt(id) > 0) {
            User object = this.userDAO.getUser(id);
            model.addAttribute("object", object);
        }

        return "bbs.write";
    }

    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String procBbsWrite(@ModelAttribute("bbsVo") User user, RedirectAttributes redirectAttributes) {
        String id = user.getId();

        if (id == null || id.equals("")) {
            this.userDAO.addUser(user);
            redirectAttributes.addFlashAttribute("message", "�߰��Ǿ����ϴ�.");
            return "redirect:/";
        } else {
            userDAO.updateUser(user);
            redirectAttributes.addFlashAttribute("message", "�����Ǿ����ϴ�.");
            return "redirect:/write?id=" + id;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String procBbsDelete(@RequestParam(value = "id", required = false) String id) {
        this.userDAO.deleteUser(id);
        return "redirect:/";
    }

}