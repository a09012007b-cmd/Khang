import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
    private String loaiDat;

    public GiaoDichDat(String ma, LocalDate ngay, double donGia,
                       double dienTich, String loaiDat) {
        super(ma, ngay, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    @Override
    public double thanhTien() {
        if (loaiDat.equalsIgnoreCase("A")) {
            return dienTich * donGia * 1.5;
        }
        return dienTich * donGia;
    }

    @Override
    public String toString() {
        return "[ĐẤT] " + super.toString() + " | Loại: " + loaiDat;
    }
}
