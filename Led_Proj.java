import parport.ParallelPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Led_Proj {
	public static void main(String[] args){
		ParallelPort lpt1 = new ParallelPort(0x378);

		String s = "n";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){			
			// Input
			System.out.println("Ligar, Desligar ou Sair?(l/d/s)");
			try{
				s = br.readLine();
			}catch(Exception e){}

			if(s.equals("l")){
				// Liga o Led
				lpt1.write(1);
				System.out.println("Led Ligado!");
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
			} else if(s.equals("d")){
				// Desliga o Led
				lpt1.write(0);
				System.out.println("Led Desligado!");
                        	try{
                                	Thread.sleep(1000);
                        	}catch(Exception e){}
			} else if(s.equals("s")){
				lpt1.write(0);
				System.exit(0);
			}
		}
	}
}
