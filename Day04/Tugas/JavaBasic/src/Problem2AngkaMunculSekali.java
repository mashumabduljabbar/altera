import java.io.IOException;
import java.util.ArrayList;
public class Problem2AngkaMunculSekali 
{

	public static void main(String[] args) throws IOException
	{
		ArrayList<String> angkaMuncul = new ArrayList<String>();
		String ch = "76523752";
		int count=0,len=0;
		do
		{  
			try
			{
				char name[]=ch.toCharArray();
				len=name.length;
				count=0;
				for(int j=0;j<len;j++)
				{
					if((name[0]==name[j]))
						count++;
				}
				if(count==1) {
					angkaMuncul.add(String.valueOf(name[0]));
				}
				ch=ch.replace(""+name[0],"");
			}
			catch(Exception ex){}
		}
		while(len!=ch.length());
		System.out.println(angkaMuncul);
	}

}