package Helper;

public class AppStoreHelper {
    public static final String GAMESTABHOMESCREEN = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/games_chip\")";
    public static final String APPSTABHOMESCREEN = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/apps_chip\")";
    public static final String APPSECTIONSHOMESCREEN = "xpath==//android.widget.TextView[@resource-id=\"cm.aptoide.pt:id/bundle_title\" and @text=\"{REPLACE}\"]";
    public static final String HOMESCREENNAVIGATIONTAB = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/largeLabel\")";
    public static final String EDITORIALSCREENNAVIGATIONTAB = "AndroidUiAutomator==new UiSelector().text(\"Editorial\")";
    public static final String SEARCHSCREENNAVIGATIONTAB = "AndroidUiAutomator==new UiSelector().text(\"Search\")";
    public static final String STORESSCREENNAVIGATIONTAB = "AndroidUiAutomator==new UiSelector().text(\"Stores\")";
    public static final String APPNAVIGATIONTAB = "AndroidUiAutomator==new UiSelector().text(\"Apps\")";
    public static final String APPLISTHOMESCREEN = "id==cm.aptoide.pt:id/apps_list";
    public static final String TOPGAMESHEADER = "AndroidUiAutomator==new UiSelector().text(\"Top Games\")";
    public static final String LISTOFAPPSINGAMESANDAPPS = "id==cm.aptoide.pt:id/top_number";
    public static final String TOPAPPSHEADER = "AndroidUiAutomator==new UiSelector().text(\"Top Apps\")";
    public static final String HOMESCREENTEXT = "id==cm.aptoide.pt:id/bundle_title";
    public static final String MORETRENDINGAPPSBUTTON = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/bundle_more\").instance(0)";
    public static final String TRENDINGAPPSECTION = "AndroidUiAutomator==new UiSelector().className(\"android.widget.LinearLayout\").instance(17)";
    public static final String TRENDINGGAMESECTION = "AndroidUiAutomator==new UiSelector().className(\"android.widget.LinearLayout\").instance(4)";
    public static final String MOREBUTTONINTRENDINGPAGE = "id==cm.aptoide.pt:id/bundle_more";
    public static final String GAMESANDAPPSSECTIONINTREDING = "xpath==//android.widget.TextView[@resource-id=\"cm.aptoide.pt:id/bundle_title\"]";
    public static final String BOARDGAMESSECTIONINTREDING = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/bundle_more\").instance(1)";
    public static final String LISTOFBOARDGAMES = "id==cm.aptoide.pt:id/name";
    public static final String LISTOFFITNESSAPPS = "id==cm.aptoide.pt:id/name";
    public static final String MEDICALINTRENDING = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/bundle_more\").instance(1)";
    public static final String SYSTEMINSTALLEDAPPHEADER = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/apps_header_title\")";
    public static final String SYSTEMINSTALLEDAPPS = "id==cm.aptoide.pt:id/apps_installed_icon";
    public static final String SYSTEMINSTALLEDAPPSNAME = "id==cm.aptoide.pt:id/apps_installed_app_name";
    public static final String SYSTEMINSTALLEDAPPSVERSION = "id==cm.aptoide.pt:id/apps_installed_app_version";
    public static final String EDITORIALAPPS = "id==cm.aptoide.pt:id/editorial_card";
    public static final String FOLLOWEDSTOREHEADER = "AndroidUiAutomator==new UiSelector().text(\"Followed stores\")";
    public static final String RECOMMENDEDSTORESHEADER = "AndroidUiAutomator==new UiSelector().text(\"Recommended stores\")";
    public static final String LOGINBUTTON = "id==cm.aptoide.pt:id/login_button";
    public static final String LOGINWITHFACEBOOK = "accessibilityId==Log in with Facebook";
    public static final String LOGINWITHGOOGLE = "accessibilityId==Google";
    public static final String LOGINWITHEMAIL = "id==cm.aptoide.pt:id/show_login_with_aptoide_area";
    public static final String TNCCHECKBOX = "id==cm.aptoide.pt:id/tc_checkbox";
    public static final String LOGINERRORSNACKBAR = "id==cm.aptoide.pt:id/snackbar_text";
    public static final String EMAILENTRYBOX = "id==cm.aptoide.pt:id/email";
    public static final String SENDMAGICLINKBUTTONFORLOGIN = "id==cm.aptoide.pt:id/send_magic_link_button";
    public static final String SEARCHAPPINPUTBOX = "id==cm.aptoide.pt:id/search_src_text";
    public static final String SEARCHRESULTAPPNAME = "id==cm.aptoide.pt:id/search_suggestion_app_name";
    public static final String SEARCHSELECTEDAPPS = "AndroidUiAutomator==new UiSelector().className(\"android.view.ViewGroup\").instance(2)";
    public static final String APPSHAREBUTTON = "id==cm.aptoide.pt:id/menu_item_share";
    public static final String APPINSTALLBUTTON = "id==cm.aptoide.pt:id/appview_install_button";
    public static final String APPNAME = "id==cm.aptoide.pt:id/app_name";
    public static final String APPDESCRIPTION = "id==cm.aptoide.pt:id/description_text";
    public static final String APPIMAGES = "id==cm.aptoide.pt:id/media_layout";
    public static final String APPRATING = "id==cm.aptoide.pt:id/header_rating";
    public static final String APPVERSION = "id==cm.aptoide.pt:id/latest_version";
    public static final String APPDOWNLOADS = "id==cm.aptoide.pt:id/header_downloads";
    public static final String APPRATINGCOUNT = "id==cm.aptoide.pt:id/rating_value";
    public static final String APPREVIEWCOMMENTS = "AndroidUiAutomator==new UiSelector().className(\"android.widget.RelativeLayout\").instance(6)";
    public static final String APPSHAREOPTIONS = "id==android:id/icon";


//    public static final String APPNAME = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_name\")";
//    public static final String APPDESCRIPTION = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_description\")";
//    public static final String APPRATING = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_rating\")";
//    public static final String APPVERSION = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_version\")";
//    public static final String APPSIZE = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_size\")";
//    public static final String APPRATINGCOUNT = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_rating_count\")";
//    public static final String APPSCREENSHOTS = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_screenshots\")";
//    public static final String APPREVIEW = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_review\")";
//    public static final String APPREVIEWCOUNT = "AndroidUiAutomator==new UiSelector().resourceId(\"cm.aptoide.pt:id/app_review_count\")";
//    public static final String APPREVIEWRATING = "AndroidUiAutomator==new UiSelector().resourceId(\"
}
