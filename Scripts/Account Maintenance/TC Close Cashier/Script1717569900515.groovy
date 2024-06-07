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


WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/a_Open Close Cashier'))

WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/button close'))

String endbalance = WebUI.getText(findTestObject('Object Repository/Menu/Account Maintenance/List Menu/end bal amount'))

println(endbalance)

WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/input_On Hand Amount'))

TestObject inputField = findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/input_On Hand Amount')

WebUI.click(inputField)

WebUI.sendKeys(inputField, Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(inputField, Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/input_On Hand Amount'), 
    endbalance) 

WebUI.setText(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/input_Cashier Password'), GlobalVariable.Password)

WebUI.click(findTestObject('Object Repository/Menu/Account Maintenance/Close Cashier/button_Cashier Close'))



