package rotacao;
import java.io.File;

public class rotacionarImagem {

	public static void main(String[] args) {
		File file = new File("imagem.jpg");
        Picture img1 = new Picture(file);
        int aux1  = img1.width();
        int aux2 = img1.height();
        
        double angulo = Math.toRadians(17); //so modificar o angulo
        double sin = Math.sin(angulo);
        double cos = Math.cos(angulo);
        double x = 0.5 * (aux1  - 1);  
        double y = 0.5 * (aux2 - 1); 

        Picture img2 = new Picture(aux1, aux2);
        for (int i = 0; i < aux1; i++) {
            for (int j = 0; j < aux2; j++) {
                double a = i - x; 
                double b = j - y;
                int x_novo = (int) (+a * cos - b * sin + x);
                int y_novo = (int) (+a * sin + b * cos + y);
   
                if ( x_novo>= 0 && x_novo < aux1 && y_novo >= 0 && y_novo < aux2) {
                    img2.set(i, j, img1.get(x_novo, y_novo));
                }
            }
        }
        img2.save("saida.jpg");
    }

}

