package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int REQUEST_CODE = 100;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity =findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMOveWithData = findViewById(R.id.btn_move_with_data);
        btnMOveWithData.setOnClickListener(this);

        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        Button btnMoveforResult = findViewById(R.id.btn_move_with_result);
        btnMoveforResult.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void  onClick (View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Kampus STIMATA");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "082329339456";
                Intent dialPhoneNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phoneNumber ));
                startActivity(dialPhoneNumber);
                break;
            case  R.id.btn_move_with_result :
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveforResultActivity.class);
                startActivity(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if (resultCode == MoveforResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveforResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil :" + selectedValue);
            }
        }
    }

}