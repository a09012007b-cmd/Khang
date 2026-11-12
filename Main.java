package qlSV;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. In danh sách môn học từ enum.
        System.out.println("========== DANH SÁCH MÔN HỌC ==========");
        for (MonHoc mh : MonHoc.values()) {
            System.out.println(mh);
        }

        // 2. Tạo danh sách và thêm sinh viên.
        ListSinhVien ql = new ListSinhVien();

        ql.them(new SinhVienChinhQui(
            "SV01", "Nguyễn An", LocalDate.of(2005, 3, 12),
            "21DTH01", 3, MonHoc.LAP_TRINH_JAVA, "Cơ sở chính"
        ));

        ql.them(new SinhVienTuXa(
            "SV02", "Trần Bình", LocalDate.of(2004, 7, 20),
            "21DTH01", 4, MonHoc.CO_SO_DU_LIEU, "Zoom"
        ));

        ql.them(new SinhVienChinhQui(
            "SV03", "Lê Chi", LocalDate.of(2005, 1, 5),
            "21DTH02", 3, MonHoc.TOAN_ROI_RAC, "Cơ sở chính"
        ));

        ql.them(new SinhVienTuXa(
            "SV04", "Phạm Dũng", LocalDate.of(2004, 11, 2),
            "21DTH02", 5, MonHoc.LAP_TRINH_WEB, "Microsoft Teams"
        ));

        ql.them(new SinhVienChinhQui(
            "SV05", "Hoàng Giang", LocalDate.of(2005, 9, 15),
            "21DTH01", 2, MonHoc.MANG_MAY_TINH, "Cơ sở 2"
        ));

        ql.them(new SinhVienTuXa(
            "SV06", "Võ Hà", LocalDate.of(2004, 5, 8),
            "21DTH03", 4, MonHoc.TRI_TUE_NHAN_TAO, "Zoom"
        ));

        System.out.println("\n========== DANH SÁCH BAN ĐẦU ==========");
        inDanhSach(ql.layTatCa());

        // 3. Tìm sinh viên theo mã.
        System.out.println("\n========== TÌM THEO MÃ SV02 ==========");
        System.out.println(ql.timTheoMa("SV02"));

        // 4. Tìm theo tên có chứa từ khóa.
        System.out.println("\n========== TÌM TÊN CHỨA 'AN' ==========");
        inDanhSach(ql.timTheoTen("an"));

        // 5. Tìm theo lớp.
        System.out.println("\n========== TÌM LỚP 21DTH01 ==========");
        inDanhSach(ql.timTheoLop("21DTH01"));

        // 6. Tìm theo loại.
        System.out.println("\n========== SINH VIÊN TỪ XA ==========");
        inDanhSach(ql.timTheoLoai("Từ xa"));

        // 7. Tìm theo môn học.
        System.out.println("\n========== SINH VIÊN HỌC JAVA ==========");
        inDanhSach(ql.timTheoMon(MonHoc.LAP_TRINH_JAVA));

        // 8. Thống kê số lượng và tổng thành tiền.
        System.out.println("\n========== THỐNG KÊ ==========");
        System.out.println("Số lượng: " + ql.tongSoLuong());
        System.out.printf("Tổng thành tiền: %,.0f VND%n", ql.tongThanhTien());

        // 9. GROUP BY theo lớp.
        System.out.println("\n========== GROUP BY LỚP ==========");
        Map<String, List<SinhVien>> nhomLop =
            ql.nhomTheo(SinhVien::getLop);

        for (Map.Entry<String, List<SinhVien>> entry : nhomLop.entrySet()) {
            System.out.println("Lớp " + entry.getKey()
                + " có " + entry.getValue().size() + " sinh viên");
        }

        // 10. GROUP BY + SUM thành tiền theo loại.
        System.out.println("\n========== TỔNG TIỀN THEO LOẠI ==========");
        Map<String, Double> tongTheoLoai =
            ql.tongTienTheoNhom(SinhVien::getLoai);

        for (Map.Entry<String, Double> entry : tongTheoLoai.entrySet()) {
            System.out.printf("%s: %,.0f VND%n",
                entry.getKey(), entry.getValue());
        }

        // 11. HAVING: chỉ lấy lớp có ít nhất 2 sinh viên.
        System.out.println("\n========== HAVING: LỚP CÓ ÍT NHẤT 2 SV ==========");
        Map<String, List<SinhVien>> having =
            ql.havingSoLuong(SinhVien::getLop, 2);

        for (Map.Entry<String, List<SinhVien>> entry : having.entrySet()) {
            System.out.println(entry.getKey() + " -> "
                + entry.getValue().size() + " sinh viên");
        }

        // 12. Sắp xếp theo tên và thành tiền giảm dần.
        System.out.println("\n========== SẮP XẾP THEO TÊN ==========");
        inDanhSach(ql.sapXepTheoTen());

        System.out.println("\n========== SẮP XẾP THÀNH TIỀN GIẢM DẦN ==========");
        inDanhSach(ql.sapXepTheoThanhTienGiamDan());

        // Thử sửa và xóa.
        System.out.println("\n========== THỬ SỬA SV01 ==========");
        SinhVien svSua = new SinhVienChinhQui(
            "SV01", "Nguyễn An (đã sửa)", LocalDate.of(2005, 3, 12),
            "21DTH01", 3, MonHoc.LAP_TRINH_JAVA, "Cơ sở chính"
        );
        System.out.println("Sửa thành công? " + ql.sua("SV01", svSua));
        System.out.println(ql.timTheoMa("SV01"));

        System.out.println("\n========== THỬ XÓA SV06 ==========");
        System.out.println("Xóa thành công? " + ql.xoa("SV06"));
        System.out.println("Số lượng còn lại: " + ql.tongSoLuong());
    }

    private static void inDanhSach(List<SinhVien> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("(Không có kết quả)");
            return;
        }

        for (SinhVien sv : danhSach) {
            System.out.println(sv);
        }
    }
}
