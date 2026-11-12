import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    // Đọc một số nguyên, nhập sai thì yêu cầu nhập lại
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

    // Đọc một số thực, nhập sai thì yêu cầu nhập lại
    private static double docSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    public static void main(String[] args) {
        int n;
        do {
            n = docSoNguyen("Nhập số lượng sinh viên: ");
            if (n <= 0) {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        } while (n <= 0);

        SinhVien[] ds = new SinhVien[n];

        // Nhập danh sách sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập sinh viên thứ " + (i + 1) + " ---");
            int maSV = docSoNguyen("Mã sinh viên: ");
            System.out.print("Họ tên: ");
            String hoTen = sc.nextLine();
            double diemLT = docSoThuc("Điểm lý thuyết (0-10): ");
            double diemTH = docSoThuc("Điểm thực hành (0-10): ");

            ds[i] = new SinhVien(maSV, hoTen, diemLT, diemTH);
        }

        // In danh sách
        System.out.println("\n================ DANH SÁCH SINH VIÊN ================");
        System.out.println(String.format("%-10s %-20s %-10s %-10s %-10s",
                "Mã SV", "Họ tên", "Điểm LT", "Điểm TH", "Điểm TB"));
        for (SinhVien sv : ds) {
            System.out.println(sv);
        }

        // Tìm sinh viên có điểm trung bình cao nhất
        SinhVien max = ds[0];
        for (SinhVien sv : ds) {
            if (sv.tinhDiemTrungBinh() > max.tinhDiemTrungBinh()) {
                max = sv;
            }
        }

        System.out.println("\nSinh viên có điểm trung bình cao nhất:");
        System.out.println(max);

        sc.close();
    }
}
