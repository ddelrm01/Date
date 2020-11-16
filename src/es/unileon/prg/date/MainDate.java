package es.unileon.prg.date;
//
public class MainDate { 
    public static void main(String[] args) {

        Date today;
        try {
            System.out.println("Dame un dia");
			int day = Teclado.readInteger();
			System.out.println("Dame un mes");
			int month = Teclado.readInteger();
			System.out.println("Dame un anyo");
			int year = Teclado.readInteger();

			today = new Date(day, month, year);

			System.out.println(today.toString());
		
      } catch (DateException e) {
          System.out.println(e.getMessage());
    }
}
}