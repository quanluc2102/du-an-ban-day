package com.poly.duanbangiay.controller;

import com.poly.duanbangiay.entity.KhuyenMai;
import com.poly.duanbangiay.entity.SanPhamDanhMuc;
import com.poly.duanbangiay.service.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("san_pham_danh_muc")
public class SanPhamDanhMucController {
    @Autowired
    SanPhamDanhMucServiceimpl sanPhamDanhMucServiceimpl;
    @Autowired
    SanPhamServiceimpl sanPhamServiceimpl;
    @Autowired
    DanhMucServiceimpl danhMucServiceimpl;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listSPDM",sanPhamDanhMucServiceimpl.getAll());
        model.addAttribute("view", "/san_pham_danh_muc/index.jsp");
        return "admin/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("SanPhamDanhMuc",new SanPhamDanhMuc());
        model.addAttribute("listSP",sanPhamServiceimpl.getAll());
        model.addAttribute("listDM",danhMucServiceimpl.getAll());
        model.addAttribute("view", "/san_pham_danh_muc/addNew.jsp");
        return "admin/index";
    }

    @PostMapping("add")
    public String add(Model model,
                      @ModelAttribute("SanPhamDanhMuc") SanPhamDanhMuc sanPhamDanhMuc){
        sanPhamDanhMucServiceimpl.add(sanPhamDanhMuc);
        return "redirect:/san_pham_danh_muc/index";
    }
}
