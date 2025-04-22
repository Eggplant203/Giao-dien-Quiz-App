package com.example.quizappinterface;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class SecondActivity extends AppCompatActivity {

    Button btnFollow;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnFollow = findViewById(R.id.btnFollow);
        btnInfo = findViewById(R.id.btnInfo);

        // Resize icons
        resizeButtonDrawable(btnFollow, R.drawable.ic_follow, 24, 24);
        resizeButtonDrawable(btnInfo, R.drawable.ic_info, 24, 24);

        findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Go back to MainActivity
            }
        });
    }

    private void resizeButtonDrawable(Button button, int drawableId, int width, int height) {
        Drawable drawable = ContextCompat.getDrawable(this, drawableId);
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable);
            drawable.setBounds(0, 0,
                    (int) (width * getResources().getDisplayMetrics().density),
                    (int) (height * getResources().getDisplayMetrics().density));
            button.setCompoundDrawables(drawable, null, null, null);
        }
    }
}