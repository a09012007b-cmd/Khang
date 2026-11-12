package qlSV;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListSinhVien implements IFSinhVien {
    private final List<SinhVien> danhSach = new ArrayList<>();

    // ==================== CRUD ====================

    @Override
    public boolean them(SinhVien sv) {
        if (sv == null || sv.getMaSV() == null || timTheoMa(sv.getMaSV()) != null) {
            return false;
        }
        danhSach.add(sv);
        return true;
    }

    @Override
    public boolean sua(String maSV, SinhVien svMoi) {
        if (svMoi == null) return false;

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                // Không cho phép đổi sang mã đã thuộc về sinh viên khác.
                SinhVien trung = timTheoMa(svMoi.getMaSV());
                if (trung != null && trung != danhSach.get(i)) return false;

                danhSach.set(i, svMoi);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean xoa(String maSV) {
        SinhVien sv = timTheoMa(maSV);
        return sv != null && danhSach.remove(sv);
    }

    @Override
    public boolean xoaTatCa() {
        if (danhSach.isEmpty()) return false;
        danhSach.clear();
        return true;
    }

    // ==================== TÌM KIẾM ====================

    @Override
    public List<SinhVien> layTatCa() {
        return new ArrayList<>(danhSach);
    }

    @Override
    public SinhVien timTheoMa(String maSV) {
        if (maSV == null) return null;

        for (SinhVien sv : danhSach) {
            if (sv.getMaSV().equalsIgnoreCase(maSV.trim())) return sv;
        }
        return null;
    }

    @Override
    public List<SinhVien> timTheoTen(String tuKhoa) {
        if (tuKhoa == null) return new ArrayList<>();
        String tuKhoaChuan = tuKhoa.toLowerCase();

        return tim(sv -> sv.getHoTen().toLowerCase().contains(tuKhoaChuan));
    }

    @Override
    public List<SinhVien> timTheoLop(String lop) {
        if (lop == null) return new ArrayList<>();
        return tim(sv -> sv.getLop().equalsIgnoreCase(lop.trim()));
    }

    @Override
    public List<SinhVien> timTheoLoai(String loai) {
        if (loai == null) return new ArrayList<>();
        return tim(sv -> sv.getLoai().equalsIgnoreCase(loai.trim()));
    }

    @Override
    public List<SinhVien> timTheoMon(MonHoc monHoc) {
        if (monHoc == null) return new ArrayList<>();
        return tim(sv -> sv.getMonHoc() == monHoc);
    }

    // Hàm tìm kiếm chung: nhận điều kiện bằng Predicate.
    public List<SinhVien> tim(Predicate<SinhVien> dieuKien) {
        List<SinhVien> ketQua = new ArrayList<>();

        for (SinhVien sv : danhSach) {
            if (dieuKien.test(sv)) ketQua.add(sv);
        }
        return ketQua;
    }

    // ==================== THỐNG KÊ ====================

    @Override
    public int tongSoLuong() {
        return danhSach.size();
    }

    @Override
    public double tongThanhTien() {
        double tong = 0;
        for (SinhVien sv : danhSach) tong += sv.thanhTien();
        return tong;
    }

    // ==================== SẮP XẾP ====================

    // Hai hàm dưới đây trả về danh sách mới, không đổi danh sách gốc.
    @Override
    public List<SinhVien> sapXepTheoTen() {
        List<SinhVien> ketQua = layTatCa();
        ketQua.sort(Comparator.comparing(
            SinhVien::getHoTen, String.CASE_INSENSITIVE_ORDER
        ));
        return ketQua;
    }

    @Override
    public List<SinhVien> sapXepTheoThanhTienGiamDan() {
        List<SinhVien> ketQua = layTatCa();
        ketQua.sort(Comparator.comparingDouble(SinhVien::thanhTien).reversed());
        return ketQua;
    }

    // Sắp xếp trực tiếp danh sách gốc theo Comparator.
    public void sapXep(Comparator<SinhVien> cmp) {
        danhSach.sort(cmp);
    }

    public void sapXepGiamDan(Comparator<SinhVien> cmp) {
        danhSach.sort(cmp.reversed());
    }

    // ==================== GROUP BY ====================

    // Gom sinh viên theo một khóa bất kỳ, ví dụ lớp hoặc loại sinh viên.
    public <K> Map<K, List<SinhVien>> nhomTheo(Function<SinhVien, K> layKey) {
        Map<K, List<SinhVien>> ketQua = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            ketQua.computeIfAbsent(key, k -> new ArrayList<>()).add(sv);
        }
        return ketQua;
    }

    // Đếm số sinh viên trong từng nhóm.
    public <K> Map<K, Integer> demTheoNhom(Function<SinhVien, K> layKey) {
        Map<K, Integer> ketQua = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            ketQua.put(key, ketQua.getOrDefault(key, 0) + 1);
        }
        return ketQua;
    }

    // Tính tổng thành tiền của từng nhóm.
    public <K> Map<K, Double> tongTienTheoNhom(Function<SinhVien, K> layKey) {
        Map<K, Double> ketQua = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            ketQua.put(key, ketQua.getOrDefault(key, 0.0) + sv.thanhTien());
        }
        return ketQua;
    }

    // ==================== HAVING ====================

    // Chỉ giữ các nhóm có số lượng sinh viên >= soLuongToiThieu.
    public <K> Map<K, List<SinhVien>> havingSoLuong(
            Function<SinhVien, K> layKey, int soLuongToiThieu) {

        Map<K, List<SinhVien>> cacNhom = nhomTheo(layKey);
        Map<K, List<SinhVien>> ketQua = new LinkedHashMap<>();

        for (Map.Entry<K, List<SinhVien>> entry : cacNhom.entrySet()) {
            if (entry.getValue().size() >= soLuongToiThieu) {
                ketQua.put(entry.getKey(), entry.getValue());
            }
        }
        return ketQua;
    }

    // Chỉ giữ các nhóm có tổng thành tiền >= nguong.
    public <K> Map<K, Double> havingTongTien(
            Function<SinhVien, K> layKey, double nguong) {

        Map<K, Double> cacNhom = tongTienTheoNhom(layKey);
        Map<K, Double> ketQua = new LinkedHashMap<>();

        for (Map.Entry<K, Double> entry : cacNhom.entrySet()) {
            if (entry.getValue() >= nguong) {
                ketQua.put(entry.getKey(), entry.getValue());
            }
        }
        return ketQua;
    }
}
