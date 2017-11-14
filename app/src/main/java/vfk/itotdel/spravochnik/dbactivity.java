package vfk.itotdel.spravochnik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.List;

public class dbactivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        Button ybazuk=(Button)findViewById(R.id.createBaza);
        Button infilebazu=(Button)findViewById(R.id.loadBaza);
        Button unloadbazu=(Button)findViewById(R.id.outloadBaza);
        Button spisokdbazu=(Button)findViewById(R.id.spisok);
ybazuk.setOnClickListener(this);
spisokdbazu.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.createBaza) {
            DatabaseHandler dbt=new DatabaseHandler(this);
            dbt.onUpgrade(dbt.getWritableDatabase(),0,0);
            Toast toast=Toast.makeText(getApplicationContext(),"ПЕРЕСОЗДАЛИ БАЗУ",Toast.LENGTH_SHORT);
            toast.show();
        }
        if (view.getId()==R.id.spisok) {
            DatabaseHandler dbt=new DatabaseHandler(this);
            dbt.getWritableDatabase();
            List dhh=dbt.getAllInventarniki();
            Toast toast=Toast.makeText(getApplicationContext(),"СПИСОК БАЗЫ"+dhh.toString(),Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


