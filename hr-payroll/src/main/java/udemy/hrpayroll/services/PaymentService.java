package udemy.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import udemy.hrpayroll.entities.Payment;
import udemy.hrpayroll.entities.Worker;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days){
        Worker worker = restTemplate.getForObject(this.workerHost + "/workers/" + workerId, Worker.class);
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
