add(A+B, R) :-
    number(A), number(B),
    R is A+B.

subtract(A-B, R) :-
    number(A), number(B),
    R is A-B.