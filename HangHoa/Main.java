import java.time.LocalDate;

public class ChuongTrinh {

    private static String nhapMaMoi(QuanLyHangHoa ql) {
        while (true) {
            String ma = NhapLieu.docChuoiKhongRong("Mã hàng: ");
            if (!ql.tonTaiMa(ma)) {
                return ma;
            }
            System.out.println("Mã hàng đã tồn tại, vui lòng nhập mã khác!");
        }
    }

    private static HangThucPham nhapHangThucPham(QuanLyHangHoa ql) {
        String ma = nhapMaMoi(ql);
        String ten = NhapLieu.docChuoiKhongRong("Tên hàng: ");
        int sl = NhapLieu.docSoNguyenKhongAm("Số lượng tồn: ");
        double gia = NhapLieu.docSoThucDuong("Đơn giá: ");
        LocalDate nsx = NhapLieu.docNgay("Ngày sản xuất (dd/MM/yyyy): ");
        LocalDate hsd = NhapLieu.docNgayHetHan("Ngày hết hạn (dd/MM/yyyy): ", nsx);
        String ncc = NhapLieu.docChuoiKhongRong("Nhà cung cấp: ");
        return new HangThucPham(ma, ten, sl, gia, nsx, hsd, ncc);
    }

    private static HangDienMay nhapHangDienMay(QuanLyHangHoa ql) {
        String ma = nhapMaMoi(ql);
        String ten = NhapLieu.docChuoiKhongRong("Tên hàng: ");
        int sl = NhapLieu.docSoNguyenKhongAm("Số lượng tồn: ");
        double gia = NhapLieu.docSoThucDuong("Đơn giá: ");
        int bh = NhapLieu.docSoNguyenKhongAm("Thời gian bảo hành (tháng): ");
        double congSuat = NhapLieu.docSoThucDuong("Công suất (KW): ");
        return new HangDienMay(ma, ten, sl, gia, bh, congSuat);
    }

    private static HangSanhSu nhapHangSanhSu(QuanLyHangHoa ql) {
        String ma = nhapMaMoi(ql);
        String ten = NhapLieu.docChuoiKhongRong("Tên hàng: ");
        int sl = NhapLieu.docSoNguyenKhongAm("Số lượng tồn: ");
        double gia = NhapLieu.docSoThucDuong("Đơn giá: ");
        String nsx = NhapLieu.docChuoiKhongRong("Nhà sản xuất: ");
        LocalDate ngayNhap = NhapLieu.docNgay("Ngày nhập kho (dd/MM/yyyy): ");
        return new HangSanhSu(ma, ten, sl, gia, nsx, ngayNhap);
    }

    public static void main(String[] args) {
        QuanLyHangHoa ql = new QuanLyHangHoa();
        int chon;

        do {
            System.out.println("\n========== QUẢN LÝ KHO SIÊU THỊ ==========");
            System.out.println("1. Thêm hàng thực phẩm");
            System.out.println("2. Thêm hàng điện máy");
            System.out.println("3. Thêm hàng sành sứ");
            System.out.println("4. In danh sách hàng hóa");
            System.out.println("0. Thoát");
            chon = NhapLieu.docSoNguyen("Chọn chức năng: ");

            HangHoa hang = null;
            switch (chon) {
                case 1:
                    hang = nhapHangThucPham(ql);
                    break;
                case 2:
                    hang = nhapHangDienMay(ql);
                    break;
                case 3:
                    hang = nhapHangSanhSu(ql);
                    break;
                case 4:
                    ql.inDanhSach();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

            if (hang != null) {
                if (ql.themHang(hang)) {
                    System.out.println("Thêm hàng thành công.");
                } else {
                    System.out.println("Thêm hàng thất bại.");
                }
            }
        } while (chon != 0);
    }
}
