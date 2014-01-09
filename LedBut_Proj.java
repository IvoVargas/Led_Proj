import parport.ParallelPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LedBut_Proj{
	public static void main(String[] args){
		ParallelPort lpt1 = new ParallelPort(0x378);

		Boolean ligado = false;
		Boolean butCarregado = false;

		// Input
		System.out.println("\nSair!!(Ctrl-Z)");

		while(true){
			if(lpt1.read() != 63 && butCarregado == true){
				if(ligado){
					// Liga o Led
					lpt1.write(1);
					System.out.print("** Led Ligado! **   " + "\r");
					butCarregado = false;
				} else {
					// Desliga o Led
					lpt1.write(0);
					System.out.print("** Led Desligado! **" + "\r");
					butCarregado = false;
                        	}
			} else if(lpt1.read() == 63 && butCarregado == false){
				ligado = !ligado;
				butCarregado = true;
			}
		}
	}
}
