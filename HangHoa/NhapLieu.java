import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NhapLieu {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String docChuoiKhongRong(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Không được để trống!");
        }
    }

    public static int docSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    public static int docSoNguyenKhongAm(String thongBao) {
        while (true) {
            int v = docSoNguyen(thongBao);
            if (v >= 0) {
                return v;
            }
            System.out.println("Giá trị phải >= 0!");
        }
    }

    public static double docSoThucDuong(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v > 0) {
                    return v;
                }
                System.out.println("Giá trị phải > 0!");
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    public static LocalDate docNgay(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return LocalDate.parse(sc.nextLine().trim(), FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, nhập theo dạng dd/MM/yyyy!");
            }
        }
    }

    public static LocalDate docNgayHetHan(String thongBao, LocalDate ngaySanXuat) {
        while (true) {
            LocalDate d = docNgay(thongBao);
            if (!d.isBefore(ngaySanXuat)) {
                return d;
            }
            System.out.println("Ngày hết hạn phải sau hoặc bằng ngày sản xuất!");
        }
    }
}
