package com.poly.duanbangiay.helper;


import com.poly.duanbangiay.entity.KichThuocMauSac;
import com.poly.duanbangiay.entity.MauSac;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
                            kichThuocMauSac.setMauSacex((long) currentCell.getNumericCellValue());
                            break;
                        case 3:
                            kichThuocMauSac.setSanPhamex((long) currentCell.getNumericCellValue());
                            break;
                        case 4:
                            kichThuocMauSac.setKichThuocex((long) currentCell.getNumericCellValue());
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
