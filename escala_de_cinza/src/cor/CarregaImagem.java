package cor;
import java.lang.String;  

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class CarregaImagem {
    public static void main( String[] args ) {
    	new CarregaImagem().carregar();
    }
    public void carregar() {
    	try {
    		File file = new File("imagem1.jpg");
    		BufferedImage img = ImageIO.read( file );
    		//System.out.println("oi");
    		int aux2 = img.getHeight();
    		int aux1 = img.getWidth();
    		Color c, nc;
    		for (int i = 0; i < aux1; i++ ) {
    			for ( int j = 0; j < aux2; j++ ) {
    				c = new Color( img.getRGB( i, j ) );
    				int r = c.getRed();
    				int g = c.getGreen();
    				int b = c.getBlue();
    				int m = (r+g+b)/3;
    				nc = new Color(m,m,m);
    				img.setRGB(i, j, nc.getRGB());
    				System.out.print( nc + " " );
    			}
    			System.out.println();
    		}
    		File outputfile = new File("saida1.jpg");
    		ImageIO.write(img, "jpg", outputfile);
    	} catch ( IOException exc ) {
    		exc.printStackTrace();
    	}
    }
}