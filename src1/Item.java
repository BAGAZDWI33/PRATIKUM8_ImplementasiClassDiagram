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


