package punkty;

public class Shooter {
	private String name;
	private String surname;
	private String pesel;
	private int numberOfShots;
	private int[] attempts;
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	public String getSurname()
	{
		return surname;
	}
	public void setPesel(String pesel)
	{
		this.pesel=pesel;
	}
	public String getPesel()
	{
		return pesel;
	}
	public void setNumberOfShots(int numberOfShots)
	{
		this.numberOfShots=numberOfShots;
	}
	public int getNumberOfShots()
	{
		return numberOfShots;
	}
	public void setAttempts(int[] shotsNumber)
	{
		this.attempts=shotsNumber;
	}
	public int[] getAttempts()
	{
		return attempts;
	}
	public double calculateResult()
	{
		double result=0;
		double average=0;
		for(int i=0;i<attempts.length ;i++)
		{
			result +=attempts[i];
		}
		average = result/attempts.length;
		return average;
	}
}
