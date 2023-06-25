package com.poly.duanbangiay.controller;

import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.service.serviceimpl.SanPhamServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("san_pham")
public class SanPhamController {
    @Autowired
    SanPhamServiceimpl sanPhamServiceimpl;
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listSP",sanPhamServiceimpl.getAll());
        model.addAttribute("view", "/san_pham/index.jsp");
        return "admin/index";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("SanPham",new SanPham());
        model.addAttribute("view", "/san_pham/addNew.jsp");
        return "admin/index";
    }
    @PostMapping("add")
    public String add(Model model,
                      @ModelAttribute("SanPham") SanPham sp){
        sanPhamServiceimpl.add(sp);
        sanPhamServiceimpl.chuyenTrangThai(sp);
        return "redirect:/sanpham/index";
    }
    @GetMapping("delete")
    public String delete(Model model,
                         @RequestParam("id") Long id){
        sanPhamServiceimpl.delete(id);
        return "redirect:/sanpham/index";
    }
    @GetMapping("detail")
    public String detail(Model model,
                         @RequestParam("id") Long id){
        model.addAttribute("SanPham",sanPhamServiceimpl.getOne(id));
        model.addAttribute("sp",sanPhamServiceimpl.getOne(id));
        model.addAttribute("view", "/san_pham/detail1.jsp");
        return "admin/index";
    }
    @PostMapping("update/{id}")
    public String detail(Model model,
                         @PathVariable("id") Long id,
                         @ModelAttribute("SanPham") SanPham sp){
        sanPhamServiceimpl.update(id,sp);
        sanPhamServiceimpl.chuyenTrangThai(sanPhamServiceimpl.getOne(id));
        return "redirect:/sanpham/index";
    }
}
