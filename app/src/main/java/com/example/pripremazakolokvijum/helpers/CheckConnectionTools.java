package com.example.pripremazakolokvijum.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public class CheckConnectionTools {

    public static int checkConnection(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        Network network = cm.getActiveNetwork();

        if (network == null) {
            return 0; // nema interneta
        }

        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);

        if (capabilities == null) {
            return 0;
        }

        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return 1; // WiFi
        }

        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            return 2; // mobile data
        }

        return 0;
    }
}
