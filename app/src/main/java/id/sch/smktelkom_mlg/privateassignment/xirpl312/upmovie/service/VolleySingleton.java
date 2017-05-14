package id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.service;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.HomeFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.PopularFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl312.upmovie.TopFragment;

/**
 * Created by Agnes-PC on 13/05/2017.
 */

public class VolleySingleton {
    private static volatile VolleySingleton mInstance;
    private static HomeFragment mCtx;
    private static PopularFragment mCtx2;
    private static TopFragment mCtx3;

    private RequestQueue mRequestQueue;

    /*private VolleySingleton(Context context)
    {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }*/

    private VolleySingleton(HomeFragment context) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(PopularFragment context1) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx2 = context1;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(TopFragment context2) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx3 = context2;
        mRequestQueue = getRequestQueue();
    }


    public static VolleySingleton getInstance(HomeFragment context) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context);
            }
        }
        return mInstance;
    }

    public static VolleySingleton getInstance(PopularFragment context2) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context2);
            }
        }
        return mInstance;
    }

    public static VolleySingleton getInstance(TopFragment context3) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context3);
            }
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getActivity());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
