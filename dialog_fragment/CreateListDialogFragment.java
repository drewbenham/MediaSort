package com.example.drew.mediasort.dialog_fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.drew.mediasort.MainActivity;
import com.example.drew.mediasort.R;
import com.example.drew.mediasort.list_models.MediaList;

import java.util.MissingFormatArgumentException;

/**
 * Created by drew on 2/4/18.
 */

public class CreateListDialogFragment extends DialogFragment {

    public interface NoticeDialogListener {
        public void onRecordSelection(DialogFragment dialog);
        public void onOtherSelection(DialogFragment dialog);
    }

    NoticeDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder addListDialog = new AlertDialog.Builder(getActivity());

        addListDialog.setTitle("Add a New List")
                .setItems(R.array.media_types, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0) {
                            listener.onRecordSelection(CreateListDialogFragment.this);
                        } else if (i == 1) {
                            listener.onOtherSelection(CreateListDialogFragment.this);
                        }
                    }
                });
        return addListDialog.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }

    }
}
