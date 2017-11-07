
public class DatePal {
	static int tag = 0;
	static int monat = 0;

	public static boolean pruefen(String s) {
		String umgekehrt = new String();

		for (int j = s.length() - 1; j >= 0; j--) {
			umgekehrt += s.charAt(j);
		}
		if (s.equals(umgekehrt)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void durchgehen(int startJahr, int endJahr){
		String date;
		int zaehler = 0;
		monat = 1;
		while (startJahr < endJahr){
			tag++;
			if ((tag == 31 && (monat == 9 || monat == 11)) || (tag == 32 && (monat == 10 || monat == 12)) || (tag == 32 && monat % 2 == 1 && monat != 9 && monat != 11 ) || (tag == 31 && monat % 2 == 0 && monat != 8 && monat != 10 && monat != 12) || (tag == 32 && monat == 8) || (tag == 29 && monat == 2 && startJahr % 4 != 0) || (tag == 30 && monat == 2 && startJahr % 4 == 0) ){
				monat++;
				tag = 1 ;
			}
			if (monat > 12){
				startJahr ++;
				monat = 1;
			}
			date = Integer.toString(startJahr) + Integer.toString(monat) + Integer.toString(tag);
			if (pruefen(date) == true){
				zaehler++;
				System.out.println("Folgendes Datum ist ein Palindrom: " + startJahr + "/" + monat + "/" + tag + " - " + date);
			}
			
		}
		System.out.println("Anzahl: " + zaehler);
	}

	public static void main(String[] args) {
		durchgehen(2000, 2100); 
	}
}
