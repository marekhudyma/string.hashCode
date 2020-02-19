package com.marekhudyma.hashcode;


import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class HashOfEnglishWordsTest {

    public final static String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Curabitur pretium tincidunt lacus. Nulla gravida orci a odio. Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris. Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam. Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo eget, consequat quis, neque. Aliquam faucibus, elit ut dictum aliquet, felis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras mollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue lorem, dapibus quis, laoreet et, pretium ac, nisi. Aenean magna nisl, mollis quis, molestie eu, feugiat in, orci. In hac habitasse platea dictumst.";

    public final static String LOREM_IPSUM_HASHCODE_ZERO = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Curabitur pretium tincidunt lacus. Nulla gravida orci a odio. Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris. Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam. Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo eget, consequat quis, neque. Aliquam faucibus, elit ut dictum aliquet, felis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras mollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue lorem, dapibus quis, laoreet et, pretium ac, nisi. Aenean magna nisl, mollis quis, molestie eu, feugiat in, orci. In hac habitasse platea dictumst.72098087";

    @Test
    void shouldFindAnyHashCodeZero() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(getPathFromResources("words.txt")))) {
            stream.forEach(line -> {
                if (line.hashCode() == 0) {
                    System.out.println(line);
                }
            });
        }
    }

    // Lorem ipsum hashCode = 0 for 72098087
    @Test
    void shouldFindHashOLoremIpsumInNaiveBruteForceWay() throws Exception {
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            String str = LOREM_IPSUM + i;
            if (str.hashCode() == 0) {
                System.out.println("Lorem ipsum hashCode = 0 for " + i);
            }
        }
    }

    @Test
    void shouldFindHashOfBiWordsInNaiveBruteForceWay() throws Exception {
        List<String> words;
        try (Stream<String> stream = Files.lines(Paths.get(getPathFromResources("words.txt")))) {
            words = stream.collect(Collectors.toList());
        }
        long i = 0;
        for (String word1 : words) {
            for (String word2 : words) {
                String str = word1 + " " + word2;
                if (str.hashCode() == 0) {
                    System.out.println(str);
                }
                i++;
            }
        }

    }

    @Test
    void shouldHashCodeBeEqualToZero() {
        String str = "Airlia unhallow";
        assertThat(str.hashCode()).isEqualTo(0);
    }

    @Test
    void shouldLoremIpsumHashCodeBeEqualToZero() {
        assertThat(LOREM_IPSUM_HASHCODE_ZERO.hashCode()).isEqualTo(0);
    }

    @Test
    void shouldHashCodeNotBeEqualToZero() {
        String str = "normalString";
        assertThat(str.hashCode()).isNotEqualTo(0);
    }

    private String getPathFromResources(String fileName) {
        try {
            return Paths.get(HashOfEnglishWordsTest.class.getClassLoader().getResource(fileName).toURI()).toAbsolutePath().toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
