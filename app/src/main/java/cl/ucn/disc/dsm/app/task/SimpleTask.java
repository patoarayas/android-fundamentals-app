package cl.ucn.disc.dsm.app.task;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleTask extends AsyncTask<Void,Void,String> {

  private WeakReference<TextView> mTextView;

  public SimpleTask(TextView tv) {
    mTextView = new WeakReference<TextView>(tv);
  }

  @Override
  protected String doInBackground(Void... voids) {
    Random r = new Random();
    int n = r.nextInt(11);

    int s = n * 2000;

    try {
      Thread.sleep(s);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return "Me demoré "+ s + " milisegundos";
  }

  @Override
  protected void onPostExecute(String s) {
    mTextView.get().setText(s);

  }
}
