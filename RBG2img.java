/*
Ajin-Abraham
@ajinabraham
www.ajinabraham.com
*/
import javax.swing.*;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RBG2img extends JFrame
{
    int width = 500;
    int height = 500;
    int imageSize = width * height * 3;

    public RBG2img()
    {
        JPanel panel = new JPanel();
        getContentPane().add( panel );
        ArrayList pixels = new ArrayList();
            
try{
  FileInputStream fstream = new FileInputStream("dump.txt");
   DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  while ((strLine = br.readLine()) != null)   {

StringTokenizer stringtokenizer = new StringTokenizer(strLine, ",");
while (stringtokenizer.hasMoreElements()) 
{
  pixels.add(Integer.parseInt(stringtokenizer.nextToken()));
} 
}
 in.close();
  }
catch (Exception e)
   {
 System.err.println("Error: " + e.getMessage());
  }
  int[] arr = new int[pixels.size()];

for(int i = 0; i < pixels.size(); i++) {
    if (pixels.get(i) != null) 
    {
        arr[i] = (int) pixels.get(i);
    }
}

panel.add( createImageLabel(arr) );

    }

    private JLabel createImageLabel(int[] pixels)
    {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = image.getRaster();
        raster.setPixels(0, 0, width, height, pixels);
        JLabel label = new JLabel( new ImageIcon(image) );
        return label;
    }

    public static void main(String args[])
    {
        JFrame frame = new RBG2img();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}
