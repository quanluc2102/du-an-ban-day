package com.poly.duanbangiay.controller;


import com.poly.duanbangiay.entity.TaiKhoan;
import com.poly.duanbangiay.service.serviceimpl.TaiKhoanServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/tai-khoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanServiceimpl taiKhoanServiceimpl;
    @GetMapping("/index")
    public String hienThi(Model model){
        ArrayList<TaiKhoan> list = taiKhoanServiceimpl.getAll();
        model.addAttribute("listTK",list);
        System.out.println(list.toString());
        model.addAttribute("view", "/tai_khoan/index.jsp");
        return "admin/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("view", "/tai_khoan/viewAdd.jsp");
        return "admin/index";
    }
    @GetMapping("/danhsach")
    public String hienThi1(Model model){
        ArrayList<TaiKhoan> list = taiKhoanServiceimpl.getAll();
        model.addAttribute("listTK",list);
        model.addAttribute("view", "/tai_khoan/danh_sach.jsp");
        return "admin/index";
    }
    @PostMapping("add")
    public String add(Model model,
                      @RequestParam("username") String username,
                      @RequestParam("email") String email,
                      @RequestParam("ten") String ten,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("ngayTao")Date ngayTao,
                      @RequestParam("ngayCapNhat") Date ngayCapNhat,
                      @RequestParam("password") String password,
                      @RequestParam("anh") String anh,
                      @RequestParam("sdt") String sdt,
                      @RequestParam("trangThai") Boolean trangThai
                      ){
        taiKhoanServiceimpl.add(new TaiKhoan(username,email,ten,diaChi,ngayTao,ngayCapNhat,password,anh,sdt,trangThai));
        return "redirect:/tai-khoan/index";
    }
    @GetMapping("/delete/{id}")
    public String delete (Model model,
                          @PathVariable("id") String id){
        taiKhoanServiceimpl.delete(Long.valueOf(id));
        return "redirect:/tai-khoan/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id
                         ){
        Optional<TaiKhoan> khoan = taiKhoanServiceimpl.detail(Long.valueOf(id));
        model.addAttribute("tk",khoan.get());
        model.addAttribute("view", "/tai_khoan/update.jsp");
        return "admin/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") String id,
                         @ModelAttribute("TaiKhoan") TaiKhoan taiKhoan){
        taiKhoanServiceimpl.update(Long.valueOf(id),taiKhoan);
        return "redirect:/tai-khoan/index";
    }
}
