package com.poly.duanbangiay.controller;


import com.poly.duanbangiay.entity.KichThuoc;
import com.poly.duanbangiay.entity.KichThuocMauSac;
import com.poly.duanbangiay.entity.MauSac;
import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.service.serviceimpl.KichThuocMauSacServiceImpl;
import com.poly.duanbangiay.service.serviceimpl.KichThuocServiceImpl;
import com.poly.duanbangiay.service.serviceimpl.MauSacServiceImpl;
import com.poly.duanbangiay.service.serviceimpl.SanPhamServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("kich-thuoc-mau-sac")
public class KichThuocMauSacController {

    @Autowired
    KichThuocServiceImpl kichThuocService;
    @Autowired
    KichThuocMauSacServiceImpl kichThuocMauSacService;
    @Autowired
    MauSacServiceImpl mauSacService;
    @Autowired
    SanPhamServiceimpl sanPhamServiceimpl;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listKichThuoc", kichThuocService.findAll());
        model.addAttribute("listSanPham", sanPhamServiceimpl.getAll());
        model.addAttribute("listMauSac", mauSacService.findAll());
        model.addAttribute("listKichThuocMauSac", kichThuocMauSacService.findAll());
        model.addAttribute("view", "/kich_thuoc_mau_sac/index.jsp");
        return "admin/index";
    }

    @PostMapping("add")
    public String themMoi(Model model,
                          @RequestParam("soLuong") Integer soLuong,
                          @RequestParam("sanPham") SanPham sanPham,
                          @RequestParam("mauSac") MauSac mauSac,
                          @RequestParam("kichThuoc") KichThuoc kichThuoc,
                          @RequestParam("trangThai") Integer trangThai
    ) {
        KichThuocMauSac kichThuocMauSac = new KichThuocMauSac();
        kichThuocMauSac.setSoLuong(soLuong);
        kichThuocMauSac.setSanPham(sanPham);
        kichThuocMauSac.setMauSac(mauSac);
        kichThuocMauSac.setKichThuoc(kichThuoc);
        kichThuocMauSac.setSoLuong(soLuong);
        kichThuocMauSac.setTrangThai(trangThai);
        kichThuocMauSacService.add(kichThuocMauSac);
        return "redirect:/kich-thuoc-mau-sac/hien-thi";
    }

    @PostMapping("update/{idud}")
    public String update(Model model,
                         @PathVariable("idud") Long idud,
                         @RequestParam("soLuong") Integer soLuong,
                         @RequestParam("sanPham") SanPham sanPham,
                         @RequestParam("mauSac") MauSac mauSac,
                         @RequestParam("kichThuoc") KichThuoc kichThuoc,
                         @RequestParam("trangThai") Integer trangThai
    ) {
        KichThuocMauSac kichThuocMauSac = kichThuocMauSacService.findOne(idud);
        kichThuocMauSac.setSoLuong(soLuong);
        kichThuocMauSac.setSanPham(sanPham);
        kichThuocMauSac.setMauSac(mauSac);
        kichThuocMauSac.setKichThuoc(kichThuoc);
        kichThuocMauSac.setSoLuong(soLuong);
        kichThuocMauSac.setTrangThai(trangThai);
        kichThuocMauSacService.add(kichThuocMauSac);
        return "redirect:/kich-thuoc-mau-sac/hien-thi";
    }

    @GetMapping("delete/{idx}")
    public String xoa(Model model, @PathVariable("idx") Long idx) {
        kichThuocMauSacService.delete(idx);
        return "redirect:/kich-thuoc-mau-sac/hien-thi";
    }

    @GetMapping("hien-thi/{iddt}")
    public String detail(Model model, @PathVariable("iddt") Long iddt) {
        model.addAttribute("listKichThuoc", kichThuocService.findAll());
        model.addAttribute("listSanPham", sanPhamServiceimpl.getAll());
        model.addAttribute("listMauSac", mauSacService.findAll());
        model.addAttribute("ktmsd", kichThuocMauSacService.detail(iddt));
        model.addAttribute("listKichThuocMauSac", kichThuocMauSacService.findAll());
        model.addAttribute("view", "/kich_thuoc_mau_sac/index.jsp");
        return "admin/index";

    }
}
