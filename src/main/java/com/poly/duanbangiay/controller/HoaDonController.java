package com.poly.duanbangiay.controller;

import com.poly.duanbangiay.entity.HoaDon;
import com.poly.duanbangiay.service.serviceimpl.HoaDonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hoa_don")
public class HoaDonController {
    @Autowired
    HoaDonImpl hoaDonImpl;

    @GetMapping("hien-thi")
    public  String hienThi(Model model){

        model.addAttribute("listHoaDon",hoaDonImpl.getAll());
        System.out.println("đến đây r");
        model.addAttribute("view", "/hoa_don/index.jsp");
        return "admin/index";
    }
}
