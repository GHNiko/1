
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    public void makeToast(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }
    public void clickMe(View view) {
        EditText guessNum = (EditText) findViewById(R.id.numberText);
        int guessInt = Integer.parseInt(guessNum.getText().toString());

        if (guessInt > randomNumber) {
            makeToast("Lower!");
        } else if (guessInt < randomNumber){
            makeToast("Higher!");
        } else {
            makeToast("Well done! Play again!");
            Random rand = new Random();
            randomNumber = rand.nextInt(20) + 1 ;
        }


        Toast.makeText(MainActivity.this, guessNum.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1 ;

    }
}
