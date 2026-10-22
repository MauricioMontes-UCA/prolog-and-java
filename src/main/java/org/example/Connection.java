package org.example;

import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

import java.io.InputStream;

public class Connection {
    private final Prolog engine = new Prolog();

    public Connection() throws Exception {
        try (InputStream in = getClass().getResourceAsStream("/adder.pl")){
            if (in == null) throw new IllegalStateException("File 'adder.pl' not found");
            engine.setTheory(new Theory(in));
        }
    }

    public String consult(String predicate, String expression) throws Exception {
        SolveInfo info = engine.solve(predicate + "(" + expression + ", R).");
        return info.isSuccess() ? info.getTerm("R").toString() : "No solution for that expression";
    }
}
