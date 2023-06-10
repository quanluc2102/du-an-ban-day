package com.poly.duanbangiay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewControler {

    @GetMapping("/tong_quan")
    public String tongQuan(Model model){

        model.addAttribute("view","/tong_quan/admin.jsp");
        return "admin/index";
    } @GetMapping("/san_pham")
    public String danhSachSanPham(Model model){

        model.addAttribute("view","/san_pham/danh_sach.jsp");
        return "admin/index";
    }
}
