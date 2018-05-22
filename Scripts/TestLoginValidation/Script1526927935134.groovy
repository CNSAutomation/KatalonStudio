import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://automationpractice.com/index.php')

WebUI.click(findTestObject('Page_My Store/a_Sign in'))

//WebUI.verifyElementText(findTestObject('Page_Login - My Store/li_An email address required.'), 'An email address required.')
println 'TestCase Started'
for (def row = 1; row <= findTestData('LoginTestsData').getRowNumbers(); row++) {
    rowname = findTestData('LoginTestsData').getValue('TestCaseName', row)
	println ('TestCasename' +rowname)
    if (rowname.equalsIgnoreCase('Test_Blank_Login')) {
		if((findTestData('LoginTestsData').getValue('Email',row)) != ''){
        	WebUI.setText(findTestObject('Page_Login - My Store/input_email'), findTestData('LoginTestsData').getValue('Email', 
                row))
		}

       // WebUI.setText(findTestObject('Page_Login - My Store/input_password'), findTestData('LoginTestsData').getValue('Password',row))
		WebUI.click(findTestObject('Page_Login - My Store/span_Sign in'))
        WebUI.verifyElementText(findTestObject('Page_Login - My Store/li_An email address required.'), 'An email address required.')
    
    }
    
    if (rowname.equalsIgnoreCase('Test_Blank_Pwd')) {
        WebUI.setText(findTestObject('Page_Login - My Store/input_email'), findTestData('LoginTestsData').getValue('Email', 
                row))
		
		if((findTestData('LoginTestsData').getValue('Password',row)) != ''){
        WebUI.setText(findTestObject('Page_Login - My Store/input_password'), findTestData('LoginTestsData').getValue('Password', 
                row))
		}

		WebUI.click(findTestObject('Page_Login - My Store/span_Sign in'))
        WebUI.verifyElementText(findTestObject('Page_Login - My Store/li_Password is required.'), 'Password is required.')

    }
    
    if (rowname.equalsIgnoreCase('Test_InValid_Email')) {
        WebUI.setText(findTestObject('Page_Login - My Store/input_email'), findTestData('LoginTestsData').getValue('Email', 
                row))

        WebUI.setText(findTestObject('Page_Login - My Store/input_password'), findTestData('LoginTestsData').getValue('Password', 
                row))

        WebUI.click(findTestObject('Page_Login - My Store/span_Sign in'))

        WebUI.verifyElementText(findTestObject('Page_Login - My Store/li_Invalid email address.'), 'Invalid email address.')
    }
    
    if (rowname.equalsIgnoreCase('Test_InValid_Login')) {
        WebUI.setText(findTestObject('Page_Login - My Store/input_email'), findTestData('LoginTestsData').getValue('Email', 
                row))

        WebUI.setText(findTestObject('Page_Login - My Store/input_password'), findTestData('LoginTestsData').getValue('Password', 
                row))

        WebUI.click(findTestObject('Page_Login - My Store/span_Sign in'))

        WebUI.verifyElementText(findTestObject('Page_Login - My Store/li_Authentication failed.'), 'Authentication failed.')
    }
    
    if (rowname.equalsIgnoreCase('Test_Valid_Login')) {
        WebUI.setText(findTestObject('Page_Login - My Store/input_email'), findTestData('LoginTestsData').getValue('Email', 
                row))

        WebUI.setText(findTestObject('Page_Login - My Store/input_password'), findTestData('LoginTestsData').getValue('Password', 
                row))

        WebUI.click(findTestObject('Page_Login - My Store/span_Sign in')) //WebUI.verifyElementText(findTestObject('Page_Login - My Store/li_Authentication failed.'), 'Authentication failed.')
    }
}
    WebUI.closeBrowser()


