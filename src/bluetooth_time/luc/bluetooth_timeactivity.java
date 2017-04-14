package bluetooth_time.luc;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.TextView;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import android.speech.tts.TextToSpeech;
import java.util.Locale;
import android.os.SystemClock;
import java.util.Calendar;

public class bluetooth_timeactivity extends Activity
{
	TextView out;
	private TextToSpeech tts;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		out = (TextView) findViewById(R.id.output);
		out.setText("Initialized.");

		SystemClock.sleep(3300);
		tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
			@Override
			public void onInit(int status) {
				Calendar c = Calendar.getInstance();
				tts.speak("time is " + c.get(Calendar.HOUR), 0, null);
				SystemClock.sleep(1000);
				tts.speak(c.get(Calendar.MINUTE) + "", 1, null);
				SystemClock.sleep(1000);
				tts.speak(c.get(Calendar.SECOND) + "", 1, null);
				SystemClock.sleep(2000);
				tts.shutdown();
				tts = null;
				finishAffinity();
			}
		});
	}
}

