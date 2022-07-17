public class VokalKonsonan {    
	public static void main(String[] args) {    
		//Buat variabel awal untuk hitun berapa yang vokal dan konsonan
		int vokalCount = 0, konsonanCount = 0;    

		//Deklarasi Input   
		String inputKalimat = "Alterra Indonesia";    

		//Ubah input menjadi huruf kecil semua  
		inputKalimat = inputKalimat.toLowerCase();    

		//Perulangan
		for(int i = 0; i < inputKalimat.length(); i++) {    
			//Periksa apakah karakter merupakan vokal aiueo   
			if(inputKalimat.charAt(i) == 'a' || inputKalimat.charAt(i) == 'e' || 
					inputKalimat.charAt(i) == 'i' || inputKalimat.charAt(i) == 'o' || 
					inputKalimat.charAt(i) == 'u') {    
				//Tambah jumlah hitungan vokal apabila karakter huruf vokal   
				vokalCount++;    
			}    
			//Periksa apakah karakter merupakan vokal konsonan    
			else if(inputKalimat.charAt(i) >= 'a' && inputKalimat.charAt(i)<='z') {      
				//Tambah jumlah hitungan konsonan apabila karakter huruf konsonan  
				konsonanCount++;    
			}    
		}    
		System.out.println("Jumlah Vokal : " + vokalCount);    
		System.out.println("Jumlah Konsonan : " + konsonanCount);   
		System.out.println("Total Karakter : " + (vokalCount+konsonanCount));   
	}    
}   