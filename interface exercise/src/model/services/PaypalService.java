package model.services;

public class PaypalService implements OnlinePaymentService {

    private static final double FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public Double paymentFee(Double amount){
        return amount * FEE;
    }
    @Override
    public Double interest(Double amount, Integer months){
        return amount * months * MONTHLY_INTEREST;
    }
}
