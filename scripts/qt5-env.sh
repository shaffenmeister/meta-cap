#!/bin/sh

export PATH=${PATH}:/usr/bin/qt5
export QT_DEBUG_PLUGINS=1

export QWS_MOUSE_PROTO=Tslib:/dev/input/touchscreen0
export QT_QPA_PLATFORM=linuxfb:fb=/dev/fb1
export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/touchscreen0:rotate=00
export QT_QPA_GENERIC_PLUGINS=tslib
export QT_QPA_FB_TSLIB=1
export QT_QPA_FB_DISABLE_INPUT=1
export TSLIB_FBDEVICE=/dev/fb1
export TSLIB_TSDEVICE=/dev/input/touchscreen0
#QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/event1:rotate=180
#QT_QPA_FB_NO_LIBINPUT=1

export TSLIB_TSEVENTTYPE=INPUT
export TSLIB_TSDEVICE=/dev/input/touchscreen0
export TSLIB_CALIBFILE=/etc/pointercal
export TSLIB_CONFFILE=/etc/ts.conf
export TSLIB_PLUGINDIR=/usr/lib/ts
export TSLIB_FBDEVICE=/dev/fb1
export TSLIB_CONSOLEDEVICE=none
