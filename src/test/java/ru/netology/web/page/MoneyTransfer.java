package ru.netology.web.page;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransfer {
    public MoneyTransfer amountCard1 (DataHelper.CardInfo card, String amount) {
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button").click();
        $("[data-test-id='amount'] input").setValue(amount);
        $("[data-test-id='from'] input").setValue(card.getSecondCardInfo());
        $("[data-test-id='action-transfer']").click();
        return new MoneyTransfer();
    }
    public MoneyTransfer amountCard2 (DataHelper.CardInfo card, String amount) {
        $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button").click();
        $("[data-test-id='amount'] input").setValue(amount);
        $("[data-test-id='from'] input").setValue(card.getFirstCardInfo());
        $("[data-test-id='action-transfer']").click();
        return new MoneyTransfer();
    }
}
