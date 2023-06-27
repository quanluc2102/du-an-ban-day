package com.poly.duanbangiay.controller;

import com.poly.duanbangiay.entity.KhuyenMai;
import com.poly.duanbangiay.service.KhuyenMaiService;
import com.poly.duanbangiay.service.serviceimpl.KhuyenMaiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiServiceImpl khuyenMaiServiceImpl;


    @GetMapping("/index")
    public String hienThi(Model model){
        ArrayList<KhuyenMai>list = khuyenMaiServiceImpl.getAll();
        model.addAttribute("listKM",list);
        model.addAttribute("view", "/khuyen_mai/index.jsp");
        return "admin/index";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("KhuyenMai",new KhuyenMai());
        model.addAttribute("view","/khuyen_mai/add.jsp");
        return "admin/index";
    }
    @PostMapping("add")
    public String add(Model model,
                      @RequestParam("ten")String ten,
                      @RequestParam("moTa")String moTa,
                      @RequestParam("batDau")Date batDau,
                      @RequestParam("ketThuc")Date ketThuc,
                      @RequestParam("giamGia")Float giamGia,
                      @RequestParam("kieuKhuyenMai")int kieuKhuyenMai){

    khuyenMaiServiceImpl.add(new KhuyenMai(ten,moTa,batDau,ketThuc,giamGia,kieuKhuyenMai));
    return "redirect:/khuyen-mai/index";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(Model model,
                         @PathVariable("id")Long id){
        khuyenMaiServiceImpl.delete(id);
        return "redirect:/khuyen-mai/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id")Long id){
        Optional<KhuyenMai>km = khuyenMaiServiceImpl.detail(id);
        model.addAttribute("km",km.get());
        model.addAttribute("view","/khuyen_mai/update.jsp");
        return "admin/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id")Long id,
                         @RequestParam("ten")String ten,
                         @RequestParam("moTa")String moTa,
                         @RequestParam("batDau")Date batDau,
                         @RequestParam("ketThuc")Date ketThuc,
                         @RequestParam("giamGia")Float giamGia,
                         @RequestParam("kieuKhuyenMai")int kieuKhuyenMai){
      KhuyenMai km = new KhuyenMai();
      km.setId(id);
      km.setTen(ten);
      km.setMoTa(moTa);
      km.setBatDau(batDau);
      km.setKetThuc(ketThuc);
      km.setGiamGia(giamGia);
      km.setKieuKhuyenMai(kieuKhuyenMai);
      khuyenMaiServiceImpl.add(km);
        return "redirect:/khuyen-mai/index";
    }
}
