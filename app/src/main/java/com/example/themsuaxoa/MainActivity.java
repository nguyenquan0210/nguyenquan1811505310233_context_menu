package com.example.themsuaxoa;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.ContextMenu;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvAmNhac;
    Button  btnThem;

    Button btnsua;
    TextView tv , edtamnhac;
    ArrayList<String> arrayCourse;
    int vitri = -1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
//        btnThem=(Button) findViewById(R.id.buton1) ;
        edtamnhac=(TextView) findViewById(R.id.edittext1);
        lvAmNhac=(ListView) findViewById(R.id.listviewAmNhac);
//        btnsua=(Button)findViewById(R.id.buton2);
        arrayCourse= new ArrayList<>();
        arrayCourse.add("Khiêu Vũ");
        arrayCourse.add("Nhạc Kháng Chiến");
        arrayCourse.add("Nhạc Phim");
        arrayCourse.add("Nhạc Game");
        arrayCourse.add("Ngâm Thơ");
        arrayCourse.add("Bóng Rổ");
        arrayCourse.add("Chạy Bộ");
        arrayCourse.add("Đọc sách ");
        arrayCourse.add("Ngủ Nướng");
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayCourse);
        lvAmNhac.setAdapter(adapter);
//        btnThem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent();
//                i.setClass(MainActivity.this, ProductActivity.class);
//                String s= tv.getText().toString();
//                i.putExtra("dulieu", s);
//                //startActivity(intent);
//                startActivityForResult(i,ProductActivity.TRAVETU_ACTIVITY);
////                String amnhac= edtamnhac.getText().toString();
////                arrayCourse.add(amnhac);
////                adapter.notifyDataSetChanged();
//            }
//        });
        lvAmNhac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtamnhac.setText(arrayCourse.get(i));
                vitri=i;
            }
        });
//        btnsua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                arrayCourse.set(vitri,edtamnhac.getText().toString());
//                adapter.notifyDataSetChanged();
//            }
//        });
        lvAmNhac.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {

               AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
               alertDialogBuilder.setMessage("Setting Item!");
               alertDialogBuilder.setNegativeButton("Xóa Item", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       arrayCourse.remove(i);
                       adapter.notifyDataSetChanged();
                       Toast.makeText(MainActivity.this,"Đã Xóa Thành Công", Toast.LENGTH_LONG).show();
                   }
               });
                   alertDialogBuilder.setNeutralButton("Sửa Item", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       String s= edtamnhac.getText().toString();

                       final Dialog dialog1 = new Dialog(MainActivity.this);
                       dialog1.setTitle("HỘP THỌA XỬ LÍ");
                       dialog1.setCancelable(false);
                       dialog1.setContentView(R.layout.activity_insert_list);
                       final EditText edttk=(EditText) dialog1.findViewById(R.id.txtProductName);
                       edttk.setText(s);
                       Button btnhuy=(Button) dialog1.findViewById(R.id.btnCancel);
                       Button btndongy=(Button) dialog1.findViewById(R.id.btnOK);
                       btndongy.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {

                               arrayCourse.set(vitri,edttk.getText().toString().trim());
                               adapter.notifyDataSetChanged();
                               dialog1.cancel();
                           }
                       });
                       btnhuy.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.cancel();
                           }
                       });
                       dialog1.show();

                   }

               });
               alertDialogBuilder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       //không làm gì
                   }
               });
               alertDialogBuilder.show();

               return true;


           }
        });
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//    btnThem.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            String amnhac= edtamnhac.getText().toString();
//            arrayCourse.add(amnhac);
//            adapter.notifyDataSetChanged();
//        }
//    });
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        menu.setHeaderTitle("Cập nhật");
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.example_menu, menu);
//    }
//    @Override
//    public boolean onContextItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//            case R.id.them:
//                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.sua:
//                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.xoa:
//                Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // nếu btnAdd được click
        if (id == R.id.insert) {

            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
            String s= edtamnhac.getText().toString();
            intent.putExtra("dulieu", s);
            //startActivity(intent);
            startActivityForResult(intent,ProductActivity.TRAVETU_ACTIVITY);
        }else
            if (id == R.id.updete) {

            Intent intent = new Intent(MainActivity.this, Updete_list.class);
            String s= edtamnhac.getText().toString();
            intent.putExtra("dulieu1", s);
            //startActivity(intent);
            startActivityForResult(intent,Updete_list.TRAVETU_ACTIVITY1);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resulCode, Intent data){
        super.onActivityResult(requestCode, resulCode, data);

        if(requestCode==ProductActivity.TRAVETU_ACTIVITY){
            String s=data.getStringExtra("dulieu");
            edtamnhac.setText(s);
            String amnhac= edtamnhac.getText().toString();
            arrayCourse.add(amnhac);
           // adapter.notifyDataSetChanged();

        }else

        if(requestCode==Updete_list.TRAVETU_ACTIVITY1){
            String s=data.getStringExtra("dulieu1");
            edtamnhac.setText(s);

            arrayCourse.set(vitri,edtamnhac.getText().toString());


        }

    }

}