package com.example.calculator_grid_cascaded;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    boolean op = true;
    String oper = "+";
    String old = "";
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText) findViewById(R.id.number);
    }
//    public void NumberEvent(View view){
//        if(op){
//            number.setText("");
//        }
//        op = false;
//        String num = number.getText().toString();
//        switch (view.getId()) {
//            case R.id.b1:
//                num += "1";
//                break;
//            case R.id.b2:
//                num += "2";
//                break;
//            case R.id.b3:
//                num += "3";
//                break;
//            case R.id.b4:
//                num += "4";
//                break;
//            case R.id.b5:
//                num += "5";
//                break;
//            case R.id.b6:
//                num += "6";
//                break;
//            case R.id.b7:
//                num += "7";
//                break;
//            case R.id.b8:
//                num += "8";
//                break;
//            case R.id.b9:
//                num += "9";
//                break;
//            case R.id.b0:
//                num += "0";
//                break;
//            case R.id.clr:
//                num = "";
//                break;
//        }
//        number.setText(num);
//    }

    public void NumberEvent(View view) {
        if (op) {
            number.setText("");
        }
        op = false;
        String num = number.getText().toString();

        int viewId = view.getId();
        if (viewId == R.id.b1) {
            num += "1";
        } else if (viewId == R.id.b2) {
            num += "2";
        } else if (viewId == R.id.b3) {
            num += "3";
        } else if (viewId == R.id.b4) {
            num += "4";
        } else if (viewId == R.id.b5) {
            num += "5";
        } else if (viewId == R.id.b6) {
            num += "6";
        } else if (viewId == R.id.b7) {
            num += "7";
        } else if (viewId == R.id.b8) {
            num += "8";
        } else if (viewId == R.id.b9) {
            num += "9";
        } else if (viewId == R.id.b0) {
            num += "0";
        } else if (viewId == R.id.clr) {
            num = "";
        }

        number.setText(num);
    }

//    public void OperatorEvent(View view) {
//        op=true;
//        old=number.getText().toString();
//        switch (view.getId()) {
//            case R.id.add:
//                oper="+";
//                break;
//            case R.id.sub:
//                oper="-";
//                break;
//            case R.id.mul:
//                oper="*";
//                break;
//            case R.id.div:
//                oper="/";
//                break;
//        }
//    }

    public void OperatorEvent(View view) {
        op = true;
        old = number.getText().toString();

        int viewId = view.getId();

        if (viewId == R.id.add) {
            oper = "+";
        } else if (viewId == R.id.sub) {
            oper = "-";
        } else if (viewId == R.id.mul) {
            oper = "*";
        } else if (viewId == R.id.div) {
            oper = "/";
        }
    }

    public void EqualEvent(View view) {
        String newNumber=number.getText().toString();
        double res=0.0;
        switch (oper) {
            case "+":
                res=Double.parseDouble(old)+Double.parseDouble(newNumber);
                break;
            case "-":
                res=Double.parseDouble(old)-Double.parseDouble(newNumber);
                break;
            case "*":
                res=Double.parseDouble(old)*Double.parseDouble(newNumber);
                break;
            case "/":
                res=Double.parseDouble(old)/Double.parseDouble(newNumber);
                break;
        }
        number.setText(res+"");
    }
}
