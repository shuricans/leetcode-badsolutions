package no.war.leetcode.problems.generateParentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static no.war.leetcode.problems.generateParentheses.Solution.generateParenthesis;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void generateParenthesisTest(int n, List<String> expected) {
        assertThat(generateParenthesis(n)).containsExactlyInAnyOrderElementsOf(expected);
    }

    public static Stream<Arguments> generateParenthesisTest() {
        return Stream.of(
                Arguments.of(1,
                        List.of("()")),
                Arguments.of(2,
                        List.of("(())", "()()")),
                Arguments.of(3,
                        List.of("((()))", "()()()", "(()())", "(())()", "()(())")),
                Arguments.of(4,
                        List.of("()()()()",
                                "(())(())",
                                "()((()))", "((()))()",
                                "(())()()", "()(())()", "()()(())",
                                "(()())()", "()(()())",
                                "(((())))",
                                "(()()())",
                                "((()()))",
                                "((())())", "(()(()))"))
        );
    }
}