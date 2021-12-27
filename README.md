# rpi-ws2812b-matrix

## Introduction
A 12x6 grid of WS2812B LEDs was built on a wooden board. Each LED is run in parallel with a maximum amperage usage of 60mA and so the total amperage
required by the power supply is 4.32A. The color of LEDs are controlled by GPIO 18 (PWM) connected to the data line input of the board.

This program is built to control the color of LEDs. It is dependent on the Adafruit NeoPixels library for Python. The intention is to write a
backend server in Kotlin to allow the LEDs to be controlled on a website and to write a game in Kotlin / C++ that outputs color to the pixels. To avoid
having to write a custom hardware library for each language to write to the GPIO pins, this project performs socket programming with Python as
the server to accept LED writing requests to write to GPIO pins. gRPC is used as the underlying IPC library.

This is a barebones example project to set up a Raspberry Pi to get the WS2812B LED grid working.

### Built with
 * Python 3.x+
 * Kotlin 1.6+ with Kotlin Coroutines
 * gRPC / Protobuf

## Setup
Install the required libraries from `requirements.txt` by running `pip3 install -r requirements.txt`. `protoc` should also be installed on your system
in order to regenerate protobuf files.

To generate protobuf files for Python, run the file `proto/gen_py`. To setup protobuf to compile for Kotlin, follow the steps outlined
[here](https://github.com/grpc/grpc-java/tree/v1.42.1/compiler) to setup protobuf for Java, and [here](https://github.com/grpc/grpc-kotlin/tree/master/compiler)
to set up protobuf for Kotlin. The script `proto/gen_kt` has information on the naming of the files. The generated files should be placed in its
own project accordingly.

## Programming
The services implemented in Protobuf are `Initialize` and `WriteData`. `Initialize` takes in two messages: LED data to be displayed on each cell of the grid, and
the mapping `(row, col) -> index` of the LED. This mapping exists because the LEDs that are joined on the board may differ for each construction. For example,
the LEDs may be constructed in a zig-zag pattern (end of row points back to column 1), or it may be constructed in an S pattern (end of row goes to next row with
same column, but now goes backward). `WriteData` only takes in the LED data.

## Wiring
The +5V line of the LEDs should be connected to a 5V power supply capable of powering all LEDs. The program is currently configured to write data to GPIO 18.
The data line input should be connected to GPIO 18. GND of the Raspberry Pi and the power supply should be joined.

## Issues

**Issue: Running the server raises ``ImportError: /lib/arm-linux-gnueabihf/libc.so.6: version `GLIBC_2.33' not found``**

**Solution:** Install `grpcio` and `grpcio-tools` with the flag `--no-binary :all:`.

**I: Initialization over gRPC raises `RuntimeError: NeoPixel support requires running with sudo, please try again!` on the server**

**S:** Run the server with sudo permissions.

**I: Initialization / Writing over gRPC raises `RuntimeError: ws2811_init failed with code -11 (Selected GPIO not possible)`**

**S:** Verify that the GPIO pin selected supports PWM.


## Resources
* [WS2812B data sheet](https://cdn-shop.adafruit.com/datasheets/WS2812.pdf)
