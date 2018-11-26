package fr.afaucogney.mobile.android.uitestwsevenmockapp;

import de.greenrobot.event.EventBus;

public class DataManager {

    public void requestWebService(){
        EventBus.getDefault().post(new RequestResponseEvent("Hello"));
    }
}
