package cc.tkmr.labdesignpatternsspringproject.services;

import cc.tkmr.labdesignpatternsspringproject.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client HTTP, created via <b>OpenFeign</b>, for <b>ViaCEP</b> API consumption.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{cep}/json/")
	Address consultCep(@PathVariable("cep") String cep);
}
