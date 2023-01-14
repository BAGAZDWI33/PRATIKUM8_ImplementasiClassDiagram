package Praktikum8;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String pilih;
        Scanner masukan = new Scanner(System.in);

        // membuat object orderan pada pada kelas Order
        Order orderan1 = new Order(121123,"Menunggu Pembayaran",new OrderDetail("5%"));
        Cash COD = new Cash(10000,0);
        Credit Ngutang = new Credit(10000F," 12121212828362863826"," Credit");
        Check PC = new Check(10000,"BCI","1212121212");

        // object OrderDetail
        OrderDetail barang = new OrderDetail("5%");
        barang.setQuantity(new Item("harga barang           : 10000", (float) 2));

        // List data customer menggunakan setter
        orderan1.setDataCustomer(new Customer("Prasetyo","Tegal,Jawa Tengah,12255"));

        /* callmethod menggunakan for dan Arrsday.asList pada infoOrderan
         beserta operasi class lain
         */
        orderan1.infoOrderan();
        orderan1.SubTotal();
        orderan1.TotalWeight();
        orderan1.Total();
        barang.calcSubTotal();
        barang.calcWeight();
        orderan1.calcTax();

        System.out.println("=== PILIH METODE PEMBAYARAN====");
        System.out.println("Cash");
        System.out.println("Check");
        System.out.println("Credit");
        masukan.next();
        pilih = masukan.next();

        switch (pilih) {
            case "Cash" -> {
                System.out.println("cash On Delivery");
                COD.Pembayaran();
                System.out.println("Bayar ketika menerima barang yaa");
            }
            case "Credit" -> {
                System.out.println("Paylatter");
                Ngutang.Pembayaran();
                System.out.println("jangan telat bayar yaa");
            }

            case "Check" -> {
                System.out.println("Masukan Nama bank");
                PC.Pembayaran();

                System.out.println("Terima kasih");

            }
        }

    }
}
