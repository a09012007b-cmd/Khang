public class QuanLyHangHoa {
    private HangHoa[] danhSach;
    private int soLuong;

    public QuanLyHangHoa(int sucChua) {
        if (sucChua <= 0) {
            sucChua = 100;
        }
        danhSach = new HangHoa[sucChua];
        soLuong = 0;
    }

    public QuanLyHangHoa() {
        this(100);
    }

    public boolean tonTaiMa(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean themHang(HangHoa hang) {
        if (hang == null) {
            return false;
        }
        if (soLuong >= danhSach.length) {
            System.out.println("Danh sách đã đầy!");
            return false;
        }
        if (tonTaiMa(hang.getMaHang())) {
            System.out.println("Mã hàng bị trùng!");
            return false;
        }
        danhSach[soLuong++] = hang;
        return true;
    }

    public void inDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            System.out.println((i + 1) + ". " + danhSach[i]);
        }
    }

    public int getSoLuong() {
        return soLuong;
    }
}
