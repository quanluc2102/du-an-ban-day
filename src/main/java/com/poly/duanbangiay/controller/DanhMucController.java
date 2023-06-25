package com.poly.duanbangiay.controller;

import com.poly.duanbangiay.entity.DanhMuc;
import com.poly.duanbangiay.service.serviceimpl.DanhMucServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("danh_muc")
public class DanhMucController {
    @Autowired
    DanhMucServiceimpl serviceimpl;
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listDM",serviceimpl.getAll());
        model.addAttribute("view", "/danh_muc/index.jsp");
        return "admin/index";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("DanhMuc",new DanhMuc());
        model.addAttribute("view", "/danh_muc/addNew.jsp");
        return "admin/index";
    }
    @PostMapping("add")
    public String add(Model model,
                      @ModelAttribute("DanhMuc") DanhMuc danhMuc){
        serviceimpl.add(danhMuc);
        return "redirect:/danh_muc/index";
    }
    @GetMapping("delete")
    public String delete(Model model,
                         @RequestParam("id")Long id){
        serviceimpl.delete(id);
        return "redirect:/danh_muc/index";
    }
    @GetMapping("detail")
    public String detail(Model model,
                         @RequestParam("id")Long id){
        model.addAttribute("dm",serviceimpl.getOne(id));
        model.addAttribute("DanhMuc",serviceimpl.getOne(id));
        model.addAttribute("view", "/danh_muc/detail1.jsp");
        return "admin/index";
    }
    @PostMapping("update/{id}")
    public String update(Model model,
                         @PathVariable("id")Long id,
                         @ModelAttribute("DanhMuc") DanhMuc danhMuc){
        serviceimpl.update(id,danhMuc);
        return "redirect:/danh_muc/index";
    }
}
