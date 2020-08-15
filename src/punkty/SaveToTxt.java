package punkty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;

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
            BufferedWriter bfwriter = new BufferedWriter(writer);
            bfwriter.write(text);
            bfwriter.newLine();
            bfwriter.flush();
            output.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
