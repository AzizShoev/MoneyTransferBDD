package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MoneyTransferTest {
    private final String card1 = "92df3f1c-a033-48e6-8390-206f6b1f56c0";
    private final String card2 = "0f3f5c2a-249e-4c3d-8287-09f7a039391d";


    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var authCard = DataHelper.getCardInfo();
        var transfer = new MoneyTransfer();
        var dashPage = new DashboardPage();
        int expectedCard1 = dashPage.getCardBalance(card1) + 1;
        int expectedCard2 = dashPage.getCardBalance(card2) - 1;
        transfer.amountCard1(authCard, "1");

        assertEquals(expectedCard1, dashPage.getCardBalance(card1));
        assertEquals(expectedCard2, dashPage.getCardBalance(card2));
    }
    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var authCard = DataHelper.getCardInfo();
        var transfer = new MoneyTransfer();
        var dashPage = new DashboardPage();
        int expectedCard1 = dashPage.getCardBalance(card1) - 10000;
        int expectedCard2 = dashPage.getCardBalance(card2) + 10000;
        transfer.amountCard2(authCard, "10000");

        assertEquals(expectedCard1, dashPage.getCardBalance(card1));
        assertEquals(expectedCard2, dashPage.getCardBalance(card2));
    }
}

