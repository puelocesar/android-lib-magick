package teste.ndk;

import java.io.File;
import java.io.FileOutputStream;

import fakeawt.Rectangle;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import android.app.Activity;
import android.os.Bundle;

public class TesteNdkActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        try {
			ImageInfo i = new ImageInfo("/sdcard/DCIM/Camera/IMG_20120226_230240.jpg");
			MagickImage m = new MagickImage(i);
			
			int newHeight = (int) ((640/(float)m.getWidth()) * m.getHeight());
			m = m.scaleImage(640, newHeight);
			m = m.cropImage(new Rectangle((640-480)/2, 0, 480, 480));
			m = m.charcoalImage(0.5, 0.5);
			
			try {
				byte blob[] = m.imageToBlob(i);
				FileOutputStream fos = new FileOutputStream(new File("/sdcard/foto_teste.jpg"));
				fos.write(blob);
				fos.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} 
        catch (MagickException e) {
			e.printStackTrace();
		}
    }
}