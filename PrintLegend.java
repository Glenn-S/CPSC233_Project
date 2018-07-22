public class PrintLegend {
/*this class print legends to the console when it's called.
 *
 *
 *@version 		20.39   19  July 2018
 * @author    		Yuhui  Yan
 *
 */

	public void legend(){
		System.out.println("You                   *");
		System.out.println("Enemry                +");
		System.out.println("Sign Post             ^");
		System.out.println("Object(Chest)         #");
		System.out.println("Vertical Edge         |");
		System.out.println("Horizontal Edge       -");
		System.out.println("Diagonal Edge         /");
	}

	/*------------------------------ TESTS -----------------------------------*/
	public static void main(String[] args) {
		PrintLegend pl = new PrintLegend();
		pl.legend();
	}
}
