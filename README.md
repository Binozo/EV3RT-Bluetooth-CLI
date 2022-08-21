# EV3RT-Bluetooth-CLI
A simple utility which communicates with [EV3RT-Bluetooth-Console](https://github.com/Binozo/EV3RT-Bluetooth-Console).
See also [EV3RT-Bluetooth-Console-App](https://github.com/Binozo/EV3RT-Bluetooth-Console-App).

Take a look at the [EV3RT-Project](https://ev3rt-git.github.io/about/).
## System requirements
- Java 8 or higher (`sudo apt install openjdk-18-jre-headless`)
- A working Bluetooth driver
- `libbluetooth-dev` (`sudo apt install libbluetooth-dev`)

## Installation
Download the latest jar from the [releases page](https://github.com/Binozo/EV3RT-Bluetooth-CLI/releases) and place it wherever you want to execute it.

## Usage
### To get the application Version:
```bash
java -jar ev3rt-bluetooth-cli.jar -v
```

### To connect to an ev3:
Please note:
- The target ev3 must already be paired with your system.
- `<bluetooth-address>` has to be in the following format: `XX:XX:XX:XX:XX:XX`

```bash
java -jar ev3rt-bluetooth-cli.jar <bluetooth-address>
```
