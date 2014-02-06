package de.time_lapse_diary.photo;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import de.time_lapse_diary.R;

public class PhotoActivity extends Activity {

    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);

        GridOverlayView gridView = new GridOverlayView(this);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);

        ImageView imgView = new ImageView(this);
        imgView.setImageResource(R.drawable.ic_launcher);
        //setting image position
        imgView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        imgView.setAlpha(80);
        // for newer sdks >10
        // imgView.setAlpha(0.5fs);
        preview.addView(mPreview);
        preview.addView(gridView);
        preview.addView(imgView);
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();              // release the camera immediately on pause event
    }

    private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }

}
