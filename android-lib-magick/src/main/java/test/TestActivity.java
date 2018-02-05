package test;

import java.io.File;
import java.io.FileOutputStream;

import fakeawt.Rectangle;

import magick.ColorspaceType;
import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import magick.util.MagickBitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

public class TestActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		try {
			loadImage();
			((TextView)findViewById(R.id.txtStatus)).setText("OK");
		} catch (MagickException e) {
			((TextView)findViewById(R.id.txtStatus)).setText("NOT_OK");
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