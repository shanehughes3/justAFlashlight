package com.example.shane.flashlight;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean isFlashlightOn;
    private Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isFlashlightOn = false;
    }

    public void toggleLight(View view) {
        if (!isFlashlightOn) {
            try {
                cam = Camera.open();
                Camera.Parameters p = cam.getParameters();
                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                cam.setParameters(p);
                cam.startPreview();
                isFlashlightOn = true;
            } catch(Exception e) {
                Log.e("FlashlightOn", e.getMessage());
            }
        } else {
            cam.stopPreview();
            cam.release();
            isFlashlightOn = false;
        }
    }
}
