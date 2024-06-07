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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData Datahohendy = findTestData('Data Files/Open Close Cashier/Open Cashier')

//WebUI.click(findTestObject('null'))

for (int baris = 1; baris <= Datahohendy.getRowNumbers(); baris++)
{
	if (Datahohendy.getValue('Use', baris) == 'Yes')
	{		
			WebUI.switchToDefaultContent()
		
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Open Cashier/select_cashier'))
			
			WebUI.delay(1)

			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Open Cashier/Cashier Name/Cashier ' + Datahohendy.getValue('Cashier', baris)))
		
			WebUI.switchToDefaultContent()
			
			WebUI.delay(2)
			
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Open Cashier/List JenisUang'))
			
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Open Cashier/OpeningAmount/Mata Uang ' + Datahohendy.getValue('Opening Amount', baris)))
		
			WebUI.switchToDefaultContent()
			
			WebUI.delay(2)
			
			WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Open Cashier/input_Opening Amount'), Datahohendy.getValue('Input Amount', baris))
			
			WebUI.switchToDefaultContent()
			
			WebUI.delay(2)
			
			WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/input_Cashier Password'), GlobalVariable.Password)
			
			WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Open Cashier/button_Cashier Open'))
		
	}
}


