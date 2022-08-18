class Fish{
    private String type;
    private String feed;

    //Getter and Setter methods
    public String getType(){
        return type;
    }

    public void setType(String newValue){
        type = newValue;
    }

    public String getFeed(){
        return feed;
    }

    public void setFeed(String newValue){
        feed = newValue;
    }
}
public class C1EncapsBinatangFish{
    public static void main(String args[]){
         Fish obj = new Fish();
         obj.setType("paus");
         obj.setFeed("plankton");
         System.out.print("saya Ikan dengan detail, ");
		 System.out.print("Jenis: " + obj.getType());
         System.out.println(", makanan: " + obj.getFeed());
         
         obj.setType("cupang");
         obj.setFeed("cacing");
         System.out.print("saya Ikan dengan detail, ");
		 System.out.print("Jenis: " + obj.getType());
         System.out.println(", makanan: " + obj.getFeed());

         obj.setType("arwana");
         obj.setFeed("jangkrik");
         System.out.print("saya Ikan dengan detail, ");
		 System.out.print("Jenis: " + obj.getType());
         System.out.println(", makanan: " + obj.getFeed());

         obj.setType("sapu-sapu");
         obj.setFeed("pelet");
         System.out.print("saya Ikan dengan detail, ");
		 System.out.print("Jenis: " + obj.getType());
         System.out.println(", makanan: " + obj.getFeed());
    } 
}