package till.edu.vd2_explicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent extra = getIntent();
        TextView tvName = (TextView) findViewById(R.id.tvUserName);
        String strName = extra.getStringExtra("key1");
        tvName.setText(strName);
    }
}