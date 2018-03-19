
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickIt(View view) {
        EditText hufAmount = (EditText) findViewById(R.id.hufNum);
        Log.i("Amount", hufAmount.getText().toString());
        Double hufAmountDouble = Double.parseDouble(hufAmount.getText().toString());
        Double usdAmount = hufAmountDouble / 265.00;
        Toast.makeText(MainActivity.this, hufAmount.getText().toString() + "Ft is $" + String.format("%.2f", usdAmount), Toast.LENGTH_SHORT).show();
        ImageView num = (ImageView) findViewById(R.id.numPic);
        num.setImageResource(R.drawable.calgif);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
