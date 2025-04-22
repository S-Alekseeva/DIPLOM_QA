package ru.netology.data;

import static ru.netology.data.DataHelper.authInfo;


import ru.netology.page.AboutPage;
import ru.netology.page.AuthorizationPage;
import ru.netology.page.ControlPanelPage;
import ru.netology.page.MainPage;
import ru.netology.page.NewsPage;
import ru.netology.page.OurMissionPage;

public class LoadingScreen {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    MainPage mainPage = new MainPage();

    NewsPage newsPage = new NewsPage();

    ControlPanelPage controlPanelPage = new ControlPanelPage();

    AboutPage aboutPage = new AboutPage();

    OurMissionPage ourMissionPage = new OurMissionPage();

    public void readyAuthorizationScreen() {
        try {
            authorizationPage.checkLoadScreen();
            authorizationPage.authorizationScreen();
        } catch (Exception e) {
            mainPage.clickExitButton();
            authorizationPage.authorizationScreen();
        }
    }

    public void readyMainScreen() {
        try {
            mainPage.checkMainScreenLoaded();
        } catch (Exception e) {
            authorizationPage.validAuthorization(authInfo());
        } finally {
            mainPage.checkMainScreenLoaded();
        }
    }

    public void readyNewsScreen() {
        try {
            mainPage.checkMainScreenLoaded();
            mainPage.goToNews();
        } catch (Exception e) {
            authorizationPage.validAuthorization(authInfo());
            mainPage.goToNews();
        } finally {
            newsPage.checkNewsScreenLoaded();
        }
    }

    public void readyControlPanelScreen() {
        try {
            mainPage.checkMainScreenLoaded();
            mainPage.goToNews();
            newsPage.goToControlPanel();
        } catch (Exception e) {
            authorizationPage.validAuthorization(authInfo());
            mainPage.goToNews();
            newsPage.goToControlPanel();
        } finally {
            controlPanelPage.checkControlPanelScreenLoaded();
        }
    }

    public void readyAboutScreen() {
        try {
            mainPage.checkMainScreenLoaded();
            mainPage.goToAbout();
        } catch (Exception e) {
            authorizationPage.validAuthorization(authInfo());
            mainPage.goToAbout();
        } finally {
            aboutPage.checkAboutScreenLoaded();
        }
    }

    public void readyOurMissionScreen() {
        try {
            mainPage.checkMainScreenLoaded();
            mainPage.goToOurMission();
        } catch (Exception e) {
            authorizationPage.validAuthorization(authInfo());
            mainPage.goToOurMission();
        } finally {
            ourMissionPage.checkOurMissionScreenLoaded();
        }
    }
}