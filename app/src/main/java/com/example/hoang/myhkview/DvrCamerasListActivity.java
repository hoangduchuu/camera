package com.example.hoang.myhkview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.hoang.myhkview.hikvision.DvrCamera;
import com.example.hoang.myhkview.hikvision.DvrCameraArrayAdapter;

import java.util.ArrayList;

public class DvrCamerasListActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<DvrCamera> cameras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvr_cameras_list);

        gridView = (GridView) findViewById(R.id.gridview_dvr_camera_list);

        setDummyData();

        DvrCameraArrayAdapter adapter = new DvrCameraArrayAdapter(this, R.layout.gridview_item_dvr_camera, cameras);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DvrCamera item = (DvrCamera) adapterView.getItemAtPosition(position);

                // Only show the full-screen camera preview if it is connected
                if (item.isConnected()) {
                    Intent intent = new Intent(DvrCamerasListActivity.this, DvrCameraFullScreenPreview.class);

                    intent.putExtra(DvrCameraFullScreenPreview.EXTRA_CAMERA_ID, item.getCameraId());
                    intent.putExtra(DvrCameraFullScreenPreview.EXTRA_CAMERA_NAME, item.getName());

                    startActivity(intent);

                    overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
                }
            }
        });

    }

    private void setDummyData() {
        cameras = new ArrayList<>();

        DvrCamera camera1 = new DvrCamera(1, "Camera 1");
//        DvrCamera camera2 = new DvrCamera(2, "Camera 2");
//        DvrCamera camera3 = new DvrCamera(1, "Camera 3");
//        DvrCamera camera4 = new DvrCamera(2, "Camera 4");

        camera1.setIsConnected(true);

        cameras.add(camera1);
//        cameras.add(camera2);
//        cameras.add(camera3);
//        cameras.add(camera4);
    }
}
