package kamilbieg.studentorganizer.DialogFragments;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

public class DialogFunctions {

    public static void notifyToTarget(int code, DialogFragment dialogFragment) {
        Fragment targetFragment = dialogFragment.getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(dialogFragment.getTargetRequestCode(), code, null);
        }
    }
}
