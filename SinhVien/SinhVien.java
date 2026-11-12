public class SinhVien {

    private int maSV;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    public SinhVien() {
        maSV = 0;
        hoTen = "Chưa nhập";
        diemLT = 0;
        diemTH = 0;
    }

    public SinhVien(int maSV, String hoTen, double diemLT, double diemTH) {
        setMaSV(maSV);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        if (maSV > 0) {
            this.maSV = maSV;
        } else {
            this.maSV = 0;
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.trim().isEmpty()) {
            this.hoTen = hoTen;
        } else {
            this.hoTen = "Chưa nhập";
        }
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) {
        if (diemLT >= 0 && diemLT <= 10) {
            this.diemLT = diemLT;
        } else {
            this.diemLT = 0;
        }
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        if (diemTH >= 0 && diemTH <= 10) {
            this.diemTH = diemTH;
        } else {
            this.diemTH = 0;
        }
    }

    public double tinhDiemTrungBinh() {
        return (diemLT + diemTH) / 2;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10d %-20s %-10.2f %-10.2f %-10.2f",
            maSV,
            hoTen,
            diemLT,
            diemTH,
            tinhDiemTrungBinh()
        );
    }
}
