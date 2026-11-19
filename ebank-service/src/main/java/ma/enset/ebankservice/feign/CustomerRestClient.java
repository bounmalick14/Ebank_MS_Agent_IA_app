package ma.enset.ebankservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.enset.ebankservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
@CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
public interface CustomerRestClient {
    @GetMapping("customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id, Exception e){
        return new Customer(id,"Not Evalable","Not Evailable");
    }
}


