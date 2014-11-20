/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/27/14
 */

import java.io.InputStream;


/**The purpose of the ResourceLoaderclass is to provide the correct file path in order to properly load
 * files (images, text files, etc.) in JAR file (executable file)
 * @author Deni
 *
 */
final public class ResourceLoader
{
	static String path;
	
	public static InputStream load (String path)
	{
		ResourceLoader.path = path;
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		
		if (input == null)
		{
			input = ResourceLoader.class.getResourceAsStream(path);
		}
		return input;
	}
	
	
	public static String getPath()
	{
		System.out.println("Resource loader: " + ResourceLoader.path);
		return ResourceLoader.path;
	}
}