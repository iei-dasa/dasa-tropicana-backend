# Build a webhook endpoint

Build a simple webhook endpoint to listen to events from Stripe. Included are some basic build and run scripts you can use to start up the application.

## Running the sample

0. Build the server

```
mvn package
```

1. Run the server

```
java -cp target/stripe-checkout-1.0.0-SNAPSHOT-jar-with-dependencies.jar com.stripe.sample.Server
```

2. Your webhook is now listening at http://localhost:4242/webhook.

3. Use the [Stripe CLI](https://stripe.com/docs/stripe-cli) or ngrok to test your new endpoint.
