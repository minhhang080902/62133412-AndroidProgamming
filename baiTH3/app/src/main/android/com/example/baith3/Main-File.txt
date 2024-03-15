package till.edu.ex_6_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsTenTinhThanh= new ArrayList<String>();
    Button btnADD, btnUPDATE;
    EditText editTinhThanh;
    int Position= -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu trên listview
        //B1: lấy dữ liệu từ cơ sở dữ liệu(SQL, XML, noSQL, ....)
        //Ở bài này chúng ta hard-code dữ liệu trực tiep
        //Cần biến phù hợp để lưu du lieu
        //Khai bao bien luu du lieu

        ///////////////////////////////////////
        btnADD= (Button) findViewById(R.id.btnAdd);
        btnUPDATE= (Button) findViewById(R.id.btnUpdate);
        editTinhThanh= (EditText) findViewById(R.id.editString);
        /////////////////////////////////////////

        //Them du lieu o day
        dsTenTinhThanh.add("Ha Noi");
        dsTenTinhThanh.add("Thanh pho HCM");
        dsTenTinhThanh.add("Binh Thuan");

        //Tao adpter
        ArrayAdapter<String> adapterTinhThanh= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dsTenTinhThanh);
        //Gan dieu kien hien thi ListView
        ListView lvTenTinhThanh= findViewById(R.id.lvTTT);
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        lvTenTinhThanh.setOnItemClickListener(ListListener);

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinhThanh= editTinhThanh.getText().toString();
                dsTenTinhThanh.add(tinhThanh);
                adapterTinhThanh.notifyDataSetChanged();
            }
        });

        lvTenTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editTinhThanh.setText(dsTenTinhThanh.get(position));
                Position= position;
                Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_LONG).show();

            }
        });
        btnUPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsTenTinhThanh.set(Position, editTinhThanh.getText().toString());
                adapterTinhThanh.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();

            }
        });
        lvTenTinhThanh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dsTenTinhThanh.remove(position);
                adapterTinhThanh.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Removed", Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }

    //Tạo bộ lắng nghe và xử lý sự kiện OnItemClick
    AdapterView.OnItemClickListener ListListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Code xu ly o day
            //position la vi tri cua phan tu vua duoc click
            //vd xu ly o day, hien thi thong bao nhanh ve vi tri cua mot phan tu vua chon
            //Lay gia tri o phan tu thu i
            String strTTT=  dsTenTinhThanh.get(position);
            Toast.makeText(MainActivity.this,strTTT, Toast.LENGTH_LONG).show();
        }
    };
}