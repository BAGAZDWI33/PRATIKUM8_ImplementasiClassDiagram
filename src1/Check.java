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
