package io.quarkus.samples.petclinic.payment;

import java.util.Objects;
import java.util.concurrent.TimeoutException;
import com.hedera.hashgraph.sdk.*;
import io.github.cdimascio.dotenv.Dotenv;

public final class HederaTransfer {

    // see `.env.sample` in the repository root for how to specify these values
    // or set environment variables with the same names
    private static final AccountId OPERATOR_ID = AccountId.fromString(Objects.requireNonNull(Dotenv.load().get("OPERATOR_ID")));
    private static final PrivateKey OPERATOR_KEY = PrivateKey.fromString(Objects.requireNonNull(Dotenv.load().get("OPERATOR_KEY")));
    private static final String HEDERA_NETWORK = Dotenv.load().get("HEDERA_NETWORK");
    private static final String CONFIG_FILE = Dotenv.load().get("CONFIG_FILE");

    // private TransferCryptoExample() {
    // }

    public static void main(String[] args) throws TimeoutException, PrecheckStatusException, ReceiptStatusException {
        Client client;

        if (HEDERA_NETWORK != null && HEDERA_NETWORK.equals("previewnet")) {
            client = Client.forPreviewnet();
        } else {
            try {
                client = Client.fromConfigFile(CONFIG_FILE != null ? CONFIG_FILE : "");
            } catch (Exception e) {
                client = Client.forTestnet();
            }
        }

        // Defaults the operator account ID and key such that all generated transactions will be paid for
        // by this account and be signed by this key
        client.setOperator(OPERATOR_ID, OPERATOR_KEY);

        AccountId recipientId = AccountId.fromString("0.0.3");
        Hbar amount = Hbar.fromTinybars(10_000);

        Hbar senderBalanceBefore = new AccountBalanceQuery()
            .setAccountId(OPERATOR_ID)
            .execute(client)
            .hbars;

        Hbar receiptBalanceBefore = new AccountBalanceQuery()
            .setAccountId(recipientId)
            .execute(client)
            .hbars;

        System.out.println("" + OPERATOR_ID + " balance = " + senderBalanceBefore);
        System.out.println("" + recipientId + " balance = " + receiptBalanceBefore);

        TransactionResponse transactionResponse = new TransferTransaction()
            // .addSender and .addRecipient can be called as many times as you want as long as the total sum from
            // both sides is equivalent
            .addHbarTransfer(OPERATOR_ID, amount.negated())
            .addHbarTransfer(recipientId, amount)
            .setTransactionMemo("transfer test")
            .execute(client);

        System.out.println("transaction ID: " + transactionResponse);

        TransactionRecord record = transactionResponse.getRecord(client);

        System.out.println("transferred " + amount + "...");

        Hbar senderBalanceAfter = new AccountBalanceQuery()
            .setAccountId(OPERATOR_ID)
            .execute(client)
            .hbars;

        Hbar receiptBalanceAfter = new AccountBalanceQuery()
            .setAccountId(recipientId)
            .execute(client)
            .hbars;

        System.out.println("" + OPERATOR_ID + " balance = " + senderBalanceAfter);
        System.out.println("" + recipientId + " balance = " + receiptBalanceAfter);
        System.out.println("Transfer memo: " + record.transactionMemo);
    }
}
