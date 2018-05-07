package kamilbieg.studentorganizer.DialogFragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import kamilbieg.studentorganizer.Database.DatabaseFunctions;
import kamilbieg.studentorganizer.Note;
import kamilbieg.studentorganizer.R;

public class CallDialog extends DialogFragment {

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_call, null);
        final EditText editCallWho = view.findViewById(R.id.edit_call_who);
        final EditText editNumber = view.findViewById(R.id.edit_call_number);

        builder.setView(view)
                .setTitle(getResources().getString(R.string.fast_dialog))
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Note note = Note.builder()
                                .noteType("CallNote")
                                .name(editCallWho.getText().toString())
                                .description(editNumber.getText().toString())
                                .build();
                        DatabaseFunctions databaseFunctions = new DatabaseFunctions();
                        databaseFunctions.addNoteToDatabase(getActivity(), note);
                    }
                });

        return builder.create();
    }
}
