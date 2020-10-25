package com.example.themsuaxoa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Updete_list extends AppCompatActivity {


        public final static int TRAVETU_ACTIVITY1 = 1000;
        EditText txtProductName;

        int position;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_product);

            Intent it = getIntent();
            String dulieu =it.getStringExtra("dulieu1");
            txtProductName = (EditText)findViewById(R.id.txtProductName);
            txtProductName.setText(dulieu);
            Button btnOK = (Button)findViewById(R.id.btnOK);
            Button btnCancel = (Button)findViewById(R.id.btnCancel);
            btnOK.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent i =new Intent();
                    String s = txtProductName.getText().toString();
                    i.putExtra("dulieu1", s);
                    setResult(TRAVETU_ACTIVITY1, i);
                    finish();
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // không làm gì cả và trở về màng hình trước

                    Intent intent = new Intent(Updete_list.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

//        class OKClickListener implements View.OnClickListener
//        {
//            @Override
//            public void onClick(View v) {
//                Intent i =new Intent();
//                String s = txtProductName.getText().toString();
//                i.putExtra("dulieu", s);
//                setResult(TRAVETU_ACTIVITY1, i);
////            //lấy dữ liệu từ layout để cập nhật lại các sản phẩm trong mảng
////            product.setProductName(txtProductName.getText().toString());
////            product.setUnit(txtUnit.getText().toString());
////            String s = txtPrice.getText().toString();
////            s = s.replace(",", "");
////            double price = Double.parseDouble(s);
////            product.setPrice(price);
////            Intent returnIntent = new Intent();
////            setResult(Activity.RESULT_OK, returnIntent);
//                finish();
////
////            Intent switchlayout =new Intent(getApplicationContext(),MainActivity.class);
////            switchlayout.putExtra("",txtProductName.getText().toString());
////
////            Log.e("n",txtProductName.getText() );
//
//            }
//        }
//
//        class CancelClickListener implements View.OnClickListener
//        {
//            @Override
//            public void onClick(View v) {
//                // không làm gì cả và trở về màng hình trước
//                Intent returnIntent = new Intent();
//                setResult(Activity.RESULT_CANCELED, returnIntent);
//                finish();
//            }
//        }
    }