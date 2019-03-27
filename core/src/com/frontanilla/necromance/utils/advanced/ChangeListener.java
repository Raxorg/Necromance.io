package com.frontanilla.necromance.utils.advanced;

public abstract class ChangeListener<A> {

    public abstract void onCancelled(String message);

    public abstract void onDataFetched(A data);
}
