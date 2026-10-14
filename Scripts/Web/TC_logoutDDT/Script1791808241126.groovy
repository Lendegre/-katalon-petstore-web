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
WebUI.navigateToUrl("https://petstore.octoperf.com/actions/Catalog.action")
WebUI.click(findTestObject('signInPage/a_Sign In'))
WebUI.delay(2)
WebUI.setText(findTestObject ('Object Repository/signInPage/input_Username'), username)
WebUI.setText(findTestObject ('Object Repository/signInPage/input_Password'), password)
WebUI.click(findTestObject('signInPage/btn_login'))





//Jika user input valid credentials maka verify dashboard
//Jika user input invalid credentials maka verify error
if (testType && testType.toString().trim().equalsIgnoreCase("P")) {
	WebUI.click(findTestObject('dashboardPage/btn_logout'))
	WebUI.verifyTextPresent('Sign In', false, FailureHandling.STOP_ON_FAILURE)
} else {
	WebUI.delay(3)
	WebUI.verifyElementVisible(findTestObject('Object Repository/sigInPage/btn_login'))
}