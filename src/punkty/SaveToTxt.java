package punkty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SaveToTxt {
	
	private String path;

	public void setPath(String path)
	{
		this.path=path;
	}
	public String getPath()
	{
		return path;
	}
	public void writeToFile(String text)
    {
		try {
			File file = new File(path);
            
            OutputStream output = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(output);
            writer.write(text);
            writer.flush();
            output.close();
            System.out.println("Zapisywanie zakończone sukcesem");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
