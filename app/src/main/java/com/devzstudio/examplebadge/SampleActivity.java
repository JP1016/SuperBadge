package com.devzstudio.examplebadge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.devzstudio.superbadge.SuperBadge;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        SuperBadge sb=findViewById(R.id.badge);
        sb.setImage("https://4.bp.blogspot.com/-Nyfdpymc_Lo/VkQw-nJ79mI/AAAAAAAARYg/6o9VeoTvu-I/s1600-r/logo_chrome.png");
        sb.setPrimaryText("Google Chrome");
        sb.setSecondaryText("Web Browser");

        sb.setOnBageClickListener(new SuperBadge.OnBadgeClickListener() {
            @Override
            public void onBadgeClick() {

                Toast.makeText(SampleActivity.this, "Clicked on Badge", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
