package es.cice.muestraiteraciones;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by cice on 31/1/17.
 */

public class AsyncTaskContador extends AsyncTask<Integer, Integer, Void> {
    TextView infoTV;

    public void setInfoTV(TextView infoTV) {
        this.infoTV = infoTV;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }


    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
        infoTV.setText("Cancelado");
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        infoTV.setText(values[0].toString());
    }

    @Override
    protected Void doInBackground(Integer... params) {
        for(int i=0; i<params[0]; i++){
            if (isCancelled()) {
                break;
            } else {
                try {
                    Thread.sleep(5000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    Log.d("A", "a");
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
