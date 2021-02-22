package cl.ucn.disc.dsm.app.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cl.ucn.disc.dsm.app.MainActivity;
import cl.ucn.disc.dsm.app.R;

public class CounterActivity extends AppCompatActivity {

  private String LOG_TAG = CounterActivity.class.getSimpleName();

  private int count = 0;
  private TextView showCount;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(LOG_TAG, "On Create");
    setContentView(R.layout.activity_counter);
    showCount = (TextView) findViewById(R.id.showCount);
  }

  public void showToast(View view) {
    Toast toast = Toast.makeText(this,R.string.toast_message, Toast.LENGTH_LONG);
    toast.show();
  }

  public void countUp(View view){
    count++;
    if(showCount != null){
      showCount.setText(Integer.toString(count));
    }

  }


  @Override
  protected void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "On Start");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "On Stop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "On Destroy");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "On Pause");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "On Resume");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(LOG_TAG, "On Restart");
  }
}