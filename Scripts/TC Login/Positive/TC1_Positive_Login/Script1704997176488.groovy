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

'Buka Aplikasi Smart Residence'
new services.Steps().OpenMobileApps(GlobalVariable.Apk_File,true)
Mobile.takeScreenshot()

'Masukkan No. handphone'
Mobile.setText(findTestObject("Object Repository/Login/Input_No. Handphone"),No_HP, 2)
Mobile.takeScreenshot()

'Masukkan Kata Sandi'
Mobile.setEncryptedText(findTestObject("Object Repository/Login/Input_Kata Sandi"), Password, 2)
Mobile.takeScreenshot()

'Klik Button Masuk'
Mobile.tap(findTestObject("Object Repository/Login/Btn_Masuk"), 2)

'Verifikasi Login Berhasil dengan masuk ke halaman beranda dan nama pengguna telah sesuai'
Mobile.verifyElementExist(findTestObject("Object Repository/Beranda/Header_Title_Welcome"), 10,FailureHandling.CONTINUE_ON_FAILURE)
def nama_pengguna = Mobile.getText(findTestObject("Object Repository/Beranda/Header Title_Nama Pengguna"), 10,FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(nama_pengguna, Nama_pengguna)
Mobile.takeScreenshot()


new services.Steps().LogoutMobile()