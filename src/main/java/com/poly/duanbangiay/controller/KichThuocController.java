package com.poly.duanbangiay.controller;


import com.poly.duanbangiay.entity.KichThuoc;
import com.poly.duanbangiay.service.serviceimpl.KichThuocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {

    @Autowired
    KichThuocServiceImpl kichThuocService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listKichThuoc", kichThuocService.findAll());
        model.addAttribute("view", "/kich_thuoc/index.jsp");
        return "admin/index";
    }

    @GetMapping("create")
    public String addView(Model model) {
        model.addAttribute("listKichThuoc", kichThuocService.findAll());
        model.addAttribute("view", "/kich_thuoc/kich_thuoc_add.jsp");
        return "admin/index";
    }

    @PostMapping("add")
    public String themMoi(Model model,
                          @RequestParam("giaTri") Integer giaTri,
                          @RequestParam("trangThai") Boolean trangThai
    ) {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setGiaTri(giaTri);
        kichThuoc.setTrangThai(trangThai);
        kichThuocService.add(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @PostMapping("update/{idud}")
    public String update(Model model,
                         @PathVariable("idud") Long idud,
                         @RequestParam("giaTri") Integer giaTri,
                         @RequestParam("trangThai") Boolean trangThai
    ) {
        KichThuoc kichThuoc = kichThuocService.findOne(idud);
        kichThuoc.setGiaTri(giaTri);
        kichThuoc.setTrangThai(trangThai);
        kichThuocService.update(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("delete/{idx}")
    public String xoa(Model model, @PathVariable("idx") Long idx) {
        kichThuocService.delete(idx);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("hien-thi/{iddt}")
    public String detail(Model model, @PathVariable("iddt") Long iddt) {
        model.addAttribute("ktd", kichThuocService.detail(iddt));
        model.addAttribute("listKichThuoc", kichThuocService.findAll());
        model.addAttribute("view", "/kich_thuoc/index.jsp");
        return "admin/index";

    }
}
