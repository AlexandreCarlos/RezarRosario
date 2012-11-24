package pt.carlos.alex.rosario;

import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class pt.carlos.alex.rosario.MainActivity_Test \
 * pt.carlos.alex.rosario.tests/android.test.InstrumentationTestRunner
 */
public class MainActivity_Test extends ActivityInstrumentationTestCase2<MainActivity_> {

    public MainActivity_Test() {
//        super("pt.carlos.alex.rosario", MainActivity_.class);
        super (MainActivity_.class);

        this.launchActivity(this.getActivity().getString(pt.carlos.alex.rosario.tests.R.string.package_name), MainActivity_.class, new Bundle());
    }

}
