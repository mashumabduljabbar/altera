import java.util.ArrayList;
import java.util.Iterator;
public class Problem1ArrayMerge {
	public static void main(String[] args) {
		ArrayList<String> namaDuplikat = new ArrayList<String>();
		String[] arrayNama1 = {"kazuya", "jin", "lee"};
		String[] arrayNama2 = {"kazuya", "feng"};
		for(String text:arrayNama1) {
			namaDuplikat.add(text);
		}
		for(String text:arrayNama2) {
			namaDuplikat.add(text);
		}
		ArrayList<String> namaNonDuplikat = new ArrayList<String>();
		Iterator<String> duplikatIterasi = namaDuplikat.iterator();
		while(duplikatIterasi.hasNext())
		{
			String kataDuplikat = duplikatIterasi.next();
			if(namaNonDuplikat.contains(kataDuplikat))
			{
				duplikatIterasi.remove();
			}else
			{
				namaNonDuplikat.add(kataDuplikat);
			}
		}
		System.out.println(namaNonDuplikat);
	}
}