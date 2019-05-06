package sm.jcc.image;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;
import static java.lang.Math.sin;


public class SinOp
{
    public static LookupTable sinFilter(double w)
    {
        w = Math.toRadians(w);
        
        double K = 255.0/sin(Math.toRadians(90.0));
        byte[] lt = new byte[256];

        for (int l = 0; l <= 255; ++l)
            lt[l] = (byte) 
                    (K * Math.abs(Math.sin(Math.toRadians((double) l * w))));
    
        ByteLookupTable slt = new ByteLookupTable(0, lt);
        return slt;
    }
}
