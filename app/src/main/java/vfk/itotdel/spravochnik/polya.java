package vfk.itotdel.spravochnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class polya extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polya);
        TextView invT=(TextView)findViewById(R.id.invnomer);
        Button getbarc=(Button)findViewById(R.id.button2);
        getbarc.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button2) {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
            integrator.setPrompt(getString(R.string.readshtrih));
            integrator.setCameraId(0);
            integrator.setOrientationLocked(false);
            integrator.setBeepEnabled(false);
            integrator.setBarcodeImageEnabled(false);
            integrator.initiateScan();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                TextView txt1=(TextView) this.findViewById(R.id.textView);
                txt1.setText(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
