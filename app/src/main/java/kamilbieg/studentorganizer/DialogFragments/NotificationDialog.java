package kamilbieg.studentorganizer.DialogFragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Objects;

import kamilbieg.studentorganizer.Database.DatabaseFunctions;
import kamilbieg.studentorganizer.Note;
import kamilbieg.studentorganizer.R;

public class NotificationDialog extends DialogFragment {

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_notification, null);
        final EditText editText = view.findViewById(R.id.edit_fast_note);
        final DatePicker datePicker = view.findViewById(R.id.datePicker);

        builder.setView(view)
                .setTitle(getResources().getString(R.string.notif_dialog))
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = String.valueOf(datePicker.getYear())
                                + (datePicker.getMonth() < 10 ? "0" + String.valueOf(datePicker.getMonth()) : String.valueOf(datePicker.getMonth()))
                                + (datePicker.getDayOfMonth() < 10 ? "0" + String.valueOf(datePicker.getDayOfMonth()) : String.valueOf(datePicker.getDayOfMonth()));
                        Note note = Note.builder()
                                .noteType("NotificationNote")
                                .endDate(date)
                                .description(editText.getText().toString())
                                .build();
                        DatabaseFunctions databaseFunctions = new DatabaseFunctions();
                        databaseFunctions.addNoteToDatabase(getActivity(), note);
                        DialogFunctions.notifyToTarget(Activity.RESULT_OK, NotificationDialog.this);
                    }
                });

        return builder.create();
    }
}
