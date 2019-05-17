package com.ljheee.cache;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Spel 表达式解析
 *
 */
public class SpelParser {


    public static String getKey(String key, String[] parameterNames, Object[] args) {

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(key);

        EvaluationContext context = new StandardEvaluationContext();

        for (int i = 0; i < args.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }
        return expression.getValue(context, String.class);
    }


}
