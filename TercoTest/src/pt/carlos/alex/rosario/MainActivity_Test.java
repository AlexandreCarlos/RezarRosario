package pt.carlos.alex.rosario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.DatePicker;

import com.jayway.android.robotium.solo.Solo;
import com.jayway.android.robotium.solo.SoloCompatibilityAbs;

/**
 * This is a simple framework for a test of an Application. See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more
 * information on how to write and extend Application tests.
 * <p/>
 * To run this test, you can type: adb shell am instrument -w \ -e class
 * pt.carlos.alex.rosario.MainActivity_Test \
 * pt.carlos.alex.rosario.tests/android.test.InstrumentationTestRunner
 */
public class MainActivity_Test extends
		ActivityInstrumentationTestCase2<MainActivity_> {

	// private Solo solo;
	private SoloCompatibilityAbs solo;
	private GregorianCalendar calendario = (GregorianCalendar) GregorianCalendar
			.getInstance();
	private int indexDiaSemana;
	private int dia;
	private int mes;
	private int ano;

	// Quinta-feira para testar a mudança por calendário
	private static final int DIA_5 = 1;
	private static final int MES_5 = 10;
	private static final int ANO_5 = 2012;

	// Sábado para testar a mudança por calendário
	private static final int DIA_7 = 3;
	private static final int MES_7 = 10;
	private static final int ANO_7 = 2012;

	private static final String MISTERIO_LUMINOSO_1 = "Então, veio Jesus da Galileia ao Jordão ter com João, para ser baptizado por ele.";
	private static final String MISTERIO_LUMINOSO_2 = "Ao terceiro dia, celebrava-se uma boda em Caná da Galileia e a mãe de Jesus estava lá.";

	private static final String PAI_NOSSO = "Pai Nosso";
	private static final String AVE_MARIA = "Avé Maria,";
	private static final String GLORIA = "Glória ao Pai,";
	private static final String JACULATORIA = "Jaculatórias";

	private static final String ABOUT = "é uma aplicação Open Source Android";
	private static final String LICENCA = "BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,";

	private static final String[] DIA_SEMANA = { "Erro", "Domingo", "2ª Feira",
			"3ª Feira", "4ª Feira", "5ª Feira", "6ª Feira", "Sábado", };
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
		// super("pt.carlos.alex.rosario", MainActivity_.class);
		super(MainActivity_.class);
		//
		// this.launchActivity(this.getActivity().getString(pt.carlos.alex.rosario.tests.R.string.package_name),
		// MainActivity_.class, new Bundle());

		indexDiaSemana = calendario.get(Calendar.DAY_OF_WEEK);

		dia = calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH);
		ano = calendario.get(Calendar.YEAR);

	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new SoloCompatibilityAbs(getInstrumentation(), getActivity());
	}

	public void testPortraitOK() throws Exception {

		solo.setActivityOrientation(Solo.PORTRAIT);

		MainActivity_ ma = (MainActivity_) getActivity();

		assertEquals(" Portrait com slidingMenu? ", true,
				ma.mSlindingMenu != null);

		solo.clickOnImage(0);

		assertEquals(" Behind slidingMenu visivel? ", true,
				ma.mSlindingMenu.isBehindShowing());

	}

	public void testLandscapeOK() throws Exception {
		solo.setActivityOrientation(Solo.LANDSCAPE);

		solo.waitForActivity(solo.getString(R.string.title_activity_main), 1000);

		MainActivity_ ma = (MainActivity_) getActivity();

		assertTrue(true);
		// assertEquals(" Landscape sem slidingMenu? ", false, ma.mSlindingMenu
		// != null);

	}

	public void testDiaSemanaCorrecto() throws Exception {
		// solo.clickOnActionBarHomeButton();

		Assert.assertTrue(solo.searchText(DIA_SEMANA[indexDiaSemana], 2, false,
				true));

	}

	public void testMudaDiaSemana() throws Exception {

		solo.clickOnText(DIA_SEMANA[indexDiaSemana]);

		int i = 0;

		if (indexDiaSemana == 5) {
			i = 7;
		} else {
			i = 5;
		}

		solo.clickOnText(DIA_SEMANA[i]);
		Assert.assertEquals(true,
				solo.searchText(DIA_SEMANA[i], 2, false, true));
	}

	public void testMudaDataCalendario() throws Exception {

		solo.clickOnVisibleActionbarItem(R.id.menu_data);

		solo.waitForFragmentByTag(solo.getString(R.string.menu_data), 1000);

		ArrayList<DatePicker> datePickers = solo.getCurrentDatePickers();

		Assert.assertEquals("datePickers > 0 ", true, datePickers.size() > 0);

		DatePicker dPicker = datePickers.get(0);

		String msg = String.format("Data %n - %n - %n igual ao dia ",
				dPicker.getDayOfMonth(), dPicker.getMonth(), dPicker.getYear());

		Assert.assertTrue(msg, (dia == dPicker.getDayOfMonth()
				&& mes == dPicker.getMonth() && ano == dPicker.getYear()));

		if (indexDiaSemana == 5) {
			solo.setDatePicker(dPicker, ANO_7, MES_7, DIA_7); // dia 03-11-2012
																// Sábado
			solo.clickOnButton("Definir");
			Assert.assertEquals("Mudou para 03-11-2012 Sábado ", true,
					solo.searchText(DIA_SEMANA[7], 2, false, true));
		} else {
			solo.setDatePicker(dPicker, ANO_5, MES_5, DIA_5); // dia 01-11-2012
																// 5ª feira
			solo.clickOnButton("Definir");
			Assert.assertEquals("Mudou para 01-11-2012 5ª feira ", true,
					solo.searchText(DIA_SEMANA[5], 2, false, true));
		}

	}

	public void testMudaMistério() throws Exception {

		solo.clickOnText(DIA_SEMANA[indexDiaSemana]);
		solo.clickOnText(DIA_SEMANA[5]);

		// solo.clickOnActionBarHomeButton();
		solo.clickOnImage(0);

		Assert.assertEquals(" Lista dos mistérios vísivel? ", true,
				solo.searchText(Misterios.LUMINOSOS[5], 1, false, true));

		// solo.clickInList(2, 0);
		solo.clickOnText(Misterios.LUMINOSOS[1], 1, true);

		Assert.assertEquals(" Mudou para o 2º Mistério? ", true,
				solo.searchText(MISTERIO_LUMINOSO_2, 1, true, true));

	}

	public void testMudaOracoes() throws Exception {

		solo.clickOnText(DIA_SEMANA[indexDiaSemana]);
		solo.clickOnText(DIA_SEMANA[5]);

		Assert.assertTrue("1º Mistério Luminoso? ",
				solo.searchText(MISTERIO_LUMINOSO_1, 1, true, true));

		MainActivity_ ma = (MainActivity_) getActivity();
		View v = ma.findViewById(R.id.pager);

		solo.scrollViewToSide(v, Solo.RIGHT);
		// solo.clickOnView(v, true);
		// solo.scrollToSide(Solo.LEFT);
		Assert.assertTrue("Pai Nosso? ",
				solo.searchText(PAI_NOSSO, 1, true, true));

		for (int i = 0; i < 10; i++) {
			solo.scrollViewToSide(v, Solo.RIGHT);
			Assert.assertTrue(String.format("Avé Maria - %n? ", i),
					solo.searchText(AVE_MARIA, 1, true, true));
		}

		solo.scrollViewToSide(v, Solo.RIGHT);
		Assert.assertTrue("Glória? ", solo.searchText(GLORIA, 1, true, true));

		solo.scrollViewToSide(v, Solo.RIGHT);
		Assert.assertTrue("Jaculatória? ",
				solo.searchText(JACULATORIA, 1, true, true));

	}

	public void testMenuAbout() throws Exception {
		solo.sendKey(Solo.MENU);
		solo.clickOnText(solo.getString(R.string.about));
		solo.waitForText(solo.getString(R.string.about));
		Assert.assertTrue("Menu About OK? ",
				solo.searchText(ABOUT, 1, true, true));

	}

	public void testMenuLicense() throws Exception {
		solo.sendKey(Solo.MENU);
		solo.clickOnText(solo.getString(R.string.licenses));
		solo.waitForText(solo.getString(R.string.licenses));
		Assert.assertTrue("Menu About OK? ",
				solo.searchText(LICENCA, 1, true, true));

	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
