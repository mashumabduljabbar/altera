class Palindrome {
	public static boolean isPalindrome(String str)
	{
		// Inisialisasi string untuk menyimpan kebalikan kata
		String kebalikan = "";

		// Inisialisasi variable Boolean untuk jawaban
		boolean jawaban = false;

		for (int i = str.length() - 1; i >= 0; i--) {
			kebalikan = kebalikan + str.charAt(i);
		}

		// Periksa apkah kedua strings sama nilanya
		if (str.equals(kebalikan)) {
			jawaban = true;
		}
		return jawaban;
	}
	public static void main(String[] args)
	{
		String str = "mister";
		str = str.toLowerCase();
		boolean Cek = isPalindrome(str);
		if(Cek) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Bukan Palindrome");
		}
	}
}
