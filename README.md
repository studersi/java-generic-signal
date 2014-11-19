Java Generic Signal
===================

Description:
------------
Light weight generic class to broadcast information to other objects.
When a Signal is emitted, all connected Slots are executed.
This way of coupling controllers to the model is looser (and easier to use)
than extending Observable and implementing Observer.
This mimics, to a certain extent, the behavior of the Signals and Slots
in the QT framework.
This system of Signals and Slots is type safe because the Slot
interface is integrated into the Signal class.

Contents:
---------
The repository contains the Signal.java class that contains the actual code for the signals. It also contains a class called BasicExample.java that demonstrates how the Signal.java class can be used.

Requirements:
-------------
- Java JDK 7 or higher

Setup & Execution:
------
- git clone git@github.com:studersi/java-generic-signal.git
- cd java-generic-signal/
- javac BasicExample.java
- java BasicExample