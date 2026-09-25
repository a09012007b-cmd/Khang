import java.util.Scanner;

public class TinhDienTich {

    public static double tinhDienTichHCN(double chieuDai, double chieuRong) {
        return chieuDai * chieuRong;
    }

    public static double tinhDienTichHinhTron(double banKinh) {
        return Math.PI * banKinh * banKinh;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        double chieuDai = scanner.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double chieuRong = scanner.nextDouble();
        double dienTichHCN = tinhDienTichHCN(chieuDai, chieuRong);
        System.out.printf("=> Dien tich hinh chu nhat: %.2f\n\n", dienTichHCN);
        System.out.print("Nhap ban kinh: ");
        double banKinh = scanner.nextDouble();
        double dienTichHinhTron = tinhDienTichHinhTron(banKinh);
        System.out.printf("=> Dien tich hinh tron: %.2f\n", dienTichHinhTron);
        scanner.close();
    }
}