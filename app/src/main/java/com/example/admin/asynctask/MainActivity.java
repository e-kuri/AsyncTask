package com.example.admin.asynctask;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // private MyClass m;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  m = new MyClass();
        tv = ((TextView) findViewById(R.id.textView));
    }

    public void onClick(View view) {
        new MyClass().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 3000);
    }

    private class MyClass extends AsyncTask<Integer, Void, String> {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */

        protected String doInBackground(Integer... num) {
            try {
                Thread.sleep(num[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return String.valueOf(num[0]);
        }

        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.wtf("Kuri : ", s);
            tv.setText("Kuri : " + s);
        }
    }
}
