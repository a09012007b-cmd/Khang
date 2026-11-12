// File: GiaoDich.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ============================================================
// (1) LỚP TRỪU TƯỢNG GiaoDich
// ============================================================
public abstract class GiaoDich {
    protected String maGiaoDich;       // protected → lớp con truy cập được
    protected LocalDate ngayGiaoDich;  // LocalDate xử lý ngày tháng tiện hơn
    protected double donGia;
    protected double dienTich;

    // Constructor nhận đủ tham số
    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich,
                    double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    // Phương thức trừu tượng — lớp con bắt buộc override
    public abstract double thanhTien();

    // Getter cần thiết để truy xuất từ bên ngoài
    public String getMaGiaoDich() { return maGiaoDich; }
    public LocalDate getNgayGiaoDich() { return ngayGiaoDich; }

    // Ghi đè toString() để in ra dễ đọc
    @Override
    public String toString() {
        return String.format(
            "Mã: %-6s | Ngày: %s | Đơn giá: %,.0f | DT: %.1f | Thành tiền: %,.0f",
            maGiaoDich,
            ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            donGia, dienTich, thanhTien());
    }
}
