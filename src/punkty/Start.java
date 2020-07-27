package punkty;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
	         Shooter[] shooters = getShooter();
             printShooters(shooters);
             save(shooters);
	}
	
	public static Shooter[] getShooter()
	{
		Scanner skaner = new Scanner(System.in);
		
		System.out.println("Podaj ilość strzelców");
		int shootersNumber= skaner.nextInt();
		Shooter[] shooters= new Shooter[shootersNumber];
		String pesel;
		
		for(int i=0;i<shootersNumber;i++)
		{	
			//Name & Surname
			Shooter shooter= new Shooter();
			System.out.println("Podaj imie");
			shooter.setName(skaner.next());
			System.out.println("Podaj nazwisko");
			shooter.setSurname(skaner.next());
			
			//PESEL
			System.out.println("Podaj PESEL:");
			pesel=skaner.next();
			while(pesel.length()<11 || pesel.length()>11)
			{
				System.out.println("Podano nieprawidłowy numer PESEL. \nPodaj poprawny numer:");
				pesel=skaner.next();
			}
			shooter.setPesel(pesel);
			
			// Number of shots and result
			System.out.println("Podaj liczbę strzałów");
			int numberOfShots = skaner.nextInt();
			shooter.setNumberOfShots(numberOfShots);
			
			int[] attempts = new int[numberOfShots];
			int result=0;
			for (int n=0;n<numberOfShots;n++)
			{
				System.out.println("Podaj wynik strzału nr " + n);
				result=skaner.nextInt();
				while(result>10 || result<1)
				{
					System.out.println("Podano nieprawidłowy wynik strzału.\nPodaj prawidłową wartość: ");
					result=skaner.nextInt();
				}
				attempts[n]=result;
			}
			shooter.setAttempts(attempts);
			
			shooters[i]=shooter;
		}
		return shooters;
	}
	public static void printShooters(Shooter[] shooters)
	{	
		int i =1;
		for(Shooter shooter : shooters)
		{
			System.out.println("Strzelec nr "+ i + " " + shooter.getName() + " " + shooter.getSurname() + " Liczba strzałów: " + shooter.getNumberOfShots() + " Wynik: "+ shooter.calculateResult());
			i++;
		}
	}
	
	public static void save(Shooter[] shooters)
	{
		Scanner skaner = new Scanner(System.in);
		String answer;
		String file_name;
		
		try {
			System.out.println("Czy chcesz zapisać dane do pliku? [tak/nie]");
			answer=skaner.nextLine().toLowerCase();
		
				if (answer.equals("tak")){
					SaveToTxt save = new SaveToTxt();
					System.out.println("Podaj nazwę pliku np. 'nowy.txt'");
					file_name = skaner.next();
					save.setPath(file_name);
					
					int i =1;
					
					for(Shooter shooter : shooters) 
					{
						save.writeToFile("Strzelec nr "+ i + " " + shooter.getName() + " " + shooter.getSurname() + " Liczba strzałów: " + shooter.getNumberOfShots() + " Wynik: "+ shooter.calculateResult());
						i++;
					}
				
				}else if (answer.equals("nie")){
					System.out.println("Koniec");
			
				}else {
					System.out.println("Podano złą odpowiedz");
				}
			skaner.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
}	

