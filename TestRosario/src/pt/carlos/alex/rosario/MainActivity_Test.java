package pt.carlos.alex.rosario;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import com.jayway.android.robotium.solo.Solo;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

    private Solo solo;
    private GregorianCalendar calendario = (GregorianCalendar) GregorianCalendar.getInstance();
    private int indexDiaSemana;
    private int dia;
    private int mes;
    private int ano;
    private static final String[] DIA_SEMANA = { "Erro",
            "Domingo",
            "2ª Feira",
            "3ª Feira",
            "4ª Feira",
            "5ª Feira",
            "6ª Feira",
            "Sábado",
    };
    private static final int[] MISTERIOS = { -1, // Erro ???
            0, // Domingo - Mistérios Gloriosos (da Glória)
            1, // 2ª Feira - Mistérios Gozosos (da Alegria)
            2, // 3ª Feira - Mistérios Dolorosos (da Dor)
            0, // 4ª Feira - Mistérios Gloriosos (da Glória)
            3, // 5ª Feira - Mistérios Luminosos (da Luz)
            2, // 6ª Feira - Mistérios Dolorosos (da Dor)
            1 // Sábado - Mistérios Gozosos (da Alegria)
    };
    private static final String[] DESIGN = { "Mistérios Gloriosos", // 0
            "Mistérios Gozosos", // 1
            "Mistérios Dolorosos", // 2
            "Mistérios Luminosos" // 3
    };

    public MainActivity_Test() {
//        super("pt.carlos.alex.rosario", MainActivity_.class);
        super (MainActivity_.class);
//
//        this.launchActivity(this.getActivity().getString(pt.carlos.alex.rosario.tests.R.string.package_name), MainActivity_.class, new Bundle());

        indexDiaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testDiaSemanaCorrecto() throws Exception {
//        solo.clickOnActionBarHomeButton();

        Assert.assertTrue(solo.searchText(DIA_SEMANA[indexDiaSemana], 2, false, true));

    }

    public void testMudaDiaSemana() throws Exception {

//        solo.clickOnActionBarItem(R.layout.sherlock_spinner_dropdown_item);
//        solo.sendKey(Solo.UP);
//        solo.sendKey(Solo.ENTER);

        solo.clickOnText(DIA_SEMANA[indexDiaSemana]);

        int i = 0;

        if (indexDiaSemana == 5){
            i = 7;
        }   else {
            i = 5;
        }

        solo.clickOnText(DIA_SEMANA[i]);
        Assert.assertEquals(true, solo.searchText(DIA_SEMANA[i], 2, false, true));
    }

    public void testMudaDataCalendario() throws Exception {

        solo.setActivityOrientation(Solo.LANDSCAPE);
//        solo.clickOnMenuItem(solo.getString(R.string.menu_data));

        solo.clickOnActionBarItem(R.id.menu_data);

        Assert.assertTrue("Apareceu Datepickr",solo.waitForText("Definir", 1, 1000l));
//        solo.clickOnText(solo.getString(R.string.menu_data));

        ArrayList<DatePicker> datePickers = solo.getCurrentDatePickers();

        Assert.assertEquals("datePickers > 0", true, datePickers.size() > 0);

        DatePicker dPicker = datePickers.get(0);

//        boolean b = false;
//
//       if (dia == dPicker.getDayOfMonth() &&
//               mes == dPicker.getMonth()   &&
//               ano == dPicker.getYear()) {
//           b = true;
//       }

        String msg = String.format("Data %n - %n - %n igual ao dia",
                dPicker.getDayOfMonth(),
                dPicker.getMonth(),
                dPicker.getYear());
        Assert.assertTrue(msg, (dia == dPicker.getDayOfMonth() &&
                mes == dPicker.getMonth()   &&
                ano == dPicker.getYear()));
    }


        @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

}
