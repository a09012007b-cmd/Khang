import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia,
                        LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (ngaySanXuat == null || ngayHetHan == null) {
            throw new IllegalArgumentException("Ngày sản xuất và ngày hết hạn không được null!");
        }
        if (ngayHetHan.isBefore(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất!");
        }
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return getDonGia() * 0.05;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (getSoLuongTon() > 0 && LocalDate.now().isAfter(ngayHetHan)) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "[THỰC PHẨM] " + super.toString()
                + " | NSX: " + ngaySanXuat.format(f)
                + " | HSD: " + ngayHetHan.format(f)
                + " | NCC: " + nhaCungCap
                + String.format(" | VAT: %,.0f", tinhVAT())
                + " | Đánh giá: " + danhGiaMucDoBanBuon();
    }
}
