package com.poly.duanbangiay.service.serviceimpl;

import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.helper.SanPhamExcelSave;
import com.poly.duanbangiay.repository.SanPhamRespository;
import com.poly.duanbangiay.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Service
public class SanPhamServiceimpl implements SanPhamService {
    @Autowired
    SanPhamRespository sanPhamRespository;
    @Override
    public void add(SanPham sp) {
        sp.setNgayTao(Date.valueOf(LocalDate.now()));
        sp.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        sanPhamRespository.saveAndFlush(sp);
    }

    @Override
    public void delete(Long id) {
        sanPhamRespository.deleteById(id);
    }

    @Override
    public void update(Long id, SanPham sp) {
        SanPham a = sanPhamRespository.findById(id).get();
        a.setTen(sp.getTen());
        a.setGiaBan(sp.getGiaBan());
        a.setGiaNhap(sp.getGiaNhap());
        a.setMoTa(sp.getMoTa());
        a.setSoLuong(sp.getSoLuong());
        a.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        sanPhamRespository.flush();
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRespository.findAll();
    }

    @Override
    public SanPham getOne(Long id) {
        return sanPhamRespository.findById(id).get();
    }

    @Override
    public void chuyenTrangThai(SanPham sp) {
        if(sp.getSoLuong()>0){
            sp.setTrangThai(1);
        }else if(sp.getSoLuong()==0){
            sp.setTrangThai(0);
        }else{
            sp.setSoLuong(0);
            sp.setTrangThai(0);
        }
        sanPhamRespository.flush();
    }

    @Override
    public void importExcel(MultipartFile file) {
        try {
            List<SanPham> tutorials = SanPhamExcelSave.excelToTutorials(file.getInputStream());


            for(SanPham a :tutorials){
                sanPhamRespository.save(a);
                a.toString();
            }
            sanPhamRespository.flush();
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
