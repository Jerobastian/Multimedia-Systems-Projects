package sm.jcc.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import sm.image.*;

/**
 *
 * @author jcc
 */
public class SepiaOp extends BufferedImageOpAdapter
{
    public SepiaOp()
    {
        
    }

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("La imagen fuente es nula.");
        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);

        Color sepiaColor;
        Color pixelColor;
        for (int x = 0; x < src.getWidth(); x++)
        {
            for (int y = 0; y < src.getHeight(); y++)
            {
                pixelColor = new Color(src.getRGB(x, y));
                sepiaColor = new Color
                (
                    min(255, (int)(0.393 * pixelColor.getRed() + 0.769 * pixelColor.getGreen() + 0.189 * pixelColor.getBlue())),
                    min(255, (int)(0.349 * pixelColor.getRed() + 0.686 * pixelColor.getGreen() + 0.168 * pixelColor.getBlue())),
                    min(255, (int)(0.272 * pixelColor.getRed() + 0.534 * pixelColor.getGreen() + 0.131 * pixelColor.getBlue())) 
                );
                dest.setRGB(x, y, sepiaColor.getRGB());
            }
        }
        
        return dest;
    }
}
