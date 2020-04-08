package com.example.myapplication7;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText x,y,answer;
    TextView hint;
    Button b1,in;
    int attempt,num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer=findViewById(R.id.answer);
        y=findViewById(R.id.max);
        hint=findViewById(R.id.suggest);
        x=findViewById(R.id.min);
        b1=findViewById(R.id.b1);
        in=findViewById(R.id.start);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int n= Integer.parseInt(x.getText().toString());
                int m= Integer.parseInt( y.getText().toString());
                num = r.nextInt(m - n) + n;
                attempt=0;
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ans= Integer.parseInt( answer.getText().toString());
                attempt+=1;
                if(ans>num)
                {
                    hint.setText("value is greater");

                }
                else if(ans<num)
                {
                    hint.setText("value is smallerr");

                }
                else if(ans==num)
                {
                    hint.setText("win with attepmt "+attempt);
                    Toast.makeText(getApplicationContext(),"game over",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

