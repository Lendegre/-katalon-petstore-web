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

WebUI.openBrowser("")
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.URL_JPetStore)
WebUI.click(findTestObject('signInPage/a_Sign In'))
WebUI.delay(2)
WebUI.setText(findTestObject ('Object Repository/signInPage/input_Username'),GlobalVariable.Valid_Uss)
WebUI.setText(findTestObject ('Object Repository/signInPage/input_Password'),GlobalVariable.Valid_Pass)
WebUI.click(findTestObject('signInPage/btn_login'))
WebUI.click(findTestObject('dashboardPage/img_fish'))
WebUI.click(findTestObject('fishMenu/fish_Goldfish'))
WebUI.click(findTestObject('fishMenu/adultMaleGoldfish'))
WebUI.click(findTestObject('fishMenu/btn_AddtoCart'))
WebUI.delay(2)
WebUI.click(findTestObject('cartPage/btn_ProceedtoCheckout'))
WebUI.click(findTestObject('detailOrderPage/btn_Continue'))


if (testType && testType.toString().trim().equalsIgnoreCase("P")) {
	WebUI.click(findTestObject('confirmPage/btn_Confirm'))
	WebUI.verifyTextPresent('Thank you, your order has been submitted.', false, FailureHandling.STOP_ON_FAILURE)
} else {
	WebUI.click(findTestObject('detailOrderPage/btn_mainMenu'))
	WebUI.verifyTextPresent('Welcome ABC!', false, FailureHandling.STOP_ON_FAILURE)
}