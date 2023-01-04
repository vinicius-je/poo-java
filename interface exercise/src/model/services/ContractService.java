package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService ops;

    public ContractService(OnlinePaymentService ops){
        this.ops = ops;
    }
    
    public void processContract(Contract contract, Integer months){
        double valuePerMonth = contract.getTotalValue() / months;
        for(int i = 1; i <= months; i++){
            double interest = valuePerMonth + ops.interest(valuePerMonth, i);
            double amount = interest + ops.paymentFee(interest);
            contract.getInstallments().add(new Installment(contract.getDate().plusMonths(i), amount));
        }
    }
}
