package qlSV;

import java.util.List;

public interface IFSinhVien {
    // Nhóm 1: CRUD
    boolean them(SinhVien sv);
    boolean sua(String maSV, SinhVien svMoi);
    boolean xoa(String maSV);
    boolean xoaTatCa();

    // Nhóm 2: Tìm kiếm
    List<SinhVien> layTatCa();
    SinhVien timTheoMa(String maSV);
    List<SinhVien> timTheoTen(String tuKhoa);
    List<SinhVien> timTheoLop(String lop);
    List<SinhVien> timTheoLoai(String loai);
    List<SinhVien> timTheoMon(MonHoc monHoc);

    // Nhóm 3: Thống kê
    int tongSoLuong();
    double tongThanhTien();

    // Nhóm 4: Sắp xếp
    List<SinhVien> sapXepTheoTen();
    List<SinhVien> sapXepTheoThanhTienGiamDan();
}
