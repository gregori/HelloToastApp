package tech.gregori.hellotoastapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 0; // contador
    public static final String EXTRA_COUNT = "tech.gregori.hellotoastapp.extra.count";
    private TextView showCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.show_count); // atribui elemento à variável showCount
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void showToast(View view) {
        // criar o Toast com dados específicos
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show(); // mostrar o toast
    }

    public void countUp(View view) {
        // quando clicar no botão
        // incremente o contador
        count++;
        // mostre na tela o valor incrementado
        if (showCount != null) {
            showCount.setText(Integer.toString(count));
        }
    }

    public void countDown(View view) {
        count--;
        if (showCount != null) {
            showCount.setText(Integer.toString(count));
        }
    }

    public void sayHello(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }
}