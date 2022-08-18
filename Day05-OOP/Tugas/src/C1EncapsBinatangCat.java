class Cat{
    private String fun_color;
    private int num_of_leg;

    //Getter and Setter methods
    public String getFun_color(){
        return fun_color;
    }

    public void setFun_color(String newValue){
        fun_color = newValue;
    }

    public int getNum_of_leg(){
        return num_of_leg;
    }

    public void setNum_of_leg(int newValue){
        num_of_leg = newValue;
    }
}
public class C1EncapsBinatangCat{
    public static void main(String args[]){
         Cat obj = new Cat();
         obj.setFun_color("Hitam");
         obj.setNum_of_leg(4);
         System.out.print("Saya Kucing dengan detail, ");
		 System.out.print("Warna Bulu: " + obj.getFun_color());
         System.out.println(" dengan jumlah kaki : " + obj.getNum_of_leg());
         
         obj.setFun_color("Putih");
         obj.setNum_of_leg(3);
         System.out.print("Saya Kucing dengan detail, ");
		 System.out.print("Warna Bulu: " + obj.getFun_color());
         System.out.println(" dengan jumlah kaki : " + obj.getNum_of_leg());

         obj.setFun_color("Hitam Putih");
         obj.setNum_of_leg(4);
         System.out.print("Saya Kucing dengan detail, ");
		 System.out.print("Warna Bulu: " + obj.getFun_color());
         System.out.println(" dengan jumlah kaki : " + obj.getNum_of_leg());

         obj.setFun_color("Poleng poleng");
         obj.setNum_of_leg(3);
         System.out.print("Saya Kucing dengan detail, ");
		 System.out.print("Warna Bulu: " + obj.getFun_color());
         System.out.println(" dengan jumlah kaki : " + obj.getNum_of_leg());

         obj.setFun_color("bintik bintik");
         obj.setNum_of_leg(4);
         System.out.print("Saya Kucing dengan detail, ");
		 System.out.print("Warna Bulu: " + obj.getFun_color());
         System.out.println(" dengan jumlah kaki : " + obj.getNum_of_leg());
    } 
}