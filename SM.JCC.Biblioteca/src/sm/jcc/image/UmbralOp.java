package sm.jcc.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author jcc
 */
public class UmbralOp extends BufferedImageOpAdapter
{
    private final int umbral;
    
    public UmbralOp(int u)
    {
        this.umbral = u;
    }

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("La imagen fuente es nula.");
        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);

        Color pixelColor;
        float actualRGB;
        for (int x = 0; x < src.getWidth(); x++)
        {
            for (int y = 0; y < src.getHeight(); y++)
            {
                pixelColor = new Color(src.getRGB(x, y));
                actualRGB = (pixelColor.getRed() + pixelColor.getGreen() + pixelColor.getBlue())/3f;
                
                if(actualRGB < this.umbral)
                    dest.setRGB(x, y, Color.BLACK.getRGB());
                else
                    dest.setRGB(x, y, Color.WHITE.getRGB());
            }
        }
        
        return dest;
    }
    
}
