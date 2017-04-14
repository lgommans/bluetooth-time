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
import android.os.SystemClock;
import java.util.Calendar;

public class breceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		final String action = intent.getAction();

		// android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED ?
		if (action.equals(BluetoothDevice.ACTION_ACL_CONNECTED)) {
			final BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			if (device.getName().equals(YOUR DEVICE NAME HERE)) {
				Intent speechIntent = new Intent();
				speechIntent.setClass(context, bluetooth_timeactivity.class);
				speechIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
				context.startActivity(speechIntent);
				//bluetooth_timeactivity.gimmeTime();
			}
		}
	}
}
