package com.example.qrcodeattendencesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

public class Scan extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView Scanview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Scanview = new ZXingScannerView(this);
        setContentView(Scanview);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) {


            int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

            if (permission == PackageManager.PERMISSION_GRANTED) {

                Scanview = new ZXingScannerView(this);
                setContentView(Scanview);
                Scanview.setResultHandler(this);

            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
            }

        }

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case 0:

                if (  grantResults[0] == PackageManager.PERMISSION_GRANTED)

                    Scanview = new ZXingScannerView(this);
                    setContentView(Scanview);
                    Scanview.setResultHandler(this);

                break;

        }

    }

    @Override
    public void handleResult(Result result) {

        if (!result.equals(null)){



            Intent intent =  new Intent(this,UpdateAttendence.class);
            intent.putExtra("ID",result.getText());
            startActivity(intent);



        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Scanview.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Scanview.setResultHandler(this);
        Scanview.startCamera();
    }
}
