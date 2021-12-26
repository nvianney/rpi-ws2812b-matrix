# rpi-ws2812b-matrix

## Introduction
A 12x6 grid of WS2812B LEDs was built on a wooden board. Each LED is run in parallel with a maximum amperage usage of 60mA and so the total amperage
required by the power supply is 4.32A. The color of LEDs are controlled by GPIO 18 (PWM) connected to the data line input of the board.

This program is built to control the color of LEDs. It is dependent on the Adafruit NeoPixels library for Python. The intention is to write a
backend server in Kotlin to allow the LEDs to be controlled on a website and to write a game in Kotlin / C++ that outputs color to the pixels. To avoid
having to write a custom hardware library for each language to write to the GPIO pins, this project performs socket programming with Python as
the server to accept LED writing requests to write to GPIO pins. gRPC is used as the underlying IPC library.

### Built with
 * Python 3.x+
 * Kotlin 1.6+ with Kotlin Coroutines
 * gRPC / Protobuf
