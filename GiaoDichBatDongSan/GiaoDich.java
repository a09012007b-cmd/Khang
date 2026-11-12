import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDich {
    protected String maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected double dienTich;

    // Constructor
    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich,
                    double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    // Phương thức trừu tượng
    public abstract double thanhTien();

    // Getter
    public String getMaGiaoDich() { return maGiaoDich; }
    public LocalDate getNgayGiaoDich() { return ngayGiaoDich; }

    //toString
    @Override
    public String toString() {
        return String.format(
            "Mã: %-6s | Ngày: %s | Đơn giá: %,.0f | DT: %.1f | Thành tiền: %,.0f",
            maGiaoDich,
            ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            donGia, dienTich, thanhTien());
    }
}
