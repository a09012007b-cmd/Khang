import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainGiaoDichMang {

    private static final int SO_LUONG_TOI_DA = 100;
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Mảng thường thay cho ArrayList, soLuong là số phần tử đã thêm
    private static GiaoDich[] ds = new GiaoDich[SO_LUONG_TOI_DA];
    private static int soLuong = 0;

    private static int docSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    private static double docSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v > 0) {
                    return v;
                }
                System.out.println("Giá trị phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    private static LocalDate docNgay(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return LocalDate.parse(sc.nextLine().trim(), FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, nhập theo dạng dd/MM/yyyy!");
            }
        }
    }

    private static String docChuoi(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim();
    }

    // Thêm một giao dịch vào mảng, báo lỗi nếu mảng đã đầy
    private static boolean them(GiaoDich gd) {
        if (soLuong >= SO_LUONG_TOI_DA) {
            System.out.println("Danh sách đã đầy, không thể thêm!");
            return false;
        }
        ds[soLuong++] = gd;
        return true;
    }

    private static GiaoDichDat nhapGiaoDichDat() {
        String ma = docChuoi("Mã giao dịch: ");
        LocalDate ngay = docNgay("Ngày giao dịch (dd/MM/yyyy): ");
        double donGia = docSoThuc("Đơn giá: ");
        double dienTich = docSoThuc("Diện tích: ");
        String loai;
        do {
            loai = docChuoi("Loại đất (A/B/C): ").toUpperCase();
        } while (!loai.equals("A") && !loai.equals("B") && !loai.equals("C"));
        return new GiaoDichDat(ma, ngay, donGia, dienTich, loai);
    }

    private static GiaoDichNha nhapGiaoDichNha() {
        String ma = docChuoi("Mã giao dịch: ");
        LocalDate ngay = docNgay("Ngày giao dịch (dd/MM/yyyy): ");
        double donGia = docSoThuc("Đơn giá: ");
        double dienTich = docSoThuc("Diện tích: ");
        String loai;
        do {
            loai = docChuoi("Loại nhà (cao cấp/thường): ").toLowerCase();
        } while (!loai.equals("cao cấp") && !loai.equals("thường"));
        String diaChi = docChuoi("Địa chỉ: ");
        return new GiaoDichNha(ma, ngay, donGia, dienTich, loai, diaChi);
    }

    private static void inDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            System.out.println(ds[i]);
        }
    }

    private static void demTungLoai() {
        int dat = 0, nha = 0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i] instanceof GiaoDichDat) {
                dat++;
            } else if (ds[i] instanceof GiaoDichNha) {
                nha++;
            }
        }
        System.out.println("Số giao dịch đất: " + dat);
        System.out.println("Số giao dịch nhà: " + nha);
    }

    private static void trungBinhDat() {
        double tong = 0;
        int dem = 0;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i] instanceof GiaoDichDat) {
                tong += ds[i].thanhTien();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("Chưa có giao dịch đất nào.");
        } else {
            System.out.printf("Trung bình thành tiền đất: %,.0f%n", tong / dem);
        }
    }

    private static void locTheoThang() {
        int thang = docSoNguyen("Nhập tháng: ");
        int nam = docSoNguyen("Nhập năm: ");
        System.out.println("\n=== Giao dịch tháng " + thang + "/" + nam + " ===");
        boolean coKetQua = false;
        for (int i = 0; i < soLuong; i++) {
            LocalDate ngay = ds[i].getNgayGiaoDich();
            if (ngay.getMonthValue() == thang && ngay.getYear() == nam) {
                System.out.println(ds[i]);
                coKetQua = true;
            }
        }
        if (!coKetQua) {
            System.out.println("Không có giao dịch nào.");
        }
    }

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n========== QUẢN LÝ GIAO DỊCH ==========");
            System.out.println("1. Thêm giao dịch đất");
            System.out.println("2. Thêm giao dịch nhà");
            System.out.println("3. Xuất danh sách giao dịch");
            System.out.println("4. Đếm số lượng từng loại giao dịch");
            System.out.println("5. Trung bình thành tiền giao dịch đất");
            System.out.println("6. Xuất giao dịch theo tháng/năm");
            System.out.println("0. Thoát");
            chon = docSoNguyen("Chọn chức năng: ");

            switch (chon) {
                case 1:
                    if (them(nhapGiaoDichDat())) {
                        System.out.println("Đã thêm giao dịch đất.");
                    }
                    break;
                case 2:
                    if (them(nhapGiaoDichNha())) {
                        System.out.println("Đã thêm giao dịch nhà.");
                    }
                    break;
                case 3:
                    inDanhSach();
                    break;
                case 4:
                    demTungLoai();
                    break;
                case 5:
                    trungBinhDat();
                    break;
                case 6:
                    locTheoThang();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);

        sc.close();
    }
}
