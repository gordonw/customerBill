import com.gargoylesoftware.htmlunit.BrowserVersion
import org.openqa.selenium.htmlunit.HtmlUnitDriver

baseUrl = "http://localhost:8080/"

reportsDir = "build/reports/geb"

def forcedLocale = 'en-gb'
driver = {
	BrowserVersion browserVersion = BrowserVersion.getDefault()
	browserVersion.setBrowserLanguage(forcedLocale)
	browserVersion.setSystemLanguage(forcedLocale)
	browserVersion.setUserLanguage(forcedLocale)
	def driverInstance = new HtmlUnitDriver(browserVersion)
	driverInstance
}
