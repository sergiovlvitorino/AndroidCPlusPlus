LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := calculator
LOCAL_C_INCLUDES := ../native/ \

LOCAL_SRC_FILES := \
../native/calculator.cpp \
wrapper-jni.cpp \

LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)