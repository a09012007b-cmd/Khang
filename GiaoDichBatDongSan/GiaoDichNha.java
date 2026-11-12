import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
    private String loaiNha;
    private String diaChi;

    public GiaoDichNha(String ma, LocalDate ngay, double donGia,
                       double dienTich, String loaiNha, String diaChi) {
        super(ma, ngay, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    @Override
    public double thanhTien() {
        if (loaiNha.equalsIgnoreCase("cao cấp")) {
            return dienTich * donGia;
        }
        return dienTich * donGia * 0.9;
    }

    @Override
    public String toString() {
        return "[NHÀ] " + super.toString()
             + " | Loại: " + loaiNha + " | ĐC: " + diaChi;
    }
}
