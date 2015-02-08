#include <iostream>
#include <jni.h>
#include <calculator.h>
#include <android/log.h>

using namespace std;

Calculator* calculator;

extern "C" {
    JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_sum(JNIEnv* env, jobject obj, jfloat a, jfloat b);
    JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_sub(JNIEnv* env, jobject obj, jfloat a, jfloat b);
    JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_mult(JNIEnv* env, jobject obj, jfloat a, jfloat b);
    JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_div(JNIEnv* env, jobject obj, jfloat a, jfloat b);
};

jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env;
    calculator = new Calculator();
    if (vm->GetEnv((void**) &env, JNI_VERSION_1_6) != JNI_OK)
        return -1;
    return JNI_VERSION_1_6;
}

JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_sum(JNIEnv* env, jobject obj, jfloat a, jfloat b)
{
    return calculator->sum(a, b);
}

JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_sub(JNIEnv* env, jobject obj, jfloat a, jfloat b)
{
    return calculator->sub(a, b);
}

JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_mult(JNIEnv* env, jobject obj, jfloat a, jfloat b)
{
    return calculator->mult(a, b);
}

JNIEXPORT jfloat JNICALL Java_com_example_androidcplusplus_Calculator_div(JNIEnv* env, jobject obj, jfloat a, jfloat b)
{
    return calculator->div(a, b);
}
