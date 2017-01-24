package com.mgabrynowicz.simplecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity();

            }
        });
    }

    private void startAnotherActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key_aaa", "some magic value");
        startActivityForResult(intent, 111);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK) {
            String text = data.getStringExtra("key1");
            Toast.makeText(this,text, Toast.LENGTH_SHORT ).show();
        }
        if(requestCode == 111 && resultCode == RESULT_OK) {

            String text = data.getStringExtra("thirdActivityValue");
            Toast.makeText(this,text, Toast.LENGTH_SHORT ).show();


        }

    }
}
