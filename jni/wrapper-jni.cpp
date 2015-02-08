#include <iostream>
#include <jni.h>
#include <calculator.h>
#include <android/log.h>

using namespace std;

extern "C" {
    JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_sum(JNIEnv* env, jobject obj, jfloat a, jfloat b);
};

jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env;
    if (vm->GetEnv((void**) &env, JNI_VERSION_1_6) != JNI_OK)
        return -1;
    return JNI_VERSION_1_6;
}

JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_sum(JNIEnv* env, jobject obj, jfloat a, jfloat b)
{
    Calculator* calculator = new Calculator();
    return calculator->sum(a, b);
}
