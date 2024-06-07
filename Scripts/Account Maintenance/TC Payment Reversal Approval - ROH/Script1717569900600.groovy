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

TestData Datahohendy = findTestData('Data Files/Payment Reversal/Payment Reversal - Approval')

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/a_Payment Reversal Approval'))

for (int baris = 1; baris <= Datahohendy.getRowNumbers(); baris++)
	{
	if (Datahohendy.getValue('Use', baris) == 'No') {
		
		WebUI.switchToDefaultContent()
		
		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/input_Agreement No'), Datahohendy.getValue('Agreement No', baris))
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/button_search'))

		WebUI.switchToDefaultContent()
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/button_proses'))
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/Action/select_action approval'))
		
		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/Action/approval_'+ Datahohendy.getValue('Action Approval', baris)))
		
		WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/input_Notes'), Datahohendy.getValue('Notes Approval', baris))

		WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Payment Reversal/Payment Reversal Approval Task/button_Submit'))
		
		}
	}