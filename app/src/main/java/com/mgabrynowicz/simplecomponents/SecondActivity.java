package com.mgabrynowicz.simplecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = (Button) findViewById(R.id.button);
        button.setText("Return some data");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startThirdActivity();

            }
        });

        Intent startingIntent = getIntent();
        String valueAaa = startingIntent.getStringExtra("key_aaa");



}

    private void startThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, 111);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 111 && resultCode == RESULT_OK) {
            setResult(RESULT_OK,data);
            finish();


        }
    }

    private void returnSomeData() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("key1", "Some value");
        setResult(RESULT_OK, resultIntent);
        finish();
    }


}
