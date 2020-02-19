package com.marekhudyma.hashcode;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import static com.marekhudyma.hashcode.HashOfEnglishWordsTest.LOREM_IPSUM;
import static com.marekhudyma.hashcode.HashOfEnglishWordsTest.LOREM_IPSUM_HASHCODE_ZERO;

//Benchmark                                                                                                             Mode      Cnt    Score    Error   Units
//ApplicationBenchmark.testHashSetLoremIpsumInsertion                                                                  thrpt       25  101.870 ±  4.409  ops/us
//ApplicationBenchmark.testHashSetNormalStringInsertion                                                                thrpt       25  103.294 ±  6.563  ops/us
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion                                                      thrpt       25   94.377 ± 16.024  ops/us
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion                                                           thrpt       25    0.990 ±  0.001  ops/us
//ApplicationBenchmark.testHashSetLoremIpsumInsertion                                                                   avgt       25    0.009 ±  0.001   us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion                                                                 avgt       25    0.009 ±  0.001   us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion                                                       avgt       25    0.013 ±  0.004   us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion                                                            avgt       25    1.011 ±  0.001   us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion                                                                 sample  9041867    0.048 ±  0.001   us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.00                            sample             0.002            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.50                            sample             0.042            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.90                            sample             0.051            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.95                            sample             0.052            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.99                            sample             0.058            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.999                           sample             0.160            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p0.9999                          sample            17.178            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion:testHashSetLoremIpsumInsertion·p1.00                            sample            74.368            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion                                                               sample  8207732    0.051 ±  0.001   us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.00                        sample             0.001            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.50                        sample             0.045            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.90                        sample             0.051            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.95                        sample             0.054            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.99                        sample             0.065            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.999                       sample             0.182            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p0.9999                      sample            19.936            us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion:testHashSetNormalStringInsertion·p1.00                        sample            80.896            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion                                                     sample  9525368    0.048 ±  0.001   us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.00    sample             0.001            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.50    sample             0.044            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.90    sample             0.049            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.95    sample             0.050            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.99    sample             0.055            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.999   sample             0.159            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p0.9999  sample            16.736            us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion:testHashSetStringWithHashCodeZeroInsertion·p1.00    sample           200.704            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion                                                          sample  7671707    1.066 ±  0.001   us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.00              sample             0.686            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.50              sample             1.024            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.90              sample             1.038            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.95              sample             1.048            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.99              sample             1.104            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.999             sample            19.424            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p0.9999            sample            32.096            us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion:testHashSetUnluckyLorenIpsumInsertion·p1.00              sample           215.296            us/op
//ApplicationBenchmark.testHashSetLoremIpsumInsertion                                                                     ss        5   35.012 ± 24.664   us/op
//ApplicationBenchmark.testHashSetNormalStringInsertion                                                                   ss        5   23.988 ± 29.347   us/op
//ApplicationBenchmark.testHashSetStringWithHashCodeZeroInsertion                                                         ss        5   25.678 ± 34.261   us/op
//ApplicationBenchmark.testHashSetUnluckyLorenIpsumInsertion                                                              ss        5   36.030 ± 30.358   us/op

@State(Scope.Benchmark)
public class ApplicationBenchmark {

    //private HashSet<String> underTest;
    private HashMap<String, Integer> underTest;

    @Setup
    public void init() {
        underTest = new HashMap<>();
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testHashSetNormalStringInsertion(Blackhole blackhole) {
        blackhole.consume(underTest.put("normalString", 1));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testHashSetStringWithHashCodeZeroInsertion(Blackhole blackhole) {
        blackhole.consume(underTest.put("Airlia unhallow", 1));
    }


    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testHashSetLoremIpsumInsertion(Blackhole blackhole) {
        blackhole.consume(underTest.put(LOREM_IPSUM, 1));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testHashSetUnluckyLorenIpsumInsertion(Blackhole blackhole) {
        blackhole.consume(underTest.put(LOREM_IPSUM_HASHCODE_ZERO, 1));
    }



}
