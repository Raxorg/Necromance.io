package com.frontanilla.necromance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.interfacing.firebase.AuthInterface;
import com.frontanilla.necromance.utils.advanced.DataListener;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidLauncher extends AndroidApplication implements AuthInterface {

    private GoogleApiClient googleAPIClient;
    private static final int RC_SIGN_IN = 9009;
    private DataListener<String> dataListener;
    private DataListener<int[][]> imageDataListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        // Clear Application Data so Firebase doesn't use Cached Data
        clearApplicationData();
        // Get unique identifier for the phone
        @SuppressLint("HardwareIds")
        String android_id = Settings.Secure.getString(getContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        // Your screen phone will never go off
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // TODO: Google Auth
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("272759113220-r2ir9krt5631qjtgt3e3snp5q8o4k9q7.apps.googleusercontent.com")
                .requestEmail()
                .build();
        googleAPIClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        // Initialize LibGDX Code
        initialize(new NecromanceClient(android_id, new AndroidRealtimeDB(), this), config);
    }

    // TODO: GOOGLE AUTH
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            if (account != null) {
                dataListener.onData(account.getDisplayName());
                /*System.out.println(account.getDisplayName());
                System.out.println(account.getEmail());
                System.out.println(account.getFamilyName());
                System.out.println(account.getGivenName());
                System.out.println(account.getId());
                System.out.println(account.getPhotoUrl());*/
                try {
                    if (account.getPhotoUrl() != null) {
                        Thread thread = new Thread(new RetrieveImageRunnable(
                                new URL(account.getPhotoUrl().toString()),
                                imageDataListener));
                        thread.start();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("ACCOUNT IS NULL");
            }
        } else {
            String statusMessage = result.getStatus().getStatusMessage();
            int statusCode = result.getStatus().getStatusCode();
            System.out.println("RESULT IS NOT SUCCESS, STATUS MESSAGE: " + statusMessage + " STATUS CODE: " + statusCode);
        }
    }

    public void touchUpOnSignInButton(DataListener<String> dataListener, DataListener<int[][]> imageDataListener) {
        this.dataListener = dataListener;
        this.imageDataListener = imageDataListener;
        signIn();
    }

    public void touchUpOnSignOutButton() {
        signOut();
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleAPIClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleAPIClient);
    }
    // TODO: END GOOGLE AUTH

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }

    // This snippet hides the system bars.
    private void hideSystemUI() {
        View mDecorView = getWindow().getDecorView();
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }

    private void clearApplicationData() {
        File cacheDirectory = getCacheDir();
        File applicationDirectory = new File(cacheDirectory.getParent());
        if (applicationDirectory.exists()) {
            String[] fileNames = applicationDirectory.list();
            for (String fileName : fileNames) {
                if (!fileName.equals("lib")) {
                    deleteFiles(new File(applicationDirectory, fileName));
                    Log.i("TAG", "File/data/data/APP_PACKAGE/" + fileName + " DELETED");
                }
            }
        }
    }

    private boolean deleteFiles(File file) {
        boolean deletedAll = true;
        if (file != null) {
            if (file.isDirectory()) {
                String[] children = file.list();
                for (String aChildren : children) {
                    deletedAll = deleteFiles(new File(file, aChildren)) && deletedAll;
                }
            } else {
                deletedAll = file.delete();
            }
        }
        return deletedAll;
    }

    private static class RetrieveImageRunnable implements Runnable {

        private URL url;
        private DataListener<int[][]> imageDataListener;

        public RetrieveImageRunnable(URL url, DataListener<int[][]> imageDataListener) {
            this.url = url;
            this.imageDataListener = imageDataListener;
        }

        @Override
        public void run() {
            try {
                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                int[][] imageData = new int[image.getHeight()][image.getWidth()];
                for (int row = 0; row < image.getHeight(); row++) {
                    imageData[row] = new int[image.getWidth()];
                    for (int column = 0; column < image.getWidth(); column++) {
                        imageData[row][column] = image.getPixel(column, row);
                    }
                }
                imageDataListener.onData(imageData);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
