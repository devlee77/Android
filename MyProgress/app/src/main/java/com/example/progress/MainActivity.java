package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ProgressThread thread = new ProgressThread();
                        thread.start();
                    }
                }, 5000);
                */

                ProgressTask task = new ProgressTask();
                task.execute("시작");
            }
        });
    }

    class ProgressTask extends AsyncTask<String, Integer, Integer> {

        int value = 0;
        // 뭔가를 처리하는 메소드
        @Override
        protected Integer doInBackground(String... strings) {
            while (true){
                if (value > 100) {
                    break;
                }
                value += 1;

                publishProgress(value); //이거쓰면 밑에 onpostexecute 메소드 실행됨

                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
            return value;
        }

        //중간중간 ui 업데이트 하고싶을때는 여기서
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());
        }

        //완료부분
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(getApplicationContext(), "완료됨.", Toast.LENGTH_SHORT).show();

        }



    }
/*
    class ProgressThread extends Thread {
        int value = 0;

        public void run() {
            while (true){
                if (value > 100) {
                    break;
                }
                value += 1;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (Exception e) {}

            }
        }
    }
 */
}
