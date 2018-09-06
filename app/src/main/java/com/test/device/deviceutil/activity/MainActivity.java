package com.test.device.deviceutil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.test.device.deviceutil.R;
import com.test.device.deviceutil.util.DeviceMessageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.resolution)
    Button resolution;
    @BindView(R.id.brand)
    Button brand;
    @BindView(R.id.device_name)
    Button deviceName;
    @BindView(R.id.imei_imsi)
    Button imeiImsi;
    @BindView(R.id.card_number)
    Button cardNumber;
    @BindView(R.id.android_id)
    Button androidId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.resolution, R.id.brand, R.id.device_name, R.id.imei_imsi, R.id.card_number, R.id.android_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.resolution:
                resolution.setText(DeviceMessageUtil.getResolution(this));
                break;
            case R.id.brand:
                brand.setText(DeviceMessageUtil.getBrand());
                break;
            case R.id.device_name:
                deviceName.setText(DeviceMessageUtil.getDeviceName());
                break;
            case R.id.imei_imsi:
                imeiImsi.setText(DeviceMessageUtil.getEI_SI("",this));
                break;
            case R.id.card_number:
                cardNumber.setText(DeviceMessageUtil.getCard1Number(this));
                break;
            case R.id.android_id:
                androidId.setText(DeviceMessageUtil.getAndroidId(this));
                break;
        }
    }
}
