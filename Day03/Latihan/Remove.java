import java.util.Arrays;
import java.util.Scanner;   
public class Remove    
{   
	static String removeDuplicate(char str[], int length)   
	{   
		int index = 0;   
		for (int i = 0; i < length; i++)   
		{   
			int j;   
			for (j = 0; j < i; j++)    
			{   
				if (str[i] == str[j])   
				{   
					break;   
				}   
			}   

			if (j == i)    
			{   
				str[index++] = str[i];   
			}   
		}   
		return String.valueOf(Arrays.copyOf(str, index));   
	}   

	public static void main(String[] args)   
	{   
		try (Scanner myObj = new Scanner(System.in)) {
			System.out.println("Masukkan List Angka (Lalu Enter) :");

			String strValue = myObj.nextLine();
			try{
				char str[] = strValue.toCharArray();  
				int len = str.length;   
				String remove = removeDuplicate(str, len);
				
	            int strToInteger = Integer.parseInt(remove);
	            System.out.println(strToInteger);
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
		}   
	}   
}  