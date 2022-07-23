class Car{
    private String type;
    private String color;
    private int num_of_tire;

    //Getter and Setter methods
    public String getType(){
        return type;
    }

    public void setType(String newValue){
        type = newValue;
    }
	
    public String getColor(){
        return color;
    }

    public void setColor(String newValue){
        color = newValue;
    }

    public int getNum_of_tire(){
        return num_of_tire;
    }

    public void setNum_of_tire(int newValue){
        num_of_tire = newValue;
    }
}
public class C1EncapsKendaraanCar{
    public static void main(String args[]){
         Car obj = new Car();
         obj.setType("sedan");
         obj.setColor("merah");
         obj.setNum_of_tire(4);
         System.out.print("saya mobil dengan detail, ");
		 System.out.print(" Type: " + obj.getType());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of tire : " + obj.getNum_of_tire());
         
         obj.setType("truk");
         obj.setColor("hijau");
         obj.setNum_of_tire(6);
         System.out.print("saya mobil dengan detail, ");
		 System.out.print(" Type: " + obj.getType());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of tire : " + obj.getNum_of_tire());
         
         obj.setType("tronton");
         obj.setColor("coklat");
         obj.setNum_of_tire(12);
         System.out.print("saya mobil dengan detail, ");
		 System.out.print(" Type: " + obj.getType());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of tire : " + obj.getNum_of_tire());
         
         obj.setType("angkot");
         obj.setColor("kuning");
         obj.setNum_of_tire(4);
         System.out.print("saya mobil dengan detail, ");
		 System.out.print(" Type: " + obj.getType());
		 System.out.print(", color: " + obj.getColor());
         System.out.println(", num of tire : " + obj.getNum_of_tire());
    } 
}