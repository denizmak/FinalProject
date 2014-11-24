
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Hyperlink extends JLabel
{
	//private JLabel link;
	public Hyperlink(String name, final String url)
	{
		setText(name);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					Desktop.getDesktop().browse(new URI(url));
				}
				catch (URISyntaxException | IOException ex)
				{
					System.out.println("URL error");
				}
			}
		});
	}
 
}
