package demo.magick.android.lib.magickdemo;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import magick.ColorspaceType;
import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import magick.util.MagickBitmap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            loadImage();
        } catch (MagickException e) {
            e.printStackTrace();
        }
    }

    private void loadImage() throws MagickException {
        String extStorageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/cmyk_sample.jpg";
        ImageInfo info = new ImageInfo(extStorageDirectory);
        MagickImage imageCMYK = new MagickImage(info);
        imageCMYK.transformRgbImage(ColorspaceType.CMYKColorspace);
        Bitmap bitmap = MagickBitmap.ToBitmap(imageCMYK);

        ((ImageView)findViewById(R.id.ivSample)).setImageBitmap(bitmap);
    }
}
