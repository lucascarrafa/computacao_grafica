package espelhamento_horizontal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class esp_horizontal {

	public static void main(String[] args) throws IOException {
		File file = new File("imagem.jpg");
		BufferedImage img1 = ImageIO.read(file);
		int aux1  = img1.getWidth();
        int aux2 = img1.getHeight();
     
        double y =  (aux2-1);  
        
        BufferedImage img2 = new BufferedImage(aux1, aux2, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < aux1; i++) {
            for (int j = 0; j < aux2; j++) {
                double a = i; 
                double b = j-y;
                int x_novo =  (int) a;
                int y_novo = (int) -b;
   
                
                if ( x_novo>= 0 && x_novo < aux1 && y_novo >= 0 && y_novo < aux2) {
                    img2.setRGB(i, j, img1.getRGB(x_novo, y_novo));
                }
            }
        }
        File outputfile = new File("saida.jpg");
		ImageIO.write(img2, "jpg", outputfile);
    }

}
