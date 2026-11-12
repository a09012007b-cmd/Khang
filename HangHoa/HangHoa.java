public abstract class HangHoa {
    private final String maHang;  
    private String tenHang;
    private int soLuongTon;
    private double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống!");
        }
        this.maHang = maHang.trim();
        setTenHang(tenHang);
        setSoLuongTon(soLuongTon);
        setDonGia(donGia);
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được rỗng!");
        }
        this.tenHang = tenHang.trim();
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) {
            throw new IllegalArgumentException("Số lượng tồn phải >= 0!");
        }
        this.soLuongTon = soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            throw new IllegalArgumentException("Đơn giá phải > 0!");
        }
        this.donGia = donGia;
    }

    public abstract double tinhVAT();

    public abstract String danhGiaMucDoBanBuon();

    @Override
    public String toString() {
        return String.format("Mã: %-6s | Tên: %-15s | SL tồn: %-5d | Đơn giá: %,.0f",
                maHang, tenHang, soLuongTon, donGia);
    }
}
