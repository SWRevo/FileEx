package com.swrevo.fileex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.swrevo.fileex.R;

public class NewFolderDialog implements DialogInterface.OnClickListener {
    @Nullable
    private OnNewFolderNameEnteredListener mListener;
    private AlertDialog.Builder mAlert;

    @SuppressLint("InflateParams")
    public NewFolderDialog(@NonNull Context context) {
        mAlert = new AlertDialog.Builder(context);
        mAlert.setTitle(R.string.efp__new_folder);
        mAlert.setView(LayoutInflater.from(context).inflate(R.layout.efp__new_folder, null));
        mAlert.setPositiveButton(android.R.string.ok, this);
        mAlert.setNegativeButton(android.R.string.cancel, null);
    }

    public void setOnNewFolderNameEnteredListener(OnNewFolderNameEnteredListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        TextView name = (TextView) ((AlertDialog) dialogInterface).findViewById(R.id.name);
        if (mListener != null && name != null) {
            mListener.onNewFolderNameEntered(name.getText().toString());
        }
    }

    public void show() {
        mAlert.show();
    }

    public interface OnNewFolderNameEnteredListener {
        void onNewFolderNameEntered(@NonNull String name);
    }
}
