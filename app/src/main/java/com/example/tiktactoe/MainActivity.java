package com.example.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b[] = new Button[9];
    Button c1;
    TextView t1;
    RadioButton r1,r2;
    String str="O",s1="O",s2="X";
    String a[] = new String[9];
    int t=0,i=0,j=0;
    ArrayList arr=new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<b.length;i++){
            int id=getResources().getIdentifier("b"+i,"id",getPackageName());
            b[i]=findViewById(id);
            b[i].setOnClickListener(this);
        }

        t1=findViewById(R.id.t1);
        c1=findViewById(R.id.c1);

        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    str = "O";
                    s1 = "O";
                    s2 = "X";
                }
            }
        });

        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    str = "X";
                    s1 = "X";
                    s2 = "O";
                }
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j=0;
                t=0;
                for(int i=0;i<b.length;i++){
                    b[i].setText("");
                    b[i].setEnabled(true);

                }
                if(r1.isChecked())
                {
                    str = "O";
                    s1 = "O";
                    s2 = "X";
                }
                else
                {
                    str = "X";
                    s1 = "X";
                    s2 = "O";

                }
                t1.setText("");
            }
        });
    }

    @Override
    public void onClick(View v) {

        for (int i = 0; i < b.length; i++) {
            if (v.getId() == b[i].getId()) {
                j++;

                b[i].setText(s1);
                b[i].setTextSize(20);
                arr.add(i);
                t++;

               if(t<=4)
               {
                   while (true)
                   {
                       int random=new Random().nextInt(9-0)+0;
                       System.out.println(random);
                       if(!arr.contains(random))
                       {
                           b[random].setText(s2);
                           b[random].setTextSize(20);
                           arr.add(random);
                           break;
                       }
                   }
               }
                b[i].setEnabled(false);
                win();
            }
        }
    }
    void win(){

        if(j==9){
            t1.setText("Match Draw!");
        }

        for(int i=0;i<a.length;i++){
            a[i]=b[i].getText().toString();
        }

        if(a[0].equals("O") && a[1].equals("O") && a[2].equals("O") || a[0].equals("O") && a[3].equals("O") && a[6].equals("O") || a[6].equals("O") && a[7].equals("O") && a[8].equals("O") || a[2].equals("O") && a[5].equals("O") && a[8].equals("O") || a[1].equals("O") && a[4].equals("O") && a[7].equals("O") || a[3].equals("O") && a[4].equals("O") && a[5].equals("O") || a[0].equals("O") && a[4].equals("O") && a[8].equals("O") || a[2].equals("O") && a[4].equals("O") && a[6].equals("O"))
        {
            t1.setText("O Wins !");

            for(int i=0;i<b.length;i++){
                b[i].setEnabled(false);
            }
        }
        else if(a[0].equals("X") && a[1].equals("X") && a[2].equals("X") || a[0].equals("X") && a[3].equals("X") && a[6].equals("X") || a[6].equals("X") && a[7].equals("X") && a[8].equals("X") || a[2].equals("X") && a[5].equals("X") && a[8].equals("X") || a[1].equals("X") && a[4].equals("X") && a[7].equals("X") || a[3].equals("X") && a[4].equals("X") && a[5].equals("X") || a[0].equals("X") && a[4].equals("X") && a[8].equals("X") || a[2].equals("X") && a[4].equals("X") && a[6].equals("X"))
        {
            t1.setText("X Wins !");

            for(int i=0;i<b.length;i++){
                b[i].setEnabled(false);
            }
        }
    }
}