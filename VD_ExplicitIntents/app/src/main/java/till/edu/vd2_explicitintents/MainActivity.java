package till.edu.vd2_explicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Hàm xử lý chuyển sang màn hình đăng nhập
    public  void DangNhap(View view){
        //tạo đối tượng Intents
        Intent iDangNhap = new Intent(this, LoginActivity.class);
        startActivity(iDangNhap);
    }
}