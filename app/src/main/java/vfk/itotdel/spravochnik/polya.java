package vfk.itotdel.spravochnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class polya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polya);
        TextView invT=(TextView)findViewById(R.id.invnomer);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("nomer");
        Toast toast=Toast.makeText(getApplicationContext(),fName,Toast.LENGTH_SHORT);
        toast.show();
        //String lName = intent.getStringExtra("lname");
        invT.setText(fName);
    }

    @Override
    protected void onDestroy() {
        String fft=Integer.toString(44444);
        Toast toast=Toast.makeText(getApplicationContext(),fft,Toast.LENGTH_SHORT);
        toast.show();
        super.onDestroy();
    }
}
