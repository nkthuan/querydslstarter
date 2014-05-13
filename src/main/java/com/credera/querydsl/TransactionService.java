package com.credera.querydsl;

import com.mysema.query.types.expr.BooleanExpression;

public class TransactionService {
    
    private TransactionRepository repository;
    
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
    
    public Iterable<Transaction> findAll() {
        QTransaction tr = QTransaction.transaction;
        
        //include always true predicate as a building point
        return findAll(tr.isNotNull());
    }
    
    public Iterable<Transaction> findAll(BooleanExpression expression) {
        QTransaction tr = QTransaction.transaction;
        
        //need a valid predicate, include always true predicate as a building point
        if(expression == null) {
            expression = tr.isNotNull();
        }
        
        //filter results limited to current authenticated user without caller needed to have knowledge of this
        expression = expression.and(tr.customer.username.eq(UserService.getCurrentUser()));
        
        return repository.findAll(expression);
    }
  
    /* There are many other variations on find* including those with pageables, sort, etc
     * which you would need to expose at the service layer if there were an actual application.
     * We are only including findAll for demo purposes.
     */
    
}
