public aspect SaldoAspect {
    pointcut saqueOperation(): execution(* ContaBancaria.sacar(double));
    
    before(): saqueOperation() {
        double saldo = ((ContaBancaria) thisJoinPoint.getTarget()).getSaldo();
        double valorSaque = ((ContaBancaria) thisJoinPoint.getTarget()).getValorSaque();
        
        if (saldo < valorSaque) {
            System.out.println("Saldo insuficiente para a operação de saque.");
        }
    }
}