package com.example.quizappinterface;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class MainActivity extends AppCompatActivity {

    Button btnTakeQuiz;
    Button btnFacebookLogin;
    Button btnGoogleLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakeQuiz = findViewById(R.id.btnTakeQuiz);
        btnFacebookLogin = findViewById(R.id.btnFacebookLogin);
        btnGoogleLogin = findViewById(R.id.btnGoogleLogin);

        // Resize the social media icons
        resizeButtonDrawable(btnFacebookLogin, R.drawable.ic_facebook, 24, 24);
        resizeButtonDrawable(btnGoogleLogin, R.drawable.ic_googleplus, 24, 24);

        btnTakeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    // Helper method to resize button drawables
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