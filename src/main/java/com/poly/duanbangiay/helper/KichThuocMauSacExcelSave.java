package com.poly.duanbangiay.helper;


import com.poly.duanbangiay.entity.KichThuoc;
import com.poly.duanbangiay.entity.KichThuocMauSac;
import com.poly.duanbangiay.entity.MauSac;
import com.poly.duanbangiay.entity.SanPham;
import com.poly.duanbangiay.service.serviceimpl.KichThuocServiceImpl;
import com.poly.duanbangiay.service.serviceimpl.MauSacServiceImpl;
import com.poly.duanbangiay.service.serviceimpl.SanPhamServiceimpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KichThuocMauSacExcelSave {


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"SoLuong", "TrangThai", "MauSac", "SanPham", "KichThuoc"};
    static String SHEET = "KichThuocMauSac";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<KichThuocMauSac> excelImport(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<KichThuocMauSac> kichThuocList = new ArrayList<>();
            MauSacServiceImpl mauSacService = new MauSacServiceImpl();
            KichThuocServiceImpl kichThuocService = new KichThuocServiceImpl();
            SanPhamServiceimpl sanPhamService = new SanPhamServiceimpl();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                //bỏ qua header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                KichThuocMauSac kichThuocMauSac = new KichThuocMauSac();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            kichThuocMauSac.setSoLuong((int) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            kichThuocMauSac.setTrangThai((int) currentCell.getNumericCellValue());
                            break;
                        case 2:
                            MauSac mauSac = mauSacService.findOne((long) currentCell.getNumericCellValue());
                            kichThuocMauSac.setMauSac(mauSac);
                            break;
                        case 3:
                            SanPham sanPham = sanPhamService.getOne((long) currentCell.getNumericCellValue());
                            kichThuocMauSac.setSanPham(sanPham);
                            break;
                        case 4:
                            KichThuoc kichThuoc = kichThuocService.findOne((long) currentCell.getNumericCellValue());
                            kichThuocMauSac.setKichThuoc(kichThuoc);
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                kichThuocList.add(kichThuocMauSac);
            }
            workbook.close();
            return kichThuocList;
        } catch (IOException e) {
            throw new RuntimeException("lỗi parse: " + e.getMessage());
        }
    }
}
