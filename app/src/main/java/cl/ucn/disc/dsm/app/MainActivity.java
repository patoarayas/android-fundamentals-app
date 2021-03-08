package cl.ucn.disc.dsm.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cl.ucn.disc.dsm.app.counter.CounterActivity;
import cl.ucn.disc.dsm.app.task.TaskActivity;
import cl.ucn.disc.dsm.app.words.WordActivity;

public class MainActivity extends AppCompatActivity {

  private String LOG_TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(LOG_TAG, " Estamos en el On Create");
    setContentView(R.layout.activity_main);
  }

  /**
   * Launch Counter activity
   * @param view
   */
  public void launchCounterActivity(View view){
    Intent intent = new Intent(this, CounterActivity.class);
    startActivity(intent);
  }

  
  @Override
  protected void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "Estamos en el On Start");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "Estamos en el On Stop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "Estamos en el On Destroy");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "Estamos en el On Pause");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "Estamos en el On Resume");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(LOG_TAG, "Estamos en el On Restart");
  }

  public void launchTaskActivity(View view) {
    Intent intent = new Intent(this, TaskActivity.class);
    startActivity(intent);
  }

  public void launchWordsActivity(View view) {
    Intent intent = new Intent(this, WordActivity.class);
    startActivity(intent);
  }
}