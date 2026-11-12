// Hàng điện máy: VAT 10%
public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;  // số tháng, >= 0
    private double congSuat;      // KW, > 0

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia,
                       int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        setThoiGianBaoHanh(thoiGianBaoHanh);
        setCongSuat(congSuat);
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh < 0) {
            throw new IllegalArgumentException("Thời gian bảo hành phải >= 0!");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        if (congSuat <= 0) {
            throw new IllegalArgumentException("Công suất phải > 0!");
        }
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return getDonGia() * 0.1;
    }

    // Tồn kho < 3 thì được đánh giá là bán được
    @Override
    public String danhGiaMucDoBanBuon() {
        if (getSoLuongTon() < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return "[ĐIỆN MÁY] " + super.toString()
                + " | Bảo hành: " + thoiGianBaoHanh + " tháng"
                + " | Công suất: " + congSuat + " KW"
                + String.format(" | VAT: %,.0f", tinhVAT())
                + " | Đánh giá: " + danhGiaMucDoBanBuon();
    }
}
