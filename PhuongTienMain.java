package vehicle.java;

import java.util.Scanner;

public class VehicleMain {

    private static final Scanner sc = new Scanner(System.in);

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
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    public static void main(String[] args) {
        int n;
        do {
            n = docSoNguyen("Nhập số lượng xe: ");
            if (n <= 0) {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        } while (n <= 0);

        Vehicle[] ds = new Vehicle[n];

        // Nhập thông tin từng xe
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập xe thứ " + (i + 1) + " ---");
            System.out.print("Tên chủ xe: ");
            String name = sc.nextLine();
            System.out.print("Loại xe: ");
            String type = sc.nextLine();
            double value = docSoThuc("Trị giá xe: ");
            int capacity = docSoNguyen("Dung tích xi-lanh (cc): ");

            ds[i] = new Vehicle(name, type, value, capacity);
        }

        // In bảng kê khai thuế
        System.out.println("\n=================== BẢNG KÊ KHAI TIỀN THUẾ TRƯỚC BẠ ===================");
        System.out.println(String.format("%15s %20s %20s %15s %15s",
                "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp"));
        double tongThue = 0;
        for (Vehicle v : ds) {
            System.out.println(v);
            tongThue += v.tax();
        }

        System.out.println(String.format("\nTổng tiền thuế: %.2f", tongThue));

        sc.close();
    }
}
