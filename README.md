camel-shutdown-test
===================

This project shows a Bug where Camle Routes will be stopped in the following situation:

1. Camel Context and Routes are created in a Parent Context
2. A Child Context is created using the Parent Context the Camel Context is created in
3. The Child Context is closed.

Camel Creates, Starts, and Stops Routes using Spring's Multicast Event.

The question is:  Is this the best way to manage the Routes?
