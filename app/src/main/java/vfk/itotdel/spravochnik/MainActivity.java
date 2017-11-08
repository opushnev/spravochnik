package vfk.itotdel.spravochnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText searchNomerT;
    EditText searchNameT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but6=(Button)findViewById(R.id.button6);
        but6.setOnClickListener(this);
        Button butB=(Button)findViewById(R.id.buttonBaza);
        butB.setOnClickListener(this);
        searchNomerT=(EditText)findViewById(R.id.searchNomer);
        searchNameT=(EditText)findViewById(R.id.searchName);
        DatabaseHandler db=new DatabaseHandler(this);
        String ff=db.getDatabaseName();
       List fff=db.getAllInventarniki();
        int ss=fff.size();
        String fft=Integer.toString(ss);
        Toast toast=Toast.makeText(getApplicationContext(),fft,Toast.LENGTH_SHORT);
        toast.show();
        filerw files=new filerw();
        files.writeFileSD();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.button6) {
            Intent intb=new Intent(this,polya.class);
            intb.putExtra("nomer",searchNomerT.getText().toString());
            startActivity(intb);
        }
        if (v.getId()== R.id.buttonBaza) {
            Intent intbaza=new Intent(this,dbactivity.class);
            //intb.putExtra("nomer",searchNomerT.getText().toString());
            startActivity(intbaza);
        }


    }
}
