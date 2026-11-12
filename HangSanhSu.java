import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// Hàng sành sứ: VAT 10%
public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia,
                      String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (ngayNhapKho == null) {
            throw new IllegalArgumentException("Ngày nhập kho không được null!");
        }
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return getDonGia() * 0.1;
    }

    // Tồn kho > 50 và lưu kho > 10 ngày thì bán chậm
    @Override
    public String danhGiaMucDoBanBuon() {
        long soNgayLuuKho = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (getSoLuongTon() > 50 && soNgayLuuKho > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return "[SÀNH SỨ] " + super.toString()
                + " | NSX: " + nhaSanXuat
                + " | Ngày nhập: " + ngayNhapKho.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + String.format(" | VAT: %,.0f", tinhVAT())
                + " | Đánh giá: " + danhGiaMucDoBanBuon();
    }
}
