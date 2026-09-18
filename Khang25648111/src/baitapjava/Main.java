package baitapjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap suc chua danh sach CD: ");
        int n = sc.nextInt();

        CDList list = new CDList(n);

        int chon;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Them CD(Đầy danh sách tự động mở rộng!3"
            		+ ")");
            System.out.println("2. Xuat danh sach CD");
            System.out.println("3. So luong CD");
            System.out.println("4. Tong gia thanh");
            System.out.println("5. Sap xep giam dan theo gia");
            System.out.println("6. Sap xep tang dan theo tua");
            System.out.println("7. Tim CD theo tien to");
            System.out.println("8. Tim CD theo hau to");
            System.out.println("9. Tim CD gan giong");
            System.out.println("10. Xoa CD theo ma");
            System.out.println("11. Sua CD");
            System.out.println("12. Thong ke");
            System.out.println("0. Thoat");
            System.out.println("===========================");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();

            switch (chon) {

            case 1:
                System.out.print("Nhap ma CD: ");
                int ma = sc.nextInt();
                sc.nextLine();

                System.out.print("Nhap tua CD: ");
                String tua = sc.nextLine();

                System.out.print("Nhap so bai hat: ");
                int sbh = sc.nextInt();

                System.out.print("Nhap gia thanh: ");
                float gia = sc.nextFloat();

                CD cd = new CD(ma, tua, sbh, gia);

                if (list.themCD(cd)) {
                    System.out.println("Them CD thanh cong!");
                } else {
                    System.out.println("Them CD that bai!");
                    System.out.println("Co the danh sach da day hoac trung ma CD.");
                }
                break;

            case 2:
                System.out.println("\n===== DANH SACH CD =====");
                list.xuatDanhSach();
                break;

            case 3:
                System.out.println("So luong CD: "
                        + list.soLuongCD());
                break;

            case 4:
                System.out.println("Tong gia thanh: "
                        + list.tongGiathanh());
                break;

            case 5:
                list.sapXepGiamDanTheoGia();

                System.out.println("Da sap xep giam dan theo gia!");
                list.xuatDanhSach();
                break;

            case 6:
                list.sapXepTangDanTheoTua();

                System.out.println("Da sap xep tang dan theo tua!");
                list.xuatDanhSach();
                break;

            case 7:
                sc.nextLine();

                System.out.print("Nhap tien to can tim: ");
                String tienTo = sc.nextLine();

                list.timTheoTienTo(tienTo);
                break;

            case 8:
                sc.nextLine();

                System.out.print("Nhap hau to can tim: ");
                String hauTo = sc.nextLine();

                list.timTheoHauTo(hauTo);
                break;

            case 9:
                sc.nextLine();

                System.out.print("Nhap tu khoa can tim: ");
                String tuKhoa = sc.nextLine();

                list.timGanGiong(tuKhoa);
                break;

            case 10:
                System.out.print("Nhap ma CD can xoa: ");
                int maXoa = sc.nextInt();

                if (list.xoaCD(maXoa)) {
                    System.out.println("Xoa CD thanh cong!");
                } else {
                    System.out.println("Khong tim thay ma CD!");
                }
                break;

            case 11:
                System.out.print("Nhap ma CD can sua: ");
                int maSua = sc.nextInt();
                sc.nextLine();

                System.out.print("Nhap tua CD moi: ");
                String tuaMoi = sc.nextLine();

                System.out.print("Nhap so bai hat moi: ");
                int sbhMoi = sc.nextInt();

                System.out.print("Nhap gia thanh moi: ");
                float giaMoi = sc.nextFloat();

                if (list.suaCD(maSua, tuaMoi, sbhMoi, giaMoi)) {
                    System.out.println("Sua CD thanh cong!");
                } else {
                    System.out.println("Khong tim thay ma CD!");
                }
                break;

            case 12:
                System.out.println("\n===== THONG KE =====");
                list.thongKe();
                break;

            case 0:
                System.out.println("Ket thuc chuong trinh!");
                break;

            default:
                System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}