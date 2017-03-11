import java.util.InputMismatchException;

public class Program {
	public static void main(String[] args) {
		while(true){
			System.out.print("Bitte eine Eingabe machen: ");
			String Input = Terminal.readLine();
			if(Input.equals("exit")){
				System.exit(0);
			}
			else if (Input.equalsIgnoreCase("Morse")){
				Terminal.printLine("Morse Erkennung gestartet.");
				MorseCode mc = new MorseCode();
				Input = Terminal.readLine();
				if(!Input.isEmpty()){
					Terminal.printLine(mc.getFrequency(Input));
				}
			}
			else if(Input.equalsIgnoreCase("Passwort")){
				Terminal.printLine("Passwort Erkennung gestartet.");
				Passwort p1 = new Passwort();
				while(true){
					Input = Terminal.readLine();
					if(Input.equals("")){
						break;
					}
					else{
						p1.addCharArray(Input.toCharArray());
					}
				}
				String[] f = p1.getWords();
				for(int i = 0; i<f.length; i++){
					System.out.println(f[i]);
				}
			}
			else if(Input.equalsIgnoreCase("Kabel1")){
				Terminal.printLine("Komplizierte Kabel Erkennung gestartet.");
				System.out.print("Seriennummer=");
				String s = Terminal.readLine();
				System.out.print("Port=");
				String p = Terminal.readLine();
				System.out.print("Batterien=");
				String b = Terminal.readLine();
				boolean _s = false;
				boolean _p = false;
				boolean _b = false;
				if(s.equals("true") || s.equals("1")){
					_s = true;
				}
				if(p.equals("true") || p.equals("1")){
					_p = true;
				}
				if(b.equals("true") || b.equals("1")){
					_b = true;
				}
				KomplizierteKabel kk = new KomplizierteKabel(_s, _p, _b);
				while(true){
					boolean red = false;
					boolean blue = false;
					boolean white = false;
					boolean led = false;
					boolean star = false;
					System.out.println("Kabel=");
					Input = Terminal.readLine();
					if(Input.equals("exit")){
						break;
					}
					else
					{
						char[] c = Input.toCharArray();
						for(int i = 0; i<c.length; i++){
							if(c[i] == 'r'){
								red = true;
							}
							else if(c[i] == 'b'){
								blue = true;
							}
							else if(c[i] == 'w'){
								white = true;
							}
							else if(c[i] == 'l'){
								led = true;
							}
							else if(c[i] == 's'){
								star = true;
							}
						}
						boolean cut = kk.cutCable(red, blue, white, led, star);
						if(cut){
							System.out.println("Cutten");
						}
						else{
							System.out.println("Nicht cutten");
						}
					}
				}
			}
			else if (Input.equalsIgnoreCase("Kabel2"))
			{
				Terminal.printLine("Kabelsequenz Erkennung gestartet.");
				Kabelsequenz seq = new Kabelsequenz();
				while(true)
				{
					String s = Terminal.readLine();
					if(s.length() == 2)
					{
						try
						{
							boolean cut = seq.cutCable(s.charAt(0), s.charAt(1));
							if(cut) Terminal.printLine("Cutten");
							else Terminal.printLine("Nicht cutten");
						}
						catch (InputMismatchException ex)
						{
							Terminal.printLine(ex.getMessage());
						}
					}
					else
					{
						if(s.equalsIgnoreCase("exit")) break;
						else
						{
							Terminal.printLine("Invalid input, try again!");
						}
					}
				}
			}
		}
	}	
}