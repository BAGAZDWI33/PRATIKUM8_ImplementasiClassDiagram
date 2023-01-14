# PRATIKUM8_ImplementasiClassDiagram

![Screenshot1](https://user-images.githubusercontent.com/92739297/212463488-0653557f-b58a-4cf7-a254-a23fb87d9ac0.png)

gambar diatas adalah hasil dari implementasi class diargam ke code java

dengan 
class cash
package Praktikum8;

public class Cash extends Payment{

    private float cash;

    @Override
    public void Pembayaran(){
        super.Pembayaran();
        System.out.println(cash);
    }

    public Cash(float amount, float cash) {
        super(amount);

    }
}


class check

package Praktikum8;

public class Check extends Payment{

    private String name;
    private String bangID;

    public Check(float amount) {
        super(amount);
    }


    @Override
    public void Pembayaran(){
        super.Pembayaran();
        System.out.println("Nama Bank  = " + name);
        System.out.println("ID Bank    = " +bangID );
    }

    public Check(float amount, String name, String bangID) {
        super(amount);
        this.name = name;
        this.bangID = bangID;

    }
}


class credit

package Praktikum8;

public class Credit extends Payment{

    private String number;
    private String tipe;
    private Order Expdate;


    public void Pembayaran(){

        super.Pembayaran();
        System.out.println("Nomer Pembayaran" + number);
        System.out.println("Tipe pembayran" + tipe);
        System.out.println(getExpdate());

    }

    public Credit(Float amount, String number, String tipe) {
        super(amount);
        this.number = number;
        this.tipe = tipe;
    }

    public Order getExpdate() {
        return Expdate;
    }

    public void setExpdate(Order expdate) {
        Expdate = expdate;
    }
}

class customer

package Praktikum8;

public class Customer {
    private String name;
    private String alamat;

    public String getAlamat() {
        return alamat;
    }

    public String getName() {
        return name;
    }

    public Customer(String name , String alamat){
        this.name = name;
        this.alamat = alamat;
    }
}


class item

package Praktikum8;

public class Item {

    private final float shipingWeight;
    private final String deskripsi;



    //method
    public void inStock(){

        System.out.println("\nDeskripsi              : Sepatu Boots");
        System.out.println("Jumlah barang tersedia : 11");
        System.out.println(getDeskripsi());

    }
    // getter
    public String getDeskripsi() {
        return deskripsi;
    }

    public double getShipingWeight() {
        return shipingWeight;
    }

    public Item(String deskripsi,Float shipingWeight) {
        this.deskripsi = deskripsi;
        this.shipingWeight = shipingWeight;
    }


}


class order

package Praktikum8;

import java.util.Arrays;

public class Order {

    //atribute datacustomer asosiasi dari Class customer
       private Customer dataCustomer;
       private final int date;
       private final String status;
       private OrderDetail jumlah;


       // operasi SubTotal asosiasi dari orderDetail
    public void SubTotal (){
        System.out.println("Proses menghitung sub total");
    }

    // operasi calcTax agregasi pada OrderDetail
    public void calcTax(){

        jumlah.calcTax();

    }

    public void Total(){

        System.out.println("proses menghitung jumlah total keseluruhan");
    }

    public void TotalWeight (){
        System.out.println("Proses menghitung berat");
    }

    // Menggunkan for untuk araylist
       public void infoOrderan(){

           for (String s : Arrays.asList("\n"+"Customer : "+ dataCustomer.getName() , "Alamat   : " + dataCustomer.getAlamat()
                   ,"Tanggal  : " + date, "Status   : " + status+"\n")) {
               System.out.println(s);
           }

       }

       // Setter untuk Membuat data customer
    public void setDataCustomer(Customer dataCustomer) {
        this.dataCustomer = dataCustomer;
    }


    /* karena pada Customer ini menggunakan asosiasi saya tidak membuat object pada constructor,
    namun pada jumlah saya membuat parameter di constructor
     */
    public Order (int date, String status, OrderDetail jumlah){
        this.date = date;
        this.status = status;
        this.jumlah = jumlah;
       }

    }


class orderdetail

package Praktikum8;

public class OrderDetail {
    private Item quantity;
    private final String taxStatus;

    // operator calcSubTotal asosiasi dari class Item
    public void calcSubTotal (){
        quantity.inStock();
    }
    // operator asosiasi dari class Item juga
    public void calcWeight (){
        System.out.println("Berat                  : " + quantity.getShipingWeight() +" kg");
    }

    //operator class ini sendiri
    public void calcTax (){
        System.out.println("pajak                  : " + taxStatus);
    }

    // setter
    public void setQuantity(Item quantity) {
        this.quantity = quantity;
    }

    public OrderDetail(String taxStatus) {
        this.taxStatus = taxStatus;
    }

}

class payment

package Praktikum8;

public abstract class Payment{
    private float amount;

    public void Pembayaran(){

        System.out.println("Jumlah pembayaran  = " + amount);

    }

    public Payment(float amount) {
        this.amount = amount;
    }
}

class main

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


Nama: Bagas Dwi Prasetyo

NIM :312110053

kelas : TI.21.C1