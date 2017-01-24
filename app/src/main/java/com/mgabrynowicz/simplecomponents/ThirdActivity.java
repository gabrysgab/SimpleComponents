package com.mgabrynowicz.simplecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    private final String valueToReturn = "this is value from third activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setText("Send value to first activity");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnSomeData();


            }
        });

    }



    private void returnSomeData() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("thirdActivityValue",valueToReturn );
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
