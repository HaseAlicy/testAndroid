package com.example.haseyuuki.fujitsuchizaihase;

import android.os.AsyncTask;

public abstract class AsyncHttpRequest extends AsyncTask<String, Void, String> {
    protected AsyncCallback callback = null;
}
