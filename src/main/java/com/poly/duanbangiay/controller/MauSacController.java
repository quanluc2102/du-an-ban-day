package com.poly.duanbangiay.controller;


import com.poly.duanbangiay.entity.MauSac;
import com.poly.duanbangiay.service.serviceimpl.MauSacServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {

    @Autowired
    MauSacServiceImpl mauSacService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listMauSac", mauSacService.findAll());
        model.addAttribute("view", "/mau_sac/index.jsp");

        return "admin/index";
    }

//    @GetMapping("create")
//    public String create(Model model) {
//        model.addAttribute("view", "/mau_sac/mau_sac_add.jsp");
//        return "admin/index";
//    }

    @PostMapping("add")
    public String themMoi(Model model,
                          @RequestParam("ten") String ten,
                          @RequestParam("giaTri") Integer giaTri,
                          @RequestParam("trangThai") Boolean trangThai
    ) {
        MauSac mauSac = new MauSac();
        mauSac.setTen(ten);
        mauSac.setGiaTri(giaTri);
        mauSac.setTrangThai(trangThai);
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("update/{idud}")
    public String update(Model model,
                         @PathVariable("idud") Long idud,
                         @RequestParam("ten") String ten,
                         @RequestParam("giaTri") Integer giaTri,
                         @RequestParam("trangThai") Boolean trangThai
    ) {
        MauSac mauSac = mauSacService.findOne(idud);
        mauSac.setTen(ten);
        mauSac.setGiaTri(giaTri);
        mauSac.setTrangThai(trangThai);
        mauSacService.update(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("delete/{idx}")
    public String xoa(Model model, @PathVariable("idx") Long idx) {
        mauSacService.delete(idx);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("hien-thi/{iddt}")
    public String detail(Model model, @PathVariable("iddt") Long iddt) {
        model.addAttribute("msd", mauSacService.detail(iddt));
        model.addAttribute("view", "/mau_sac/index.jsp");
        model.addAttribute("listMauSac", mauSacService.findAll());
        return "admin/index";

    }
}
