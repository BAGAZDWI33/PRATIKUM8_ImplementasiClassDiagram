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
