// File: GiaoDichDat.java
import java.time.LocalDate;

// ============================================================
// (2) LỚP GiaoDichDat kế thừa GiaoDich
// ============================================================
public class GiaoDichDat extends GiaoDich {
    private String loaiDat;  // "A", "B", "C"

    public GiaoDichDat(String ma, LocalDate ngay, double donGia,
                       double dienTich, String loaiDat) {
        super(ma, ngay, donGia, dienTich);  // Gọi constructor lớp cha
        this.loaiDat = loaiDat;
    }

    // OVERRIDE: tính thành tiền theo loại đất
    @Override
    public double thanhTien() {
        if (loaiDat.equalsIgnoreCase("A")) {
            return dienTich * donGia * 1.5;
        }
        // Loại B và C: công thức thường
        return dienTich * donGia;
    }

    @Override
    public String toString() {
        return "[ĐẤT] " + super.toString() + " | Loại: " + loaiDat;
    }
}
