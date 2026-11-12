package baitapjava;

public class CDList {

    private CD[] ds;
    private int count;

    // Constructor
    public CDList(int n) {
        ds = new CD[n];
        count = 0;
    }
    
    private void moRong() {
        int kichThuocMoi = ds.length + ds.length / 2;

        // Tránh trường hợp mảng quá nhỏ
        if (kichThuocMoi == ds.length) {
            kichThuocMoi++;
        }

        CD[] dsMoi = new CD[kichThuocMoi];

        for (int i = 0; i < count; i++) {
            dsMoi[i] = ds[i];
        }

        ds = dsMoi;
    }

    // Them CD
    public boolean themCD(CD cd) {

        // Kiem tra trung ma
        for (int i = 0; i < count; i++) {
            if (ds[i].getMa() == cd.getMa()) {
                return false;
            }
        }

        // Neu gan day thi mo rong
        if (count >= ds.length * 0.8) {
            moRong();
        }

        ds[count] = cd;
        count++;

        return true;
    }

    // So luong CD
    public int soLuongCD() {
        return count;
    }
    

    // Tong gia thanh
    public float tongGiathanh() {
        float tongGia = 0;

        for (int i = 0; i < count; i++) {
            tongGia += ds[i].getGiathanh();
        }

        return tongGia;
    }

    // Xuat danh sach
    public void xuatDanhSach() {
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }

    // Sap xep giam dan theo gia
    public void sapXepGiamDanTheoGia() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {

                if (ds[i].getGiathanh() < ds[j].getGiathanh()) {

                    CD temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }

    // Sap xep tang dan theo tua
    public void sapXepTangDanTheoTua() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {

                if (ds[i].getTua().compareToIgnoreCase(ds[j].getTua()) > 0) {

                    CD temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }

    // Tim theo tien to
    public void timTheoTienTo(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < count; i++) {
            if (ds[i].getTua().toLowerCase()
                    .startsWith(tuKhoa.toLowerCase())) {

                System.out.println(ds[i]);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay CD!");
        }
    }

    // Tim theo hau to
    public void timTheoHauTo(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < count; i++) {
            if (ds[i].getTua().toLowerCase()
                    .endsWith(tuKhoa.toLowerCase())) {

                System.out.println(ds[i]);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay CD!");
        }
    }

    // Tim gan giong
    public void timGanGiong(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < count; i++) {
            if (ds[i].getTua().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {

                System.out.println(ds[i]);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay CD!");
        }
    }

    // Xoa CD theo ma
    public boolean xoaCD(int ma) {
        int viTri = -1;

        for (int i = 0; i < count; i++) {
            if (ds[i].getMa() == ma) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            return false;
        }

        for (int i = viTri; i < count - 1; i++) {
            ds[i] = ds[i + 1];
        }

        ds[count - 1] = null;
        count--;

        return true;
    }

    // Sua CD
    public boolean suaCD(int ma, String tua, int sbh, float gia) {

        for (int i = 0; i < count; i++) {

            if (ds[i].getMa() == ma) {

                ds[i].setTua(tua);
                ds[i].setSbh(sbh);
                ds[i].setGt(gia);

                return true;
            }
        }

        return false;
    }

    // Gia trung binh
    public float giaTrungBinh() {
        if (count == 0) {
            return 0;
        }

        return tongGiathanh() / count;
    }

    // Thong ke
    public void thongKe() {
        System.out.println("So luong CD: " + soLuongCD());
        System.out.println("Tong gia thanh: " + tongGiathanh());
        System.out.println("Gia trung binh: " + giaTrungBinh());
    }
}
