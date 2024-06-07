import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat
import java.util.Date

WebUI.switchToDefaultContent()

	// untuk convert dan get bisnis date yang ada pada sistem testing
	String str = WebUI.getText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/span_Tuesday, 21 May 2024'))
	println(str)
	String[] parts = str.split(" ")// ambil parameter start buat motong
	String dayBeforeMonday = parts[0].trim()
	int lengthOfString1 = dayBeforeMonday.length()
	int lengthOfString2 = str.length() // ambil parameter start buat motong, total jumlah karakter pada bisnis date
	String Tanggal = str.substring(lengthOfString1, lengthOfString2) // start ambil motong dari bisnis date, ambil tanggal ajah
	println(Tanggal)
	String trimmedDateString = Tanggal.trim() // di trim, di hilangkan space depan nya
	println(trimmedDateString)
	def inputDateString = trimmedDateString
	def inputFormat = new SimpleDateFormat("dd MMMM yyyy")
	def outputFormat = new SimpleDateFormat("dd/MM/yyyy")
	def date = inputFormat.parse(inputDateString)
	def TanggalBisnisdate = outputFormat.format(date)
	println(TanggalBisnisdate)
	// untuk convert dan get bisnis date yang ada pada sistem testing


TestData Datahohendy = findTestData('Data Files/Payment Receive/Payment Receive')
TestData ParamDB1 = findTestData('Data Files/Connect Agreement No')

WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/button_Payment Receive'))

for (int baris = 1; baris <= Datahohendy.getRowNumbers(); baris++)
	{
	if (Datahohendy.getValue('Use', baris) == 'No') {
		
		if (Datahohendy.getValue('Way Of Payment', baris) == 'Bank'){
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/select_wop'))
			
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/Way Of Payment/Wop Bank'))
		}
			else {
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/Way Of Payment/Wop Cash'))
			}
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/select_account name'))
		
		if (Datahohendy.getValue('Use', baris) == 'No'){
				WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/Account Name/AN BCA IN Kedoya-IDR-2183010905'))
		}
			else {
				WebUI.click(findTestObject('Object Repository/Menu/Cashier/Payment Receive/Account Name/AN '+ Datahohendy.getValue('Account Name', baris)))
			}
			
		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_Value Date'), TanggalBisnisdate)
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/button Next'))
			
		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_Agreement No'), ParamDB1.getValue('AGRMNT_NO', 1))
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/button_search'))
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/action_edit'))
			
		if (Datahohendy.getValue('Use', baris) == 'No') {
		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_Receive From'), Datahohendy.getValue('Receive From', baris))

		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_notes'), Datahohendy.getValue('Notes', baris))
		}
			
			
		// Batasan nilai maksimum yang diizinkan oleh tipe data integer
		def maxValue = Integer.MAX_VALUE
		
		// Buat objek Randoms
		def random = new Random()
		
		// Menghasilkan nilai acak dari rentang 1 sampai maxValue
		def randomValue = random.nextInt(maxValue) + 1
		
		// Set text input dengan nilai yang baru
		WebUI.setText(findTestObject("Object Repository/Menu/Account Maintenance/Payment Receive/input_Reference No"), randomValue.toString())

			
		//-------------
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/button tambah agr info'))
		WebUI.delay(2)
		number = WebUI.getText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/a_IDR 1,627,500.00'))
		println(number)
		//String originalString = "1000 IDR";
		
		String replacedString = number.replace("IDR ", "");
		println(replacedString);
		
		String replacedString1 = replacedString.replace(".00", "");
		println(replacedString1);
		
		String replacedString2 = replacedString1.replace(",", "");
		println(replacedString2);
		
		WebUI.delay(2)
		//--------------
		
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_Receive Amount'))

		TestObject inputField = findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_Receive Amount')
		
		WebUI.click(inputField)
		
		WebUI.sendKeys(inputField, Keys.chord(Keys.CONTROL, 'a'))
		
		WebUI.sendKeys(inputField, Keys.chord(Keys.BACK_SPACE))
		
		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/input_Receive Amount'),  replacedString2)

		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/button_Calculate'))
			
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Receive/a_Submit'))
		
	}
}