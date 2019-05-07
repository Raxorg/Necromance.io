package com.frontanilla.necromance.interfacing.firebase;

import com.frontanilla.necromance.utils.advanced.DataListener;

public interface AuthInterface {

    void touchUpOnSignInButton(DataListener<String> dataListener, DataListener<int[][]> imageDataListener);

    void touchUpOnSignOutButton();
}
