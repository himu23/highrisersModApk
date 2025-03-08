package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.h0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface c1 {
    i a() throws IOException;

    @Deprecated
    <T> T a(d1<T> d1Var, q qVar) throws IOException;

    @Deprecated
    <T> T a(Class<T> cls, q qVar) throws IOException;

    void a(List<Long> list) throws IOException;

    @Deprecated
    <T> void a(List<T> list, d1<T> d1Var, q qVar) throws IOException;

    <K, V> void a(Map<K, V> map, h0.a<K, V> aVar, q qVar) throws IOException;

    int b() throws IOException;

    <T> T b(d1<T> d1Var, q qVar) throws IOException;

    <T> T b(Class<T> cls, q qVar) throws IOException;

    void b(List<String> list) throws IOException;

    <T> void b(List<T> list, d1<T> d1Var, q qVar) throws IOException;

    int c() throws IOException;

    void c(List<Integer> list) throws IOException;

    int d() throws IOException;

    void d(List<Float> list) throws IOException;

    int e();

    void e(List<Integer> list) throws IOException;

    long f() throws IOException;

    void f(List<Integer> list) throws IOException;

    long g() throws IOException;

    void g(List<Long> list) throws IOException;

    double h() throws IOException;

    void h(List<i> list) throws IOException;

    void i(List<Integer> list) throws IOException;

    boolean i() throws IOException;

    int j() throws IOException;

    void j(List<Double> list) throws IOException;

    float k() throws IOException;

    void k(List<Long> list) throws IOException;

    long l() throws IOException;

    void l(List<Boolean> list) throws IOException;

    int m() throws IOException;

    void m(List<Long> list) throws IOException;

    String n() throws IOException;

    void n(List<Long> list) throws IOException;

    long o() throws IOException;

    void o(List<Integer> list) throws IOException;

    String p() throws IOException;

    void p(List<Integer> list) throws IOException;

    int q() throws IOException;

    void q(List<String> list) throws IOException;

    boolean r() throws IOException;

    int s() throws IOException;

    long t() throws IOException;
}
