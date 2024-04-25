package till.edu.vd2_explicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPass;
    EditText edtMail;
    TextView tvFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void KiemTraLogin(View view){
        edtName = (EditText) findViewById(R.id.edtUserName);
        edtPass = (EditText) findViewById(R.id.edtPassword);
        edtMail = (EditText) findViewById(R.id.edtMail);
        tvFail = (TextView)findViewById(R.id.tvFail );

        String strName = edtName.getText().toString();
        String strPass = edtPass.getText().toString();

        if(strName.equals("lephanbaongoc") && strPass.equals("12345")){
            Intent iHome = new Intent(this, HomeActivity.class);
            iHome.putExtra("key1",strName);
            startActivity(iHome);
        }
        else {
            edtName.setText("");
            edtPass.setText("");
            edtMail.setText("");
            tvFail.setText("ĐĂNG NHẬP THẤT BẠI!");
        }
    }
}