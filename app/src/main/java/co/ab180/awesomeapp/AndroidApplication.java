package co.ab180.awesomeapp;

import android.app.Application;
import android.util.Log;

import co.ab180.airbridge.Airbridge;
import co.ab180.airbridge.AirbridgeConfig;

public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AirbridgeConfig config = new AirbridgeConfig.Builder("ablog", "38acf1efa9fc4f0987173f5a76516eb1")
                .setLogLevel(Log.VERBOSE)
                .build();
        Airbridge.init(this, config);
    }
}
