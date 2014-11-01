/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/27/14
 */

import java.io.InputStream;
import java.io.OutputStream;


final public class ResourceLoader
{
	static String path;
	
	public static InputStream load (String path)
	{
		ResourceLoader.path = path;
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		
		if (input == null)
		{
			input = ResourceLoader.class.getResourceAsStream("/" + path);
		}
		return input;
	}
	
	public static String getPath()
	{
		System.out.println("Resource loader: " + ResourceLoader.path);
		return ResourceLoader.path;
	}
}