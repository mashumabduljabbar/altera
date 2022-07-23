class Flower{
    private String nama;
    private String color;
    private int num_of_petal;

    //Getter and Setter methods
    public String getNama(){
        return nama;
    }

    public void setNama(String newValue){
        nama = newValue;
    }
	
    public String getColor(){
        return color;
    }

    public void setColor(String newValue){
        color = newValue;
    }

    public int getNum_of_petal(){
        return num_of_petal;
    }

    public void setNum_of_petal(int newValue){
        num_of_petal = newValue;
    }
}
public class C1EncapsTumbuhanFlower{
    public static void main(String args[]){
         Flower obj = new Flower();
         obj.setNama("bangkai");
         obj.setColor("merah");
         obj.setNum_of_petal(12);
         System.out.print("Saya Bunga dengan detail, ");
		 System.out.print("Jenis: " + obj.getNama());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of petal : " + obj.getNum_of_petal());
         
         obj.setNama("anggrek");
         obj.setColor("putih");
         obj.setNum_of_petal(8);
         System.out.print("Saya Bunga dengan detail, ");
		 System.out.print("Jenis: " + obj.getNama());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of petal : " + obj.getNum_of_petal());

         obj.setNama("mawar");
         obj.setColor("merah");
         obj.setNum_of_petal(3);
         System.out.print("Saya Bunga dengan detail, ");
		 System.out.print("Jenis: " + obj.getNama());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of petal : " + obj.getNum_of_petal());
         
         obj.setNama("melati");
         obj.setColor("kuning");
         obj.setNum_of_petal(5);
         System.out.print("Saya Bunga dengan detail, ");
		 System.out.print("Jenis: " + obj.getNama());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of petal : " + obj.getNum_of_petal());
    } 
}