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
